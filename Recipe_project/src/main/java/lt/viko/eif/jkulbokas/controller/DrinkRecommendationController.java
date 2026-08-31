package lt.viko.eif.jkulbokas.controller;

import lt.viko.eif.jkulbokas.dto.cocktailDbDTO.CocktailDTO;
import lt.viko.eif.jkulbokas.service.DrinkRecommendationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller used in for operations relating to TheCocktailDB
 */
@RestController
@RequestMapping("/recipes")
public class DrinkRecommendationController {

    private final DrinkRecommendationService drinkRecommendationService;

    public DrinkRecommendationController(DrinkRecommendationService drinkRecommendationService) {
        this.drinkRecommendationService = drinkRecommendationService;
    }

    /**
     * Gets drinks based on the id
     * @param mealDbId the id needed for the search
     * @return list of drinks
     */
    @GetMapping("/{mealDbId}/drinks")
    public List<CocktailDTO> getRecommendedDrinks(@PathVariable String mealDbId) {
        return drinkRecommendationService.getRecommendedDrinks(mealDbId);
    }
}
