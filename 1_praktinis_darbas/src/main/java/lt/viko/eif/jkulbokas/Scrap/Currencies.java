package lt.viko.eif.jkulbokas.Scrap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name="currencies")
@XmlAccessorType(XmlAccessType.FIELD)
public class Currencies {

    @XmlElement(name="currency")
    private List<Currency> currency;

    public List<Currency> getCurrency() {
        return currency;
    }
    public void setCurrency(List<Currency> currency) {
        this.currency = currency;
    }
}
