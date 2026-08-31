package lt.viko.eif.jkulbokas.repositories;

import lt.viko.eif.jkulbokas.entity.SavedRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Defines operations related to the database where
 * the user saved recipes are stored
 */
public interface RecipeRepository extends JpaRepository<SavedRecipe, Long> {

    Optional<SavedRecipe> findByMealDbId(String mealDbId);

    boolean existsByMealDbId(String mealDbId);

}
