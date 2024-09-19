package pl.pkwidz.dashboard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import pl.pkwidz.dashboard.dto.HistamineFoodDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistamineFoodService {

    private final RestClient restClient;

    @Value("${url.hista-food-ms}")
    private String histaFoodMsUrl;

    public List<HistamineFoodDto> findIngredientsByName(String ingredient) {
        return restClient.get()
                .uri(histaFoodMsUrl + "/api/check-level?ingredient={ingredient}", ingredient)
                .retrieve()
                .body(new ParameterizedTypeReference<List<HistamineFoodDto>>() {});
    }
}
