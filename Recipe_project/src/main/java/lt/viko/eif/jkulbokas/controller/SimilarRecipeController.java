package lt.viko.eif.jkulbokas.controller;

import lt.viko.eif.jkulbokas.dto.spoonacularDTO.SimilarRecipeDTO;
import lt.viko.eif.jkulbokas.service.SimilarRecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller used in for operations relating to Spoonacular
 */
@RestController
@RequestMapping("/recipes")
public class SimilarRecipeController {

    private final SimilarRecipeService similarRecipeService;

    public SimilarRecipeController(SimilarRecipeService similarRecipeService){
        this.similarRecipeService=similarRecipeService;
    }

    /**
     * Gets similar recipes based on the id
     * @param mealDbId the id needed for the search
     * @return similar recipes
     */
    @GetMapping("/{mealDbId}/similar")
    public List<SimilarRecipeDTO> getSimilarRecipes(@PathVariable String mealDbId){

        return similarRecipeService.getSimilarRecipes(mealDbId);
    }
}
