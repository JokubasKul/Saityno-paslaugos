package lt.viko.eif.jkulbokas.POJO_classes;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.util.List;

@Entity
@XmlRootElement(name="library")
@XmlAccessorType(XmlAccessType.FIELD)
public class Library {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @XmlTransient
    private Long id;

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
