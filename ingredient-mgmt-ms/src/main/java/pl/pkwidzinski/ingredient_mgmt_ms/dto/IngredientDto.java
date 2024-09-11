package pl.pkwidzinski.ingredient_mgmt_ms.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record IngredientDto(
        @NotEmpty(message = "Ingredient name cannot be a null or empty")
        String name,
        @NotNull(message = "Ingredient histamine food id cannot be a null or empty")
        Integer histFoodId) {
}
