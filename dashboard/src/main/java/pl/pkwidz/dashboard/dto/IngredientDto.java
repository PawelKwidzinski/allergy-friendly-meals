package pl.pkwidz.dashboard.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class IngredientDto {
        @NotEmpty(message = "Ingredient name cannot be a null or empty")
        private String name;

        @NotNull(message = "Ingredient histamine food id cannot be a null or empty")
        private Integer histFoodId;
}