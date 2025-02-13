package pl.kwidz.foodproduct.product;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import pl.kwidz.foodproduct.ingredient.IngredientResponse;

import java.math.BigDecimal;
import java.util.List;

@Validated
public record ProductRequest (
        @NotEmpty(message = "Product name cannot be a null or empty")
        String name, String imageUrl,
        @NotEmpty(message = "Product unit cannot be a null or empty")
        String unit,
        @NotNull(message = "Product quantity cannot be a null or empty")
        Integer quantity,
        @NotNull(message = "Product ingredients cannot be a null or empty")
        List<IngredientResponse> ingredients,
        List<String> productInfos,
        @NotNull(message = "Product calories cannot be a null or empty")
        Integer calories,
        @NotNull(message = "Product protein cannot be a null or empty")
        BigDecimal protein,
        @NotNull(message = "Product carbs cannot be a null or empty")
        BigDecimal carbs,
        @NotNull(message = "Product fat cannot be a null or empty")
        BigDecimal fat,
        @NotNull(message = "Product fiber cannot be a null or empty")
        BigDecimal fiber,
        @NotNull(message = "Product sodium cannot be a null or empty")
        BigDecimal sodium,
        BigDecimal vitamins
) {
}
