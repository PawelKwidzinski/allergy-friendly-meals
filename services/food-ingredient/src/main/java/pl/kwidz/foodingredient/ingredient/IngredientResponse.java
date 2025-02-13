package pl.kwidz.foodingredient.ingredient;

import lombok.Builder;

@Builder
public record IngredientResponse(
        String name,
        String histamineId
) {
}
