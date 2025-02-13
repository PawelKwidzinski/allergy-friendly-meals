package pl.kwidz.foodingredient.ingredient;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;

@Builder
@Validated
public record IngredientRequest(
        @NotEmpty(message = "Ingredient name cannot be a null or empty")
        String name,
        @NotNull(message = "Ingredient histamine food id cannot be a null or empty")
        String histamineId) {
}
