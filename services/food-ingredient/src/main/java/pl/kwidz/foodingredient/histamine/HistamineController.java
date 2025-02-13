package pl.kwidz.foodingredient.histamine;


import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/histamines")
class HistamineController {

    private final HistamineService histamineService;

    @GetMapping("/check-level")
    public ResponseEntity<List<HistamineResponse>> findHistamineFood(
            @RequestParam
            @Pattern(regexp = "^[A-Za-z0-9\\s]+$", message = "The ingredient must be written by latin letters with spaces") String ingredient) {
        List<HistamineResponse> histamineIngredients = histamineService.findIngredientsByName(ingredient);
        return ResponseEntity.ok(histamineIngredients);
    }

    @GetMapping("/find")
    public ResponseEntity<HistamineResponse> findHistamineFoodById(@RequestParam String id) {
        HistamineResponse histamineResponse = histamineService.findById(id);
        return ResponseEntity.ok(histamineResponse);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Histamine>> findHistamineFood() {
       return ResponseEntity.ok(histamineService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<String> createHistamineFood(@RequestBody HistamineRequest histamineRequest) {
        return ResponseEntity.ok(histamineService.save(histamineRequest));
    }

}

