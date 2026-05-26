package lt.viko.eif.jkulbokas.Database_files;

import lt.viko.eif.jkulbokas.POJO_classes.Book;
import lt.viko.eif.jkulbokas.POJO_classes.Shelf;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class responsible for shelf operations
 * includes: GET, POST, PUT, DELETE methods
 */
@Service
public class ShelfService {

    private final ShelfRepository shelfRepository;

    public ShelfService(ShelfRepository shelfRepository) {
        this.shelfRepository = shelfRepository;
    }

    /**
     * Gets all shelves stored in the database
     *
     * @return all shelves
     */
    public List<Shelf> getAllShelves() {
        return shelfRepository.findAll();
    }

    /**
     * Gets a shelf by id
     *
     * @param id unique if for a shelf
     * @return a shelf by id
     */
    public Shelf getShelfById(Long id) {
        return shelfRepository.findById(id).orElse(null);
    }

    /**
     * Creates a new shelf and it's books
     *
     * @param shelf used for connecting method with the URI path
     * @return created shelf
     */
    public Shelf createShelf(Shelf shelf) {

        if (shelf.getBooks() != null) {
            for (Book book : shelf.getBooks()) {
                book.setShelf(shelf);
            }
        }

        return shelfRepository.save(shelf);
    }

    /**
     * Updates a shelf and its books
     *
     * @param id unique id for the shelf
     * @param updatedShelf used for connecting method with the URI path
     * @return updated shelf
     */
    public Shelf updateShelf(Long id, Shelf updatedShelf) {

        Shelf existing = shelfRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setCategory(updatedShelf.getCategory());
            existing.getBooks().clear();

            if (updatedShelf.getBooks() != null) {
                for (Book book : updatedShelf.getBooks()) {
                    book.setShelf(existing);
                    existing.getBooks().add(book);
                }
            }
            return shelfRepository.save(existing);
        }
        return null;
    }

    /**
     * Deletes a shelf and its books
     *
     * @param id unique id for the shelf
     */
    public void deleteShelf(Long id) {
        shelfRepository.deleteById(id);
    }
}