package pl.pkwidzinski.ingredient_mgmt_ms.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestDto {
    @NotEmpty(message = "Ingredient name cannot be a null or empty")
    private String name;
}
