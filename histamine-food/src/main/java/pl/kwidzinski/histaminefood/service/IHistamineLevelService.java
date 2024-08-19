package pl.kwidzinski.histaminefood.service;

import pl.kwidzinski.histaminefood.model.HistamineLevel;

import java.util.List;

public interface IHistamineLevelService {

    List<HistamineLevel> findIngredientsByName(String ingredient);
}
