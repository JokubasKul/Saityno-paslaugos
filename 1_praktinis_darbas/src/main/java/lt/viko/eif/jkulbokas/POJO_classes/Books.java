package lt.viko.eif.jkulbokas.POJO_classes;

import jakarta.xml.bind.annotation.*;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
public class Books {

    @XmlElement(name="book")
    private List<Book> book;

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }
}
