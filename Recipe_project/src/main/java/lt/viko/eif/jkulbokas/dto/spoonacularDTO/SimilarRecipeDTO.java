package lt.viko.eif.jkulbokas.dto.spoonacularDTO;

/**
 * DTO responsible for getting the names used in Spoonacular
 */
public class SimilarRecipeDTO {

    private Integer id;
    private String title;
    private String image;

    public SimilarRecipeDTO(){}

    public SimilarRecipeDTO(
            Integer id,
            String title,
            String image) {
        this.id=id;
        this.title=title;
        this.image=image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
