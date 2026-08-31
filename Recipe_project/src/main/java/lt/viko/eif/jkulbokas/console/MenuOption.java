package lt.viko.eif.jkulbokas.console;

import lt.viko.eif.jkulbokas.dto.cocktailDbDTO.CocktailDTO;
import lt.viko.eif.jkulbokas.dto.mealDbDTO.RecipeDTO;
import lt.viko.eif.jkulbokas.dto.mealDbDTO.RecipeDetailsDTO;
import lt.viko.eif.jkulbokas.dto.spoonacularDTO.SimilarRecipeDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Scanner;

/**
 * Class containing all the main menu's functionalities
 */
@Component
public class MenuOption {

    Scanner scanner = new Scanner(System.in);

    WebClient.Builder builder = WebClient.builder();
    ApiClient apiClient = new ApiClient(builder);

    /**
     * Searches for recipes
     */
    public void searchRecipes() {

        System.out.println("------------------------------------------------");
        System.out.println("              Recipe name: ");
        String name = scanner.nextLine();

        List<RecipeDTO> recipes = apiClient.searchRecipes(name);

        if (recipes.isEmpty()) {
            System.out.println("------------------------------------------------");
            System.out.println("          No recipes found.");
            return;
        }

        System.out.println("------------------------------------------------");
        for (RecipeDTO recipe : recipes) {
            System.out.println("          " + recipe.getMealDbId() + " - " + recipe.getName());
        }

        System.out.println();
        System.out.println("          Type in the ID of the recipe you wish to view:");
        String mealDbId = scanner.nextLine();

        viewRecipe(RecipeView.regularView, mealDbId);

    }
    /**
     * Enum containing the two possible detailed views
     */
    enum RecipeView {
        regularView,
        savedView
    }
    /**
     * Shows detailed view of a recipe
     * @param recipeView the two possible enum's: regularView and savedView
     * dictates the two types of detailed views
     */
    public void viewRecipe(RecipeView recipeView, String mealDbId){

        RecipeDetailsDTO recipe = apiClient.viewRecipe(mealDbId);

        System.out.println();
        System.out.println("          " + recipe.getName());

        System.out.println();
        System.out.println(recipe.getInstructions());

        if(recipeView==RecipeView.regularView){
            while(true) {
                System.out.println();
                System.out.println("------------------------------------------------");
                System.out.println();
                System.out.println("            1. Save recipe");
                System.out.println("            2. See similar recipes");
                System.out.println("            3. See recommended drinks");
                System.out.println("            0. Back");
                System.out.println("------------------------------------------------");
                System.out.println("            What is your choice?");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        saveRecipe(mealDbId);
                        break;
                    case 2:
                        showSimilarRecipes(mealDbId);
                        break;
                    case 3:
                        showRecommendedDrinks(mealDbId);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("There is no such choice");
                        break;
                }
            }
        } else if (recipeView==RecipeView.savedView) {
            while(true) {
                System.out.println();
                System.out.println("------------------------------------------------");
                System.out.println();
                System.out.println("            1. Unsave recipe");
                System.out.println("            2. See similar recipes");
                System.out.println("            3. See recommended drinks");
                System.out.println("            0. Back");
                System.out.println("------------------------------------------------");
                System.out.println("            What is your choice?");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        deleteSavedRecipe(mealDbId);
                        return;
                    case 2:
                        showSimilarRecipes(mealDbId);
                        break;
                    case 3:
                        showRecommendedDrinks(mealDbId);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("There is no such choice");
                        break;
                }
            }
        }

    }

    /**
     * Saves a recipe to the database
     * @param mealDbId the recipe's id
     */
    public void saveRecipe(String mealDbId) {

        RecipeDTO recipe = apiClient.saveRecipe(mealDbId);

        System.out.println("------------------------------------------------");
        System.out.println("          " + recipe.getName() + " saved successfully.");
    }
    /**
     * Deletes a recipe
     * @param mealDbId the recipe's id
     */
    public void deleteSavedRecipe(String mealDbId) {

        apiClient.deleteSavedRecipe(mealDbId);

        System.out.println("------------------------------------------------");
        System.out.println(           "Recipe deleted successfully.");
    }
    /**
     * Shows all the saved recipes
     */
    public void viewSavedRecipes() {

        List<RecipeDTO> recipes = apiClient.getSavedRecipes();

        if (recipes.isEmpty()) {
            System.out.println("------------------------------------------------");
            System.out.println("          No saved recipes.");
            return;
        }

        System.out.println("------------------------------------------------");
        System.out.println("          Saved recipes:");

        for (RecipeDTO recipe : recipes) {
            System.out.println("          " + recipe.getMealDbId() + " - " + recipe.getName());
        }

        System.out.println();
        System.out.println("          Type in the ID of the recipe you wish to view:");
        String mealDbId = scanner.nextLine();

        viewRecipe(RecipeView.savedView, mealDbId);
    }
    /**
     * Shows similar recipes
     * @param mealDbId the recipe id used in the search
     */
    public void showSimilarRecipes(String mealDbId) {

        List<SimilarRecipeDTO> recipes =
                apiClient.getSimilarRecipes(mealDbId);

        if (recipes.isEmpty()) {
            System.out.println("------------------------------------------------");
            System.out.println("          No similar recipes found.");
            return;
        }

        System.out.println("------------------------------------------------");
        System.out.println("          Similar recipes:");

        for (SimilarRecipeDTO recipe : recipes) {
            System.out.println();
            System.out.println("          " + recipe.getId() + " - " + recipe.getTitle());
        }
    }
    /**
     * Shows recommended drinks
     * @param mealDbId the recipe id used in the search
     */
    public void showRecommendedDrinks(String mealDbId) {

        List<CocktailDTO> drinks = apiClient.getRecommendedDrinks(mealDbId);

        if (drinks.isEmpty()) {
            System.out.println("------------------------------------------------");
            System.out.println("          No drinks found.");
            return;
        }

        System.out.println("------------------------------------------------");
        System.out.println("          Recommended drinks:");
        for (CocktailDTO drink : drinks) {
            System.out.println("          " + drink.getStrDrink());
        }
    }
}