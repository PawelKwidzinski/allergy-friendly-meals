package pl.kwidzinski.histaminefood.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kwidzinski.histaminefood.model.HistamineLevel;
import pl.kwidzinski.histaminefood.repository.HistamineLevelRepo;
import pl.kwidzinski.histaminefood.service.IHistamineLevelService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistamineLevelServiceImpl implements IHistamineLevelService {

    private final HistamineLevelRepo histamineLevelRepo;

    /**
     *
     * @param ingredient - ingredient name
     * @return List of ingredients contains ingredient name
     */
    @Override
    public List<HistamineLevel> findIngredientsByName(String ingredient) {
        return histamineLevelRepo.findIngredientsByName(ingredient);
    }
}
