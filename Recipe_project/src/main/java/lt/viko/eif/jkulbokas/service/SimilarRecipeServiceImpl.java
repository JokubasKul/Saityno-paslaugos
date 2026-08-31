package lt.viko.eif.jkulbokas.service;

import lt.viko.eif.jkulbokas.client.MealDbClient;
import lt.viko.eif.jkulbokas.client.SpoonacularClient;
import lt.viko.eif.jkulbokas.dto.mealDbDTO.ExternalRecipeDTO;
import lt.viko.eif.jkulbokas.dto.mealDbDTO.MealDbResponseDTO;
import lt.viko.eif.jkulbokas.dto.spoonacularDTO.SimilarRecipeDTO;
import lt.viko.eif.jkulbokas.dto.spoonacularDTO.SpoonacularResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service implementation related to Spoonacular
 */
@Service
public class SimilarRecipeServiceImpl implements SimilarRecipeService {

    private final MealDbClient mealDbClient;
    private final SpoonacularClient spoonacularClient;

    public SimilarRecipeServiceImpl(
            MealDbClient mealDbClient,
            SpoonacularClient spoonacularClient) {

        this.mealDbClient = mealDbClient;
        this.spoonacularClient = spoonacularClient;
    }

    /**
     * Method that gets the similar recipes
     * @param mealDbId the recipe's id
     * @return the similar recipes
     */
    @Override
    public List<SimilarRecipeDTO> getSimilarRecipes(String mealDbId) {

        MealDbResponseDTO mealResponse = mealDbClient.getRecipeById(mealDbId);

        if (mealResponse == null || mealResponse.getMeals() == null || mealResponse.getMeals().isEmpty()) {
            return List.of();
        }

        ExternalRecipeDTO meal = mealResponse.getMeals().get(0);

        String query = buildSimilarQuery(meal);

        SpoonacularResponseDTO spoonResponse = spoonacularClient.searchRecipes(query);

        if (spoonResponse == null || spoonResponse.getResults() == null) {
            return List.of();
        }

        List<SimilarRecipeDTO> result = new ArrayList<>();

        for (SimilarRecipeDTO recipe : spoonResponse.getResults()) {

            result.add(new SimilarRecipeDTO(
                            recipe.getId(),
                            recipe.getTitle(),
                            recipe.getImage())
            );
        }

        return result;
    }

    /**
     * Builds the query needed to find the similar recipes
     * @param meal the recipe's name
     * @return the name and the ingredients
     */
    private String buildSimilarQuery(ExternalRecipeDTO meal) {

        String name = meal.getStrMeal();

        List<String> ingredients = extractIngredients(meal);
        String topIngredients = String.join(" ", ingredients.stream().limit(3).toList());

        return (name + " " + topIngredients).trim();
    }

    /**
     * Method that gets 5 ingredients from the meal
     * @param meal the recipe's identifier
     * @return the ingredients
     */
    private List<String> extractIngredients(ExternalRecipeDTO meal) {

        List<String> ingredients = new ArrayList<>();

        for (int i=1; i<=10; i++) {

            try {
                String value = (String)ExternalRecipeDTO.class.getMethod("getStrIngredient" + i).invoke(meal);

                if (value!=null && !value.isBlank() && !value.equalsIgnoreCase("null")) {
                    ingredients.add(value.trim());
                }

            }
            catch (Exception ignored) {
            }
        }

        return ingredients;
    }
}
