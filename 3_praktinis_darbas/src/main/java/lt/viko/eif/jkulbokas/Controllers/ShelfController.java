package lt.viko.eif.jkulbokas.Controllers;

import lt.viko.eif.jkulbokas.Database_files.ShelfService;
import lt.viko.eif.jkulbokas.POJO_classes.Shelf;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for all shelf operations
 */
@RestController
@RequestMapping("/shelf")
public class ShelfController {

    private final ShelfService shelfService;

    public ShelfController(ShelfService shelfService) {
        this.shelfService = shelfService;
    }

    /**
     * Mapping for a method that gets all shelves stored in the database
     *
     * @return all shelves
     */
    @GetMapping
    public List<Shelf> getAllShelves() {
        return shelfService.getAllShelves();
    }

    /**
     * Mapping for a method that gets a shelf by id
     *
     * @param id unique if for a shelf
     * @return a shelf by id
     */
    @GetMapping("/{id}")
    public Shelf getShelfById(@PathVariable Long id) {
        return shelfService.getShelfById(id);
    }

    /**
     * Mapping for a method that creates a new shelf and its books
     *
     * @param shelf used for connecting method with the URI path
     * @return created shelf
     */
    @PostMapping
    public Shelf createShelf(@RequestBody Shelf shelf) {
        return shelfService.createShelf(shelf);
    }

    /**
     * Mapping for a method that updates a shelf and its books
     *
     * @param id unique id for the shelf
     * @param shelf used for connecting method with the URI path
     * @return updated shelf
     */
    @PutMapping("/{id}")
    public Shelf updateShelf(
            @PathVariable Long id,
            @RequestBody Shelf shelf) {

        return shelfService.updateShelf(id, shelf);
    }

    /**
     * Mapping for a method that deletes a shelf and its books
     *
     * @param id unique id for the shelf
     */
    @DeleteMapping("/{id}")
    public void deleteShelf(@PathVariable Long id) {
        shelfService.deleteShelf(id);
    }
}
