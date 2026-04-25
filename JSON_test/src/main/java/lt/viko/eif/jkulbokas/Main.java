package lt.viko.eif.jkulbokas;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.*;
import java.io.*;

public class Main {
    static void main() throws IOException {

        //load json schema
        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(
                        new FileInputStream(
                                "src/main/java/lt/viko/eif/jkulbokas/json_files/library_schema.json")));
        Schema schema = SchemaLoader.load(jsonSchema);

        //load json
        JSONObject jsonFile = new JSONObject(
                new JSONTokener(
                        new FileInputStream(
                                "src/main/java/lt/viko/eif/jkulbokas/json_files/library.json")));

        //validation
        schema.validate(jsonFile);
        System.out.println("JSON is valid...");
        System.out.println();


        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(new File("src/main/java/lt/viko/eif/jkulbokas/json_files/library.json"));

        JsonNode shelves = root.get("library").get("shelf");

        for (JsonNode shelf : shelves) {
            System.out.println("Category: " + shelf.get("category").asText());
            System.out.println();

            for (JsonNode book : shelf.get("books")) {
                System.out.println("  Title: " + book.get("title").asText());
                System.out.println("  Year: "  + book.get("release_year").asInt());
                System.out.println("  Author: "+ book.get("author").asText());
                System.out.println();
            }

            System.out.println("-------------------");
        }

        JsonNode book = root.get("library").get("shelf").get(2).get("books").get(1);

        System.out.println(book.get("title").asText());
        System.out.println(book.get("release_year").asText());
        System.out.println(book.get("author").asText());

        //print whole json
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root)
        );

    }
}
