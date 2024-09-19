package pl.pkwidz.dashboard.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ProductDto {
        @NotEmpty(message = "Product name cannot be a null or empty")
        String name;
        String imageUrl;
        @NotEmpty(message = "Product unit cannot be a null or empty")
        String unit;
        @NotNull(message = "Product quantity cannot be a null or empty")
        Integer quantity;
        @NotNull(message = "Product ingredients cannot be a null or empty")
        List<IngredientDto> ingredients;
        List<String> productInfos;
        @NotNull(message = "Product calories cannot be a null or empty")
        Integer calories;
        @NotNull(message = "Product protein cannot be a null or empty")
        BigDecimal protein;
        @NotNull(message = "Product carbs cannot be a null or empty")
        BigDecimal carbs;
        @NotNull(message = "Product fat cannot be a null or empty")
        BigDecimal fat;
        @NotNull(message = "Product fiber cannot be a null or empty")
        BigDecimal fiber;
        @NotNull(message = "Product sodium cannot be a null or empty")
        BigDecimal sodium;
        BigDecimal vitamins;
}
