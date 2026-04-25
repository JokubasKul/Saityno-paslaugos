package lt.viko.eif.jkulbokas.POJO_classes;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.util.List;

@Entity
@XmlRootElement(name="shelf")
@XmlAccessorType(XmlAccessType.FIELD)
public class Shelf {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @XmlTransient
    private long id;

    @ManyToOne
    @JoinColumn(name="library_id")
    @XmlTransient
    private Library library;

    @XmlElement(name="category")
    private String category;

    @XmlElementWrapper(name="books")
    @XmlElement(name="book")
    @OneToMany(mappedBy = "shelf", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
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
