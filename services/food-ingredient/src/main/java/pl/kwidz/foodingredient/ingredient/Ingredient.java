package pl.kwidz.foodingredient.ingredient;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Document(collection = "food_ingredients")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ingredient {

    @Id
    String id;
    @CreatedDate
    LocalDateTime createdAt;
    String createdBy;
    @LastModifiedDate
    LocalDateTime updatedAt;
    String updatedBy;
    String name;
    String histamineId;

    public IngredientResponse toIngredientResponse() {
        return IngredientResponse.builder()
                .name(name)
                .histamineId(histamineId)
                .build();
    }

    public static Ingredient toIngredient(IngredientRequest ingredientRequest) {
        Ingredient ingredient = new Ingredient();
        ingredient.setCreatedAt(LocalDateTime.now());
        ingredient.setCreatedBy("Test User");
        ingredient.setUpdatedAt(null);
        ingredient.setUpdatedBy(null);
        ingredient.setName(ingredientRequest.name());
        ingredient.setHistamineId(ingredientRequest.histamineId());
        return ingredient;
    }

}
