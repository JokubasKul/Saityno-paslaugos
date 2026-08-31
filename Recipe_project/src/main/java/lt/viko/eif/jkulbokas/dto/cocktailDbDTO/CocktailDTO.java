package lt.viko.eif.jkulbokas.dto.cocktailDbDTO;

/**
 * DTO responsible for getting the names used in TheCocktailDB
 */
public class CocktailDTO {

    private String idDrink;
    private String strDrink;
    private String strDrinkThumb;

    public CocktailDTO(){}

    public CocktailDTO(String idDrink, String strDrink, String strDrinkThumb){
        this.idDrink=idDrink;
        this.strDrink=strDrink;
        this.strDrinkThumb=strDrinkThumb;
    }

    public String getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(String idDrink) {
        this.idDrink = idDrink;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public void setStrDrinkThumb(String strDrinkThumb) {
        this.strDrinkThumb = strDrinkThumb;
    }
}
