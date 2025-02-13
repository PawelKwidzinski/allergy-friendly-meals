package pl.kwidz.foodingredient.histamine;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kwidz.foodingredient.exception.ResourceNotFoundException;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistamineService {

    private final HistamineRepository histamineRepository;
    private final HistamineMapper histamineMapper;

    /**
     * @param ingredient - ingredient name
     * @return List of ingredients contains ingredient name
     */
    public List<HistamineResponse> findIngredientsByName(String ingredient) {
        List<HistamineResponse> ingredients = histamineRepository
                .findHistamineByIngredientContainingIgnoreCase(ingredient)
                .stream()
                .map(histamineMapper::toHistamineResponse)
                .toList();

        if (ingredients.isEmpty()) {
            throw new ResourceNotFoundException("Histamine Foods", "ingredient", ingredient);
        } else {
            return ingredients;
        }
    }

    /**
     * @param id - histamine food id
     * @return histamine food dto object
     */
    public HistamineResponse findById(String id) {
        return histamineRepository.findById(id)
                .map(histamineMapper::toHistamineResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Histamine Food", "id", id));
    }

    public List<Histamine> findAll() {
        return histamineRepository.findAll();
    }

    public String save(HistamineRequest histamineRequest) {
       return histamineRepository.save(histamineMapper.toHistamine(histamineRequest)).get_id();
    }


}
