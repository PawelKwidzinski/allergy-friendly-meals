package pl.pkwidzinski.ingredient_mgmt_ms.service;

import pl.pkwidzinski.ingredient_mgmt_ms.dto.IngredientDto;

import java.util.List;

public interface IIngredientService {

    void saveIngredient(IngredientDto ingredientDto);
    List<IngredientDto> findAllIngredients();
    IngredientDto findIngredientById(String id);
    boolean updateIngredient(String id, IngredientDto ingredientDto);
    boolean deleteIngredient(String id);
}
