package lt.viko.eif.jkulbokas.Services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import lt.viko.eif.jkulbokas.POJO_classes.Book;
import lt.viko.eif.jkulbokas.POJO_classes.Shelf;

import java.util.List;

@WebService
public interface LibraryService {

    @WebMethod
    List<Shelf> getAllShelves();

    @WebMethod
    List<Book> getBooksByCategory(String category);

    @WebMethod
    Book getBookByTitle(String title);
}
