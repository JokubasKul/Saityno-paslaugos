package lt.viko.eif.jkulbokas.Controllers;

import lt.viko.eif.jkulbokas.Database_files.BookService;
import lt.viko.eif.jkulbokas.POJO_classes.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for all book operations
 */
@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Mapping for a method that gets all books stored in the database
     *
     * @return list of books
     */
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    /**
     * Mapping for a method that retrieves a book stored in the database by id
     *
     * @param id unique id for a book
     * @return a book
     */
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    /**
     * Mapping for a method that adds a new book
     *
     * @return created book
     */
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    /**
     * Mapping for a method that updates a book by id
     *
     * @param id unique id for a book
     * @param book used for connecting method with the URI path
     * @return updated book
     */
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    /**
     * Mapping for a method that deletes a book by id
     *
     * @param id unique id for a book
     */
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
