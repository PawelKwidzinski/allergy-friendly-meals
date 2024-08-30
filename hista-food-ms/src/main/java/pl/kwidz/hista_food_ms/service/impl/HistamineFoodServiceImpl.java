package pl.kwidz.hista_food_ms.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kwidz.hista_food_ms.dto.HistamineFoodDto;
import pl.kwidz.hista_food_ms.exception.ResourceNotFoundException;
import pl.kwidz.hista_food_ms.mapper.HistamineFoodMapper;
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
        List<HistamineFood> ingredients = histamineFoodRepository.findIngredientsByName(ingredient);

        if (ingredients.isEmpty()) {
            throw new ResourceNotFoundException("Histamine Foods", "ingredient", ingredient);
        } else {
            return ingredients;
        }
    }

    /**
     *
     * @param id - histamine food id
     * @return histamine food dto object
     */
    @Override
    public HistamineFoodDto findById(Integer id) {
        HistamineFood histamineFood = histamineFoodRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Histamine Food", "id", String.valueOf(id)));
        return HistamineFoodMapper.mapToHistamineFoodDto(histamineFood, new HistamineFoodDto());
    }

}
