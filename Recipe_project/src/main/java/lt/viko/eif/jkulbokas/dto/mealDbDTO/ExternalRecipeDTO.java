package lt.viko.eif.jkulbokas.dto.mealDbDTO;

/**
 * DTO responsible for getting the names used in TheMealDb
 */
public class ExternalRecipeDTO {

    private String idMeal;
    private String strMeal;
    private String strCategory;
    private String strArea;
    private String strInstructions;
    private String strMealThumb;

    private String getStrIngredient1;
    private String getStrIngredient2;
    private String getStrIngredient3;
    private String getStrIngredient4;
    private String getStrIngredient5;

    public ExternalRecipeDTO() {
    }

    public String getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrArea() {
        return strArea;
    }

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public String getStrIngredient1() {
        return getStrIngredient1;
    }

    public void setStrIngredient1(String getStrIngredient1) {
        this.getStrIngredient1 = getStrIngredient1;
    }

    public String getStrIngredient2() {
        return getStrIngredient2;
    }

    public void setStrIngredient2(String getStrIngredient2) {
        this.getStrIngredient2 = getStrIngredient2;
    }

    public String getStrIngredient3() {
        return getStrIngredient3;
    }

    public void setStrIngredient3(String getStrIngredient3) {
        this.getStrIngredient3 = getStrIngredient3;
    }

    public String getStrIngredient4() {
        return getStrIngredient4;
    }

    public void setStrIngredient4(String getStrIngredient4) {
        this.getStrIngredient4 = getStrIngredient4;
    }

    public String getStrIngredient5() {
        return getStrIngredient5;
    }

    public void setStrIngredient5(String getStrIngredient5) {
        this.getStrIngredient5 = getStrIngredient5;
    }
}
