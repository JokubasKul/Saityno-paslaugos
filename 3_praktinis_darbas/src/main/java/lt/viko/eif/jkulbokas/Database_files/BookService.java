package lt.viko.eif.jkulbokas.Database_files;

import lt.viko.eif.jkulbokas.POJO_classes.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class responsible for book operations
 * includes: GET, POST, PUT, DELETE methods
 */
@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Gets all books stored in the database
     *
     * @return list of books
     */
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * Retrieves a book stored in the database by id
     *
     * @param id unique id for a book
     * @return a book
     */
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    /**
     * Adds a new book
     *
     * @return created book
     */
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * Updates a book by id
     *
     * @param id unique id for a book
     * @param updatedBook used for connecting method with the URI path
     * @return updated book
     */
    public Book updateBook(Long id, Book updatedBook) {
        Book existing = bookRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setTitle(updatedBook.getTitle());
            existing.setAuthor(updatedBook.getAuthor());
            existing.setRelease_year(updatedBook.getRelease_year());

            existing.setShelf(updatedBook.getShelf());

            return bookRepository.save(existing);
        }
        return null;
    }

    /**
     * Deletes a book by id
     *
     * @param id unique id for a book
     */
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
