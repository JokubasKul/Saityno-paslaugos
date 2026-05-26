package lt.viko.eif.jkulbokas.POJO_classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 * POJO containing all the data in a book
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

    /**
     * Id that is assigned when the data from the xml is added to the database
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private long id;

    /**
     * Creates a many-to-one relationship with the shelf class
     */
    @ManyToOne
    @JoinColumn(name="shelf_id")
    @XmlTransient
    @JsonIgnore
    private Shelf shelf;

    /**
     * Title of the book
     */
    @XmlElement(name="title")
    private String title;
    /**
     * Release year of the book
     */
    @XmlElement(name="release_year")
    private int release_year;
    /**
     * Author of the book
     */
    @XmlElement(name="author")
    private String author;

    public String getTitle() {return title;}
    public void setTitle(String title) {
        this.title = title;
    }

    public int getRelease_year() {
        return release_year;
    }
    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public Shelf getShelf() {return shelf;}
    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }
}
