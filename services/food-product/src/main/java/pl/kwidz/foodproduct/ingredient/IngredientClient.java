package pl.kwidz.foodproduct.ingredient;

import jakarta.validation.constraints.Pattern;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface IngredientClient {

    @GetExchange("/find")
    List<IngredientResponse> findIngredientById(
            @RequestParam
            @Pattern(regexp = "(^[A-Za-z0-9]+$)", message = "id must be with latin letters and digits") String ingredientId);

//    TODO -> add method findIngredientByName() in food-ingredient-ms
    @GetExchange("/find-ingredient")
    List<IngredientResponse> findIngredientByName(
            @RequestParam
            @Pattern(regexp = "(^[A-Za-z0-9]+$)", message = "id must be with latin letters and digits") String ingredientId);

}
