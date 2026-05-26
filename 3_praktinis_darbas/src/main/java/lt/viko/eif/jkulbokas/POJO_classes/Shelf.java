package lt.viko.eif.jkulbokas.POJO_classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.util.List;

/**
 * POJO containing all the data in a shelf
 */
@Entity
@XmlRootElement(name="shelf")
@XmlAccessorType(XmlAccessType.FIELD)
public class Shelf {

    /**
     * Id that is assigned when the data from the xml is added to the database
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @XmlTransient
    private long id;

    /**
     * Creates a many-to-one relationship with the library class
     */
    @ManyToOne
    @JoinColumn(name="library_id")
    @XmlTransient
    @JsonIgnore
    private Library library;

    /**
     * Category of the shelf
     */
    @XmlElement(name="category")
    private String category;

    /**
     * Creates a one-to-many relationship with the book class
     */
    @XmlElementWrapper(name="books")
    @XmlElement(name="book")
    @OneToMany(mappedBy = "shelf", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Book> books;

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Library getLibrary() {
        return library;
    }
    public void setLibrary(Library library) {
        this.library = library;
    }
}
