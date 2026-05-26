package lt.viko.eif.jkulbokas.Database_files;

import lt.viko.eif.jkulbokas.POJO_classes.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface that is responsible for connecting with the shelf table in the database
 */
public interface ShelfRepository extends JpaRepository<Shelf, Long> {
}
