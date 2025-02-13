package pl.kwidz.foodingredient.ingredient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    @PostMapping("/create")
    public ResponseEntity<String> createIngredient(@Valid @RequestBody IngredientRequest ingredientRequest) {
        return ResponseEntity.ok(ingredientService.saveIngredient(ingredientRequest));
    }

    @GetMapping("/list")
    public List<IngredientResponse> getAllIngredients() {
        return ingredientService.findAllIngredients();
    }

    @GetMapping("/find-name")
    public List<IngredientResponse>findIngredientByName(
            @RequestParam
            @Pattern(regexp = "(^[A-Za-z0-9]+$)", message = "id must be with latin letters and digits") String name
    ){
        return ingredientService.findAllIngredientsByName(name);
    }

    @GetMapping("/find-id")
    public ResponseEntity<IngredientResponse> findIngredientById(
            @RequestParam
            @Pattern(regexp = "(^[A-Za-z0-9]+$)", message = "id must be with latin letters and digits") String ingredientId) {
        IngredientResponse ingredientResponse = ingredientService.findIngredientById(ingredientId);
        return ResponseEntity.ok(ingredientResponse);
    }

    @PatchMapping("/update")
    public ResponseEntity<Boolean> updateIngredient(
            @RequestParam
            @Pattern(regexp = "(^[A-Za-z0-9]+$)", message = "id must be with latin letters and digits") String id,
            @Valid @RequestBody IngredientRequest ingredientRequest) {
        boolean isUpdated = ingredientService.updateIngredient(id, ingredientRequest);
        if (isUpdated) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(false);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteIngredient(
            @RequestParam
            @Pattern(regexp = "(^[A-Za-z0-9]+$)", message = "id must be with latin letters and digits") String id) {
        boolean isDeleted = ingredientService.deleteIngredient(id);
        if (isDeleted) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(false);}
    }

}
