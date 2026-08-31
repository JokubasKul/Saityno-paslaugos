package lt.viko.eif.jkulbokas.entity;

import jakarta.persistence.*;

/**
 * This POJO is used in the creation of a database table
 * where user saved recipes are stored
 */
@Entity
@Table(name = "recipes")
public class SavedRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String mealDbId;

    @Column(nullable = false)
    private String name;

    private String category;
    private String area;
    private String imageUrl;

    @Column(length = 5000)
    private String instructions;

    public SavedRecipe() {
    }

    public SavedRecipe(
            String mealDbId,
            String name,
            String category,
            String area,
            String imageUrl,
            String instructions) {

        this.mealDbId = mealDbId;
        this.name = name;
        this.category = category;
        this.area = area;
        this.imageUrl = imageUrl;
        this.instructions = instructions;
    }

    public Long getId() {
        return id;
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

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getInstructions() {
        return instructions;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}