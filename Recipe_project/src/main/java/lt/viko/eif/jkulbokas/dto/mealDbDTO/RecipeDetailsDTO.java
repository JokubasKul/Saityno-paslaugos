package lt.viko.eif.jkulbokas.dto.mealDbDTO;

/**
 * DTO responsible for detailed information of a recipe
 */
public class RecipeDetailsDTO {

    private String mealDbId;
    private String name;
    private String category;
    private String area;
    private String instructions;
    private String imageUrl;

    public RecipeDetailsDTO() {
    }

    public RecipeDetailsDTO(
            String mealDbId,
            String name,
            String category,
            String area,
            String instructions,
            String imageUrl) {

        this.mealDbId = mealDbId;
        this.name = name;
        this.category = category;
        this.area = area;
        this.instructions = instructions;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}