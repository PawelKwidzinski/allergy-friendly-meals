package pl.kwidz.hista_food_ms.controller;


import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kwidz.hista_food_ms.dto.HistamineFoodDto;
import pl.kwidz.hista_food_ms.model.HistamineFood;
import pl.kwidz.hista_food_ms.service.IHistamineFoodService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class HistamineFoodController {

    private final IHistamineFoodService iHistamineFoodService;

    @GetMapping("/check-level")
    public ResponseEntity<List<HistamineFood>> findHistamineFood(
            @RequestParam
            @Pattern(regexp = "(^[A-Za-z]+$)", message = "The ingredient must be written in Latin letters") String ingredient) {
        List<HistamineFood> ingredients = iHistamineFoodService.findIngredientsByName(ingredient);
        return ResponseEntity.ok(ingredients);
    }

    @GetMapping("/find")
    public ResponseEntity<HistamineFoodDto> findHistamineFood(@RequestParam Integer id) {
        HistamineFoodDto histamineFoodDto = iHistamineFoodService.findById(id);
        return ResponseEntity.ok(histamineFoodDto);
    }

}

