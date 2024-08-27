package pl.pkwidzinski.ingredient_mgmt_ms.mapper;

import pl.pkwidzinski.ingredient_mgmt_ms.dto.RequestDto;
import pl.pkwidzinski.ingredient_mgmt_ms.model.Ingredient;

import java.time.LocalDateTime;

public class IngredientMapper {

    private IngredientMapper() {
        throw new IllegalStateException("Mapper class");
    }

    public static Ingredient mapToIngredient(RequestDto requestDto) {
        Ingredient ingredient = new Ingredient();
        if (requestDto != null) {
            ingredient.setName(requestDto.getName());
            ingredient.setFoodCategory("Test Food Category");
            ingredient.setFoodSubcategory("Test Food Subcategory");
            ingredient.setCreatedAt(LocalDateTime.now());
            ingredient.setCreatedBy("Test User");
            ingredient.setUpdatedAt(null);
            ingredient.setUpdatedBy("Test User");
        }
        return ingredient;
    }
}
