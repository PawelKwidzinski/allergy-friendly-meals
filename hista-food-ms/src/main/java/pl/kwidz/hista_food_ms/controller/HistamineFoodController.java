package pl.kwidz.hista_food_ms.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kwidz.hista_food_ms.model.HistamineFood;
import pl.kwidz.hista_food_ms.repository.HistamineFoodRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class HistamineFoodController {

    private final HistamineFoodRepository histamineFoodRepository;

    @GetMapping("/check-histamine-level/{ingredient}")
    public ResponseEntity<List<HistamineFood>> getFoodHistamineLevel(@PathVariable(name = "ingredient") String ingredient) {
        List<HistamineFood> ingredients = histamineFoodRepository.findIngredientsByName(ingredient);
        return ResponseEntity.ok(ingredients);
    }
}

