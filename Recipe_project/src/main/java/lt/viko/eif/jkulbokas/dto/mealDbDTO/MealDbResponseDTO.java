package lt.viko.eif.jkulbokas.dto.mealDbDTO;

import java.util.List;

/**
 * DTO responsible for wrapping the TheMealDB response's data
 */
public class MealDbResponseDTO {

    private List<ExternalRecipeDTO> meals;

    public MealDbResponseDTO() {
    }

    public List<ExternalRecipeDTO> getMeals() {
        return meals;
    }

    public void setMeals(
            List<ExternalRecipeDTO> meals) {

        this.meals = meals;
    }
}
