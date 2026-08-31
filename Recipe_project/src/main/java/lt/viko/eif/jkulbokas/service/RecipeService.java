package lt.viko.eif.jkulbokas.service;

import lt.viko.eif.jkulbokas.dto.mealDbDTO.RecipeDTO;
import lt.viko.eif.jkulbokas.dto.mealDbDTO.RecipeDetailsDTO;

import java.util.List;

/**
 * Defines the recipe service
 */
public interface RecipeService {

    List<RecipeDTO> searchRecipes(String recipeName);

    RecipeDetailsDTO getRecipeDetails(String mealDbId);

    RecipeDTO saveRecipe(String mealDbId);

    List<RecipeDTO> getSavedRecipes();

    void deleteRecipe(String mealDbId);
}