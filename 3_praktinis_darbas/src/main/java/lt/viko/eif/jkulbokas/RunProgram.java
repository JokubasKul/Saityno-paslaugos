package lt.viko.eif.jkulbokas;

import lt.viko.eif.jkulbokas.Database_files.LibraryService;
import lt.viko.eif.jkulbokas.POJO_classes.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Component responsible for transforming the xml data into POJO data
 * that gets sent to the database
 */
@Component
public class RunProgram implements CommandLineRunner {

    /**
     * Calls upon the libraryService service
     */
    @Autowired
    LibraryService libraryService;

    /**
     * Calls upon the transformService service
     */
    @Autowired
    TransformService transformService;

    /**
     * Method that takes the xml and xsd files
     * sends them both to a unmarshaller "transformToPOJO"
     * and saved the data to the database
     */
    @Override
    public void run(String... args) throws Exception {


        File xmlFile= new File("src/main/java/lt/viko/eif/jkulbokas/Xml_files/library.xml");
        File xsdFile= new File("src/main/java/lt/viko/eif/jkulbokas/xml_files/library.xsd");

        Library library = transformService.transformToPOJO(xmlFile, xsdFile);

        libraryService.saveLibrary(library);
        System.out.println();
        System.out.println();
        System.out.println("Unmarshalled data saved to database.");
        System.out.println();
    }
}
