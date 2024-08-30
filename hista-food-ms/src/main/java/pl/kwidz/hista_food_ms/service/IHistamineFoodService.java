package pl.kwidz.hista_food_ms.service;

import pl.kwidz.hista_food_ms.dto.HistamineFoodDto;
import pl.kwidz.hista_food_ms.model.HistamineFood;

import java.util.List;

public interface IHistamineFoodService {

    List<HistamineFood> findIngredientsByName(String ingredient);
    HistamineFoodDto findById(Integer id);
}
