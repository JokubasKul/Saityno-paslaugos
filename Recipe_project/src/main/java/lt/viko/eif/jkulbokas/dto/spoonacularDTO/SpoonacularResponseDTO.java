package lt.viko.eif.jkulbokas.dto.spoonacularDTO;

import java.util.List;

/**
 * DTO responsible for wrapping the Spoonacular response's data
 */
public class SpoonacularResponseDTO {

    private List<SimilarRecipeDTO> results;

    public SpoonacularResponseDTO() {
    }

    public List<SimilarRecipeDTO> getResults() {
        return results;
    }

    public void setResults(
            List<SimilarRecipeDTO> results) {

        this.results = results;
    }
}
