package pl.pkwidzinski.ingredient_mgmt_ms.service;

import pl.pkwidzinski.ingredient_mgmt_ms.dto.RequestDto;
import pl.pkwidzinski.ingredient_mgmt_ms.dto.ResponseDto;

import java.util.List;

public interface IIngredientService {

    void saveIngredient(RequestDto requestDto);
    List<ResponseDto> findAllIngredients();
    ResponseDto findIngredientById(String id);
    boolean updateIngredient(String id, RequestDto requestDto);
    boolean deleteIngredient(String id);
}
