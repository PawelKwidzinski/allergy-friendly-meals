package pl.kwidz.foodproduct.product;

import lombok.Builder;
import pl.kwidz.foodproduct.ingredient.IngredientResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
public record ProductResponse (
        String id,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime updatedAt,
        String updatedBy,
        String name,
        String imageUrl,
        String unit,
        Integer quantity,
        List<IngredientResponse> ingredients,
        List<String> productInfos,
        Integer calories,
        BigDecimal protein,
        BigDecimal carbs,
        BigDecimal fat,
        BigDecimal fiber,
        BigDecimal sodium,
        BigDecimal vitamins
) {
}
