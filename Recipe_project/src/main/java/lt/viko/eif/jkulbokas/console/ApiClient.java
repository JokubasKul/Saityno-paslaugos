package lt.viko.eif.jkulbokas.console;

import lt.viko.eif.jkulbokas.dto.cocktailDbDTO.CocktailDTO;
import lt.viko.eif.jkulbokas.dto.mealDbDTO.RecipeDTO;
import lt.viko.eif.jkulbokas.dto.mealDbDTO.RecipeDetailsDTO;
import lt.viko.eif.jkulbokas.dto.spoonacularDTO.SimilarRecipeDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

/**
 * Class that stores the http requests
 */
@Component
public class ApiClient {

    private final WebClient webClient;

    public ApiClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8080").build();
    }

    /**
     * Send a http request to the Rest API
     * Finds recipes based on the recipe name
     * @param recipeName the recipe name used in the search
     * @return a list of recipes that match recipeName
     */
    public List<RecipeDTO> searchRecipes(String recipeName) {

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/recipes/search")
                        .queryParam("name", recipeName)
                        .build())
                .retrieve().bodyToFlux(RecipeDTO.class).collectList().block();
    }
    /**
     * Send a http request to the Rest API
     * Shows detailed information of the recipe
     * @param mealDbId the recipe id used in the search
     * @return the details of the recipe
     */
    public RecipeDetailsDTO viewRecipe(String mealDbId) {

        return webClient.get()
                .uri("/recipes/{mealDbId}", mealDbId)
                .retrieve().bodyToMono(RecipeDetailsDTO.class).block();
    }
    /**
     * Send a http request to the Rest API
     * Saves a recipe in the database
     * @param mealDbId the recipe name used for identifying
     * the recipe for saving
     * @return the saved recipe
     */
    public RecipeDTO saveRecipe(String mealDbId) {

        return webClient.post()
                .uri("/recipes/save/{mealDbId}", mealDbId)
                .retrieve().bodyToMono(RecipeDTO.class).block();
    }
    /**
     * Send a http request to the Rest API
     * Gets all saved recipes
     * @return a list of saved recipes
     */
    public List<RecipeDTO> getSavedRecipes() {

        return webClient.get()
                .uri("/recipes/saved")
                .retrieve().bodyToFlux(RecipeDTO.class).collectList().block();
    }
    /**
     * Send a http request to the Rest API
     * Deletes a recipe from the database
     * @param mealDbId the recipe id used for identifying the recipe
     */
    public void deleteSavedRecipe(String mealDbId) {

        webClient.delete()
                .uri("/recipes/saved/delete/{mealDbId}", mealDbId)
                .retrieve().toBodilessEntity().block();
    }
    /**
     * Send a http request to the Rest API
     * Gets similar recipes
     * @param mealDbId the recipe id used in the search
     * @return a list of similar recipes
     */
    public List<SimilarRecipeDTO> getSimilarRecipes(String mealDbId) {

        return webClient.get()
                .uri("/recipes/{mealDbId}/similar", mealDbId)
                .retrieve().bodyToFlux(SimilarRecipeDTO.class).collectList().block();
    }
    /**
     * Send a http request to the Rest API
     * Gets drinks
     * @param mealDbId the recipe id used in the search
     * @return a list of drinks
     */
    public List<CocktailDTO> getRecommendedDrinks(String mealDbId) {

        return webClient.get()
                .uri("/recipes/{mealDbId}/drinks", mealDbId)
                .retrieve().bodyToFlux(CocktailDTO.class).collectList().block();
    }
}