package pl.pkwidzinski.ingredient_mgmt_ms.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.pkwidzinski.ingredient_mgmt_ms.dto.IngredientDto;

import java.time.LocalDateTime;

@Document
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ingredient extends BaseDocument {

    String name;
    Integer histFoodId;

    public IngredientDto toDto() {
        return IngredientDto.builder()
                .name(name)
                .histFoodId(histFoodId)
                .build();
    }

    public static Ingredient fromDto(IngredientDto ingredientDto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setCreatedAt(LocalDateTime.now());
        ingredient.setCreatedBy("Test User");
        ingredient.setUpdatedAt(null);
        ingredient.setUpdatedBy(null);
        ingredient.setName(ingredientDto.name());
        ingredient.setHistFoodId(ingredientDto.histFoodId());
        return ingredient;
    }
}
