package lt.viko.eif.jkulbokas;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lt.viko.eif.jkulbokas.dto.cocktailDbDTO.CocktailDTO;
import lt.viko.eif.jkulbokas.dto.mealDbDTO.RecipeDTO;
import lt.viko.eif.jkulbokas.dto.mealDbDTO.RecipeDetailsDTO;
import lt.viko.eif.jkulbokas.dto.spoonacularDTO.SimilarRecipeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    private Object response;

    private String url(String path) {
        return "http://localhost:" + port + path;
    }


    @When("I search recipe {string}")
    public void searchRecipe(String name) {

        response = restTemplate.getForObject(url("/recipes/search?name=" + name), RecipeDTO[].class);
    }
    @Then("recipes should be found")
    public void recipesShouldBeFound() {

        RecipeDTO[] recipes = (RecipeDTO[]) response;

        assertNotNull(recipes);
        assertTrue(recipes.length > 0);
    }


    @When("I view recipe's {string} details")
    public void viewRecipe(String mealDbId) {

        response = restTemplate.getForObject(url("/recipes/" + mealDbId), RecipeDetailsDTO.class);
    }
    @Then("recipe details should be shown")
    public void recipeDetailsReturned() {

        RecipeDetailsDTO recipe = (RecipeDetailsDTO) response;

        assertNotNull(recipe);
        assertNotNull(recipe.getName());
    }


    @When("I save recipe {string}")
    public void saveRecipe(String mealDbId) {

        response = restTemplate.postForObject(url("/recipes/save/" + mealDbId), null, RecipeDTO.class);
    }
    @Then("recipe should be saved")
    public void recipeSaved() {

        RecipeDTO recipe = (RecipeDTO) response;

        assertNotNull(recipe);
    }


    @When("I delete recipe {string}")
    public void deleteRecipe(String mealDbId) {

        restTemplate.delete(url("/recipes/saved/delete/" + mealDbId));

        response = "deleted";
    }
    @Then("the recipe should be deleted")
    public void recipeDeleted() {

        assertEquals("deleted", response);
    }


    @When("I search for similar recipes for {string}")
    public void similarRecipes(String mealDbId) {

        response = restTemplate.getForObject(url("/recipes/" + mealDbId + "/similar"), SimilarRecipeDTO[].class);
    }
    @Then("I should receive similar recipes")
    public void similarReturned() {

        SimilarRecipeDTO[] recipes = (SimilarRecipeDTO[]) response;

        assertNotNull(recipes);
    }


    @When("I request a drink for recipe {string}")
    public void recommendDrinks(String mealDbId) {

        response = restTemplate.getForObject(url("/recipes/" + mealDbId + "/drinks"), CocktailDTO[].class);
    }
    @Then("I should receive the drink recommendations")
    public void drinksReturned() {

        CocktailDTO[] drinks = (CocktailDTO[]) response;

        assertNotNull(drinks);
    }
}
