package lt.viko.eif.jkulbokas;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name="library")
@XmlAccessorType(XmlAccessType.FIELD)
public class LibraryWrapper {

    @XmlElement(name="shelf")
    private List<lt.viko.client.Shelf> shelves;

    public List<lt.viko.client.Shelf> getShelves(){
        return shelves;
    }

    public void setShelves(List<lt.viko.client.Shelf> shelves){
        this.shelves=shelves;
    }
}
