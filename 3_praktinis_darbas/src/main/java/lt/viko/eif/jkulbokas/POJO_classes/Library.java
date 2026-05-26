package lt.viko.eif.jkulbokas.POJO_classes;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.util.List;

/**
 * POJO containing all the data in the library
 */
@Entity
@XmlRootElement(name="library")
@XmlAccessorType(XmlAccessType.FIELD)
public class Library {

    /**
     * Id that is assigned when the data from the xml is added to the database
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @XmlTransient
    private Long id;

    /**
     * Creates a one-to-many relationship with the shelf class
     */
    @OneToMany(mappedBy="library", cascade=CascadeType.ALL)
    @XmlElement(name="shelf")
    private List<Shelf> shelf;

    public List<Shelf> getShelf(){
        return shelf;
    }
    public void setShelf(List<Shelf> shelf){
        this.shelf=shelf;
    }
}
