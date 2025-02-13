package pl.kwidz.foodingredient.ingredient;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends MongoRepository<Ingredient, String> {
    List<Ingredient> findIngredientsByNameContainingIgnoreCase(String ingredientName);
}
