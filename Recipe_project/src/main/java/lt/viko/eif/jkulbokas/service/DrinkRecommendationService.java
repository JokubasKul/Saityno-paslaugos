package lt.viko.eif.jkulbokas.service;

import lt.viko.eif.jkulbokas.dto.cocktailDbDTO.CocktailDTO;

import java.util.List;

/**
 * Defines the drink recommendation service
 */
public interface DrinkRecommendationService {

    List<CocktailDTO> getRecommendedDrinks(String mealDbId);
}
