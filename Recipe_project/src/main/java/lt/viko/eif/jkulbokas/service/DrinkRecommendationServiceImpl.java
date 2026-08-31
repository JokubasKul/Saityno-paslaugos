package lt.viko.eif.jkulbokas.service;

import lt.viko.eif.jkulbokas.client.CocktailDbClient;
import lt.viko.eif.jkulbokas.client.MealDbClient;
import lt.viko.eif.jkulbokas.dto.cocktailDbDTO.CocktailDTO;
import lt.viko.eif.jkulbokas.dto.cocktailDbDTO.CocktailDbResponseDTO;
import lt.viko.eif.jkulbokas.dto.mealDbDTO.ExternalRecipeDTO;
import lt.viko.eif.jkulbokas.dto.mealDbDTO.MealDbResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation related to TheCocktailDB
 */
@Service
public class DrinkRecommendationServiceImpl implements DrinkRecommendationService {

    private final MealDbClient mealDbClient;
    private final CocktailDbClient cocktailDbClient;

    public DrinkRecommendationServiceImpl(MealDbClient mealDbClient, CocktailDbClient cocktailDbClient) {
        this.mealDbClient = mealDbClient;
        this.cocktailDbClient = cocktailDbClient;
    }

    /**
     * Method that gets the recommended drinks based on the id
     * @param mealDbId the recipe's id
     * @return the drinks
     */
    @Override
    public List<CocktailDTO> getRecommendedDrinks(String mealDbId) {

        MealDbResponseDTO mealResponse = mealDbClient.getRecipeById(mealDbId);

        if (mealResponse==null || mealResponse.getMeals()==null || mealResponse.getMeals().isEmpty()) {
            return List.of();
        }

        ExternalRecipeDTO recipe = mealResponse.getMeals().get(0);

        String keyword = getDrinkKeyword(recipe.getStrArea());

        CocktailDbResponseDTO response = cocktailDbClient.searchDrink(keyword);

        if (response==null || response.getDrinks()==null) {
            return List.of();
        }

        return response.getDrinks();
    }

    /**
     * Method that coverts the area into the keyword needed to identify the recommended drinks
     * @param area the recipe's area
     */
    private String getDrinkKeyword(String area) {

        if (area==null) {
            return "Mojito";
        }

        switch (area.toLowerCase()) {

            case "indian":
                return "Mango";

            case "italian":
                return "Negroni";

            case "mexican":
                return "Margarita";

            case "american":
                return "Old Fashioned";

            case "british":
                return "Gin";

            case "french":
                return "French Martini";

            case "japanese":
                return "Sake";

            case "chinese":
                return "Lychee";

            case "thai":
                return "Coconut";

            case "greek":
                return "Ouzo";

            case "spanish":
                return "Sangria";

            case "irish":
                return "Irish Coffee";

            case "jamaican":
                return "Rum";

            case "cuban":
                return "Mojito";

            case "russian":
                return "Vodka";

            case "canadian":
                return "Whisky";

            case "turkish":
                return "Coffee";

            case "moroccan":
                return "Mint";

            case "egyptian":
                return "Date";

            case "vietnamese":
                return "Lime";

            case "korean":
                return "Soju";

            case "malaysian":
                return "Pineapple";

            case "tunisian":
                return "Orange";

            case "portuguese":
                return "Port";

            case "croatian":
                return "Cherry";

            case "dutch":
                return "Gin";

            case "kenyan":
                return "Passion";

            case "polish":
                return "Vodka";

            case "ukrainian":
                return "Vodka";

            case "filipino":
                return "Coconut";

            case "ethiopian":
                return "Coffee";

            default:
                return "Mojito";
        }
    }
}
