package pl.pkwidzinski.ingredient_mgmt_ms.controller;

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
import pl.pkwidzinski.ingredient_mgmt_ms.constans.Constants;
import pl.pkwidzinski.ingredient_mgmt_ms.dto.HttpResponseDto;
import pl.pkwidzinski.ingredient_mgmt_ms.dto.IngredientDto;
import pl.pkwidzinski.ingredient_mgmt_ms.service.IIngredientService;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    private final IIngredientService iIngredientService;

    @PostMapping("/create")
    public ResponseEntity<HttpResponseDto> createIngredient(@Valid @RequestBody IngredientDto ingredientDto) {
        iIngredientService.saveIngredient(ingredientDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new HttpResponseDto(Constants.STATUS_201, Constants.MESSAGE_201));
    }

    @GetMapping("/list")
    public List<IngredientDto> getAllIngredients() {
        return iIngredientService.findAllIngredients();
    }

    @GetMapping("/find")
    public ResponseEntity<IngredientDto> findIngredientById(
            @RequestParam
            @Pattern(regexp = "(^[A-Za-z0-9]+$)", message = "id must be with latin letters and digits") String id) {
        IngredientDto ingredientDto = iIngredientService.findIngredientById(id);
        return ResponseEntity.status(HttpStatus.OK).body(ingredientDto);
    }

    @PatchMapping("/update")
    public ResponseEntity<HttpResponseDto> updateIngredient(
            @RequestParam
            @Pattern(regexp = "(^[A-Za-z0-9]+$)", message = "id must be with latin letters and digits") String id,
            @Valid @RequestBody IngredientDto ingredientDto) {
        boolean isUpdated = iIngredientService.updateIngredient(id, ingredientDto);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new HttpResponseDto(Constants.STATUS_200, Constants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new HttpResponseDto(Constants.STATUS_417, Constants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpResponseDto> deleteIngredient(
            @RequestParam
            @Pattern(regexp = "(^[A-Za-z0-9]+$)", message = "id must be with latin letters and digits") String id) {
        boolean isDeleted = iIngredientService.deleteIngredient(id);
        if (isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new HttpResponseDto(Constants.STATUS_200, Constants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new HttpResponseDto(Constants.STATUS_417, Constants.MESSAGE_417_DELETE));
        }
    }
}
