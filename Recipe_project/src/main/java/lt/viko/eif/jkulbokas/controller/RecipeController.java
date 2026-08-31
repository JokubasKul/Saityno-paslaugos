package lt.viko.eif.jkulbokas.controller;

import lt.viko.eif.jkulbokas.dto.mealDbDTO.RecipeDTO;
import lt.viko.eif.jkulbokas.dto.mealDbDTO.RecipeDetailsDTO;
import lt.viko.eif.jkulbokas.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller used in for operations relating to TheMealDB
 */
@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    /**
     * Gets recipes based on name
     * @param name the recipe name
     * @return list of searched recipes
     */
    @GetMapping("/search")
    public List<RecipeDTO> searchRecipes(@RequestParam String name) {
        return recipeService.searchRecipes(name);
    }
    /**
     * Gets recipe's details
     * @param mealDbId the recipe's id
     * @return recipe's details
     */
    @GetMapping("/{mealDbId}")
    public RecipeDetailsDTO getRecipeDetails(@PathVariable String mealDbId) {
        return recipeService.getRecipeDetails(mealDbId);
    }
    /**
     * Adds a recipe to the database
     * @param mealDbId the recipe's id
     * @return saved recipe
     */
    @PostMapping("/save/{mealDbId}")
    @ResponseStatus(HttpStatus.CREATED)
    public RecipeDTO saveRecipe(@PathVariable String mealDbId) {
        return recipeService.saveRecipe(mealDbId);
    }
    /**
     * Deletes a recipe based on id
     * @param mealDbId the recipe's id
     * @return deleted recipe
     */
    @DeleteMapping("/saved/delete/{mealDbId}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable String mealDbId) {
        recipeService.deleteRecipe(mealDbId);
        return ResponseEntity.noContent().build();
    }
    /**
     * Gets all saved recipes
     * @return saved recipes
     */
    @GetMapping("/saved")
    public List<RecipeDTO> getSavedRecipes() {
        return recipeService.getSavedRecipes();
    }
}
