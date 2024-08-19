package pl.kwidzinski.histaminefood.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kwidzinski.histaminefood.model.HistamineLevel;
import pl.kwidzinski.histaminefood.repository.HistamineLevelRepo;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class HistamineLevelController {

    private final HistamineLevelRepo histamineLevelRepo;

    @GetMapping("/check-histamine-level/{ingredient}")
    public ResponseEntity<List<HistamineLevel>> getFoodHistamineLevel(@PathVariable(name = "ingredient") String ingredient) {
        List<HistamineLevel> ingredients = histamineLevelRepo.findIngredientsByName(ingredient);
        return ResponseEntity.ok(ingredients);
    }
}
