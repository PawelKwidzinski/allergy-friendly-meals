package pl.pkwidzinski.ingredient_mgmt_ms.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import pl.pkwidzinski.ingredient_mgmt_ms.dto.IngredientDto;
import pl.pkwidzinski.ingredient_mgmt_ms.exception.ResourceNotFoundException;
import pl.pkwidzinski.ingredient_mgmt_ms.model.Ingredient;
import pl.pkwidzinski.ingredient_mgmt_ms.repository.IngredientRepository;
import pl.pkwidzinski.ingredient_mgmt_ms.service.IIngredientService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class IngredientServiceImpl implements IIngredientService {

    IngredientRepository ingredientRepository;

    /**
     * @param ingredientDto - IngredientDto Object
     */
    @Override
    public void saveIngredient(IngredientDto ingredientDto) {
        Ingredient ingredient = Ingredient.fromDto(ingredientDto);

        // todo - check ingredient histamine level before save
        ingredientRepository.save(ingredient);
    }

    /**
     * @return list of Ingredients
     */
    @Override
    public List<IngredientDto> findAllIngredients() {
        return ingredientRepository.findAll().stream()
                .map(Ingredient::toDto)
                .toList();
    }

    /**
     * @param ingredientId - Ingredient ID
     * @return IngredientDTO Object
     */
    @Override
    public IngredientDto findIngredientById(String ingredientId) {
        Ingredient ingredient = ingredientRepository.findById(ingredientId).orElseThrow(
                () -> new ResourceNotFoundException("Ingredient", "ingredientId", ingredientId));
        return ingredient.toDto();
    }

    /**
     * @param ingredientId - Ingredient ID
     * @param ingredientDto - IngredientDTO Object
     * @return boolean indicating if the update of Ingredient is successful or not
     */
    @Override
    public boolean updateIngredient(String ingredientId, IngredientDto ingredientDto) {
        boolean isUpdated = false;

        if (ingredientDto != null) {
            Ingredient foundIngredient = ingredientRepository.findById(ingredientId).orElseThrow(
                    () -> new ResourceNotFoundException("Ingredient", "ingredientId", ingredientId));

            foundIngredient.setName(ingredientDto.name());
            foundIngredient.setUpdatedBy("Test User");
            foundIngredient.setUpdatedAt(LocalDateTime.now());

            ingredientRepository.save(foundIngredient);
            isUpdated = true;
        }
        return isUpdated;
    }

    /**
     * @param ingredientId - Ingredient ID
     * @return boolean indicating if the update of Ingredient is successful or not
     */
    @Override
    public boolean deleteIngredient(String ingredientId) {
        Ingredient toDelete = ingredientRepository.findById(ingredientId).orElseThrow(
                () -> new ResourceNotFoundException("Ingredient", "ingredientId", ingredientId));

        ingredientRepository.delete(toDelete);
        return true;
    }

}
