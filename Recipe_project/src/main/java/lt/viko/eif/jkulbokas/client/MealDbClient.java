package lt.viko.eif.jkulbokas.client;

import lt.viko.eif.jkulbokas.dto.mealDbDTO.MealDbResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Creates a TheMealDB client
 */
@Component
public class MealDbClient {

    private final WebClient webClient;

    /**
     * Creates a new TheMealDB client
     * @param builder a WebClient builder
     * @param baseUrl the base url stored in application.properties
     */
    public MealDbClient(
            WebClient.Builder builder,
            @Value("${mealdb.base-url}") String baseUrl) {

        this.webClient = builder.baseUrl(baseUrl).build();
    }

    /**
     * Searches for a recipe based on the recipe name
     * @param recipeName recipe name that is used in the search
     * @return TheMealDb response
     */
    public MealDbResponseDTO searchRecipes(String recipeName) {

        return webClient.get().uri("/search.php?s={name}", recipeName).retrieve().bodyToMono(MealDbResponseDTO.class).block();
    }
    /**
     * Searches for a recipe based on the recipe id
     * @param mealDbId recipe id that is used in the search
     * @return TheMealDb response
     */
    public MealDbResponseDTO getRecipeById(String mealDbId) {

        return webClient.get().uri("/lookup.php?i={id}", mealDbId).retrieve().bodyToMono(MealDbResponseDTO.class).block();
    }
}
