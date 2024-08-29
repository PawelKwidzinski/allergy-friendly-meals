package pl.kwidz.hista_food_ms.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kwidz.hista_food_ms.model.HistamineFood;
import pl.kwidz.hista_food_ms.repository.HistamineFoodRepository;
import pl.kwidz.hista_food_ms.service.IHistamineFoodService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistamineFoodServiceImpl implements IHistamineFoodService {

    private final HistamineFoodRepository histamineFoodRepository;

    /**
     *
     * @param ingredient - ingredient name
     * @return List of ingredients contains ingredient name
     */
    @Override
    public List<HistamineFood> findIngredientsByName(String ingredient) {
        return histamineFoodRepository.findIngredientsByName(ingredient);
    }
}
