package pl.pkwidzinski.ingredient_mgmt_ms.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pkwidzinski.ingredient_mgmt_ms.dto.RequestDto;
import pl.pkwidzinski.ingredient_mgmt_ms.dto.ResponseDto;
import pl.pkwidzinski.ingredient_mgmt_ms.model.Ingredient;
import pl.pkwidzinski.ingredient_mgmt_ms.mapper.IngredientMapper;
import pl.pkwidzinski.ingredient_mgmt_ms.repository.IngredientRepository;
import pl.pkwidzinski.ingredient_mgmt_ms.service.IIngredientService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IIngredientService {

    private final IngredientRepository ingredientRepository;

    @Override
    public void saveIngredient(RequestDto requestDto) {
        Ingredient ingredient = IngredientMapper.mapToIngredient(requestDto);
        ingredientRepository.save(ingredient);
    }

    @Override
    public List<ResponseDto> findAllIngredients() {
        return ingredientRepository.findAll().stream()
                .map(ingredient -> {
                    ResponseDto responseDto = new ResponseDto();
                    responseDto.setName(ingredient.getName());
                    return responseDto;
                })
                .toList();
    }

    @Override
    public ResponseDto findIngredientById(String id) {
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Ingredient with id " + id + " not found")
        );
        ResponseDto responseDto = new ResponseDto();
        responseDto.setName(ingredient.getName());
        return responseDto;
    }

    @Override
    public boolean updateIngredient(String id, RequestDto requestDto) {
        boolean isUpdated = false;

        if (requestDto != null) {
            Ingredient foundIngredient = ingredientRepository.findById(id).orElseThrow(
                    () -> new IllegalArgumentException("Ingredient not found")
            );
            foundIngredient.setName(requestDto.getName());
            ingredientRepository.save(foundIngredient);
            isUpdated = true;
        }
        return isUpdated;
    }


    @Override
    public boolean deleteIngredient(String id) {
        Ingredient toDelete = ingredientRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Ingredient not found"));

        ingredientRepository.delete(toDelete);
        return true;
    }
}
