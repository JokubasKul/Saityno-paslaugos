package lt.viko.eif.jkulbokas.service;

import lt.viko.eif.jkulbokas.dto.spoonacularDTO.SimilarRecipeDTO;

import java.util.List;

/**
 * Defines the similar recipe service
 */
public interface SimilarRecipeService {
    List<SimilarRecipeDTO> getSimilarRecipes(String mealDbId);
}
