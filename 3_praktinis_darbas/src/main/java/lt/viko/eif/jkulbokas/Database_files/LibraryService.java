package lt.viko.eif.jkulbokas.Database_files;

import lt.viko.eif.jkulbokas.POJO_classes.Book;
import lt.viko.eif.jkulbokas.POJO_classes.Library;
import lt.viko.eif.jkulbokas.POJO_classes.Shelf;
import org.springframework.stereotype.Service;

/**
 * Service class responsible for saving all the unmarshalled xml data to the database
 */
@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    /**
     * Saves all unmarshalled xml data to the database
     */
    public void saveLibrary(Library library) {

        for (Shelf shelf : library.getShelf()) {
            shelf.setLibrary(library);
            for (Book book : shelf.getBooks()) {
                book.setShelf(shelf);
            }
        }
        libraryRepository.save(library);
    }
}
