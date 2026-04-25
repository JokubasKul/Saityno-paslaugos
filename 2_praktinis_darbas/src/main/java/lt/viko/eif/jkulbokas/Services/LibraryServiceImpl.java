package lt.viko.eif.jkulbokas.Services;

import jakarta.jws.WebService;
import lt.viko.eif.jkulbokas.Database_files.BookRepository;
import lt.viko.eif.jkulbokas.Database_files.ShelfRepository;
import lt.viko.eif.jkulbokas.POJO_classes.Book;
import lt.viko.eif.jkulbokas.POJO_classes.Shelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@WebService(endpointInterface = "lt.viko.eif.jkulbokas.Services.LibraryService")
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private ShelfRepository shelfRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Shelf> getAllShelves() {
        List<Shelf> shelves = shelfRepository.findAll();

        shelves.forEach(s -> s.getBooks().size());

        return shelves;
    }
    @Override
    public List<Book> getBooksByCategory(String category){
        return bookRepository.findByShelfCategory(category);
    }
    @Override
    public Book getBookByTitle(String title){
        return bookRepository.findByTitle(title);
    }
}
