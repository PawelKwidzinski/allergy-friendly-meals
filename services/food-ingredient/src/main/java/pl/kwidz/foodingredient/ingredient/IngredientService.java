package pl.kwidz.foodingredient.ingredient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kwidz.foodingredient.exception.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    /**
     * @param ingredientRequest - IngredientRequest Object
     */

    public String saveIngredient(IngredientRequest ingredientRequest) {
        Ingredient ingredient = Ingredient.toIngredient(ingredientRequest);

        // todo - check ingredient histamine level before save
        return ingredientRepository.save(ingredient).getId();
    }

    /**
     * @return list of Ingredients
     */
    public List<IngredientResponse> findAllIngredients() {
        return ingredientRepository.findAll()
                .stream()
                .map(Ingredient::toIngredientResponse)
                .toList();
    }

    /**
     * @param ingredientId - Ingredient ID
     * @return IngredientResponse Object
     */
    public IngredientResponse findIngredientById(String ingredientId) {
        Ingredient ingredient = ingredientRepository.findById(ingredientId).orElseThrow(
                () -> new ResourceNotFoundException("Ingredient", "ingredientId", ingredientId));
        return ingredient.toIngredientResponse();
    }

    /**
     * @param ingredientName - Ingredient Name
     * @return List of IngredientsResponse Object containing ingredient name
     */
    public List<IngredientResponse> findAllIngredientsByName(String ingredientName) {
        return ingredientRepository.findIngredientsByNameContainingIgnoreCase(ingredientName)
                .stream()
                .map(Ingredient::toIngredientResponse)
                .toList();
    }

    /**
     * @param ingredientId - Ingredient ID
     * @param ingredientRequest - IngredientRequest Object
     * @return boolean indicating if the update of Ingredient is successful or not
     */
    public boolean updateIngredient(String ingredientId, IngredientRequest ingredientRequest) {
        boolean isUpdated = false;

        if (ingredientRequest != null) {
            Ingredient foundIngredient = ingredientRepository.findById(ingredientId).orElseThrow(
                    () -> new ResourceNotFoundException("Ingredient", "ingredientId", ingredientId));

            foundIngredient.setName(ingredientRequest.name());
            foundIngredient.setUpdatedBy("Test User");
            foundIngredient.setUpdatedAt(LocalDateTime.now());

            ingredientRepository.save(foundIngredient);
            isUpdated = true;
        }
        return isUpdated;
    }

    /**
     * @param ingredientId - Ingredient ID
     * @return boolean indicating if the delete of Ingredient is successful or not
     */
    public boolean deleteIngredient(String ingredientId) {
        Ingredient toDelete = ingredientRepository.findById(ingredientId).orElseThrow(
                () -> new ResourceNotFoundException("Ingredient", "ingredientId", ingredientId));

        ingredientRepository.delete(toDelete);
        return true;
    }
}
