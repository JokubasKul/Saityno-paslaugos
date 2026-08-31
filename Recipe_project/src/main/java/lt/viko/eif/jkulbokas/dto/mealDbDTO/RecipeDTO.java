package lt.viko.eif.jkulbokas.dto.mealDbDTO;

/**
 * DTO used in the recipe search
 */
public class RecipeDTO {

    private String mealDbId;
    private String name;
    private String category;
    private String imageUrl;

    public RecipeDTO() {
    }

    public RecipeDTO(
            String mealDbId,
            String name,
            String category,
            String imageUrl) {

        this.mealDbId = mealDbId;
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    public String getMealDbId() {
        return mealDbId;
    }

    public void setMealDbId(String mealDbId) {
        this.mealDbId = mealDbId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
