package lt.viko.eif.jkulbokas.Database_files;

import lt.viko.eif.jkulbokas.POJO_classes.Library;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface that is responsible for connecting with the book table in the database
 */
public interface LibraryRepository extends JpaRepository<Library, Long> {
}
