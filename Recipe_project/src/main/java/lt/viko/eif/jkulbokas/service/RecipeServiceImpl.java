package lt.viko.eif.jkulbokas.service;

import jakarta.transaction.Transactional;
import lt.viko.eif.jkulbokas.client.MealDbClient;
import lt.viko.eif.jkulbokas.dto.mealDbDTO.ExternalRecipeDTO;
import lt.viko.eif.jkulbokas.dto.mealDbDTO.MealDbResponseDTO;
import lt.viko.eif.jkulbokas.dto.mealDbDTO.RecipeDTO;
import lt.viko.eif.jkulbokas.dto.mealDbDTO.RecipeDetailsDTO;
import lt.viko.eif.jkulbokas.entity.SavedRecipe;
import lt.viko.eif.jkulbokas.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service implementation related to TheMealDB
 */
@Service
public class RecipeServiceImpl implements RecipeService {

    private final MealDbClient mealDbClient;
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(MealDbClient mealDbClient, RecipeRepository recipeRepository) {

        this.mealDbClient = mealDbClient;
        this.recipeRepository = recipeRepository;
    }

    /**
     * Method that makes a http request to TheMealDB using the recipe name
     * and adds them to RecipeDTO for future use
     * @param recipeName the recipe name used in the search
     * @return the searched recipes
     */
    @Override
    public List<RecipeDTO> searchRecipes(String recipeName) {

        MealDbResponseDTO response = mealDbClient.searchRecipes(recipeName);

        List<RecipeDTO> recipes = new ArrayList<>();

        if(response == null || response.getMeals() == null){
            return recipes;
        }

        for(ExternalRecipeDTO recipe : response.getMeals()) {

            recipes.add(new RecipeDTO(
                            recipe.getIdMeal(),
                            recipe.getStrMeal(),
                            recipe.getStrCategory(),
                            recipe.getStrMealThumb())
            );
        }

        return recipes;
    }

    /**
     * Method that makes a http request to TheMealDB using the id
     * and adds them to RecipeDetailsDTO for future use
     * @param mealDbId the recipe id used in the search
     * @return the searched recipe
     */
    @Override
    public RecipeDetailsDTO getRecipeDetails(String mealDbId) {

        MealDbResponseDTO response = mealDbClient.getRecipeById(mealDbId);

        if(response == null || response.getMeals() == null || response.getMeals().isEmpty()) {
            return null;
        }

        ExternalRecipeDTO recipe = response.getMeals().get(0);

        return new RecipeDetailsDTO(
                recipe.getIdMeal(),
                recipe.getStrMeal(),
                recipe.getStrCategory(),
                recipe.getStrArea(),
                recipe.getStrInstructions(),
                recipe.getStrMealThumb()
        );
    }

    /**
     * Method that checks if the recipe is already saved and
     * makes sure that it doesn't add the same recipe twice
     * and adds them to RecipeDTO for future use.
     * Makes a http request using the id.
     * Adds the recipe to the database
     * @param mealDbId the recipe id used in the operation
     * @return saved recipe
     */
    @Override
    public RecipeDTO saveRecipe(String mealDbId) {

        if(recipeRepository.existsByMealDbId(mealDbId)) {

            SavedRecipe existingRecipe = recipeRepository.findByMealDbId(mealDbId).orElseThrow();
            return new RecipeDTO(
                    existingRecipe.getMealDbId(),
                    existingRecipe.getName(),
                    existingRecipe.getCategory(),
                    existingRecipe.getImageUrl()
            );
        }

        MealDbResponseDTO response = mealDbClient.getRecipeById(mealDbId);

        if(response == null || response.getMeals() == null || response.getMeals().isEmpty()) {
            return null;
        }

        ExternalRecipeDTO externalRecipe = response.getMeals().get(0);

        SavedRecipe recipe = new SavedRecipe(
                externalRecipe.getIdMeal(),
                externalRecipe.getStrMeal(),
                externalRecipe.getStrCategory(),
                externalRecipe.getStrArea(),
                externalRecipe.getStrMealThumb(),
                externalRecipe.getStrInstructions()
        );

        SavedRecipe savedRecipe = recipeRepository.save(recipe);

        return new RecipeDTO(
                savedRecipe.getMealDbId(),
                savedRecipe.getName(),
                savedRecipe.getCategory(),
                savedRecipe.getImageUrl()
        );
    }

    /**
     * Method that gets the saved recipes from the database
     * and adds the saved recipes to RecipeDTO for future use
     * @return the saved recipes
     */
    @Override
    public List<RecipeDTO> getSavedRecipes() {

        List<SavedRecipe> savedRecipes = recipeRepository.findAll();

        List<RecipeDTO> recipes = new ArrayList<>();

        for(SavedRecipe recipe : savedRecipes){

            recipes.add(new RecipeDTO(
                            recipe.getMealDbId(),
                            recipe.getName(),
                            recipe.getCategory(),
                            recipe.getImageUrl())
            );
        }

        return recipes;
    }

    /**
     * Method that deletes a saved recipe from the database
     * @param mealDbId the id used for detecting the recipe
     */
    @Override
    @Transactional
    public void deleteRecipe(String mealDbId) {

        SavedRecipe recipe = recipeRepository.findByMealDbId(mealDbId).orElseThrow(() -> new RuntimeException("Recipe not found"));

        recipeRepository.delete(recipe);
    }
}
