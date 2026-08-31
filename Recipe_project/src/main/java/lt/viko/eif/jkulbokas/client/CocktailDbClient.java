package lt.viko.eif.jkulbokas.client;

import lt.viko.eif.jkulbokas.dto.cocktailDbDTO.CocktailDbResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Creates a TheCocktailDB client
 */
@Component
public class CocktailDbClient {

    private final WebClient webClient;

    /**
     * Creates a new CocktailDB client
     * @param builder WebClient builder
     * @param baseUrl the base url stored in application.properties
     */
    public CocktailDbClient(WebClient.Builder builder,
                            @Value("${cocktaildb.base-url}") String baseUrl) {

        this.webClient=builder.baseUrl(baseUrl).build();
    }
    /**
     * Searches for a drink in TheCocktailDB api
     * @param keyword keyword needed then searching for a drink
     * @return TheCocktailDB response
     */
    public CocktailDbResponseDTO searchDrink(String keyword) {

        return webClient.get().uri(uriBuilder -> uriBuilder
                        .path("/search.php")
                        .queryParam("s", keyword)
                        .build()).retrieve().bodyToMono(CocktailDbResponseDTO.class).block();
    }
}
