package lt.viko.eif.jkulbokas.dto.cocktailDbDTO;

import java.util.List;

/**
 * DTO responsible for wrapping the TheCocktailDB response
 */
public class CocktailDbResponseDTO {

    private List<CocktailDTO> drinks;

    public CocktailDbResponseDTO(){}

    public List<CocktailDTO> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<CocktailDTO> drinks) {
        this.drinks = drinks;
    }
}
