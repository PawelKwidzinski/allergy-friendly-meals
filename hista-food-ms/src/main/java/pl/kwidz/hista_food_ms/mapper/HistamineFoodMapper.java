package pl.kwidz.hista_food_ms.mapper;

import pl.kwidz.hista_food_ms.dto.HistamineFoodDto;
import pl.kwidz.hista_food_ms.model.HistamineFood;

public class HistamineFoodMapper {

    private HistamineFoodMapper() {
    }

    public static HistamineFoodDto mapToHistamineFoodDto(HistamineFood histamineFood, HistamineFoodDto histamineFoodDto) {
        histamineFoodDto.setCompatibility(histamineFood.getCompatibility());
        histamineFoodDto.setLevel(histamineFood.getLevel());
        histamineFoodDto.setOtherAmines(histamineFood.getOtherAmines());
        histamineFoodDto.setLiberator(histamineFood.getLiberator());
        histamineFoodDto.setBlocker(histamineFood.getBlocker());
        histamineFoodDto.setIngredient(histamineFood.getIngredient());
        histamineFoodDto.setRemarks(histamineFood.getRemarks());
        histamineFoodDto.setCategory(histamineFood.getCategory());
        histamineFoodDto.setSubcategory(histamineFood.getSubcategory());
        return histamineFoodDto;
    }
}
