package lt.viko.eif.jkulbokas.Scrap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Currency {

    private String country;
    private String name;

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }
    public void setName(String currency) {
        this.name = currency;
    }
}
