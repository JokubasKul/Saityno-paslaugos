package lt.viko.eif.jkulbokas.client;

import lt.viko.eif.jkulbokas.dto.spoonacularDTO.SpoonacularResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Creates a Spoonacular client
 */
@Component
public class SpoonacularClient {

    private final WebClient webClient;
    private final String apiKey;

    /**
     * Creates a new Spoonacular client
     * @param builder a WebClient builder
     * @param baseUrl base url that is stored in application.properties
     * @param apiKey api key needed to access the api, stored in application.properties
     */
    public SpoonacularClient(WebClient.Builder builder,
            @Value("${spoonacular.base-url}")
            String baseUrl,
            @Value("${spoonacular.api-key}")
            String apiKey) {

        this.webClient = builder.baseUrl(baseUrl).build();
        this.apiKey = apiKey;
    }

    /**
     * Searches for recipes based on the recipe name
     * @param recipeName recipe name used in the search
     * @return Spoonacular response
     */
    public SpoonacularResponseDTO searchRecipes(String recipeName) {

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/recipes/complexSearch")
                        .queryParam("query", recipeName)
                        .queryParam("number", 10)
                        .queryParam("apiKey", apiKey)
                        .build()).retrieve().bodyToMono(SpoonacularResponseDTO.class).block();
    }
}
