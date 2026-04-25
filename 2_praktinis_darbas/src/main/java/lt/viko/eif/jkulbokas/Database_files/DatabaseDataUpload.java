package lt.viko.eif.jkulbokas.Database_files;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import lt.viko.eif.jkulbokas.POJO_classes.Book;
import lt.viko.eif.jkulbokas.POJO_classes.Library;
import lt.viko.eif.jkulbokas.POJO_classes.Shelf;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
public class DatabaseDataUpload {

    @Bean
    CommandLineRunner loadData(ShelfRepository shelfRepository, BookRepository bookRepository) {
        return args -> {

            JAXBContext context = JAXBContext.newInstance(Library.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            InputStream inputStream =
                    getClass().getClassLoader().getResourceAsStream("library.xml");


            Library library = (Library) unmarshaller.unmarshal(inputStream);

            for (Shelf shelf : library.getShelf()) {
                Shelf savedShelf = shelfRepository.save(shelf);
                for (Book book : shelf.getBooks()) {
                    book.setShelf(savedShelf);
                    bookRepository.save(book);
                }
            }

            System.out.println("XML data loaded into database..");
        };
    }

}
