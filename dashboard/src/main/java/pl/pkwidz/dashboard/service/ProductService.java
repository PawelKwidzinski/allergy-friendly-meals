package pl.pkwidz.dashboard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import pl.pkwidz.dashboard.dto.ProductDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final RestClient restClient;

    @Value("${url.ingredient-mgmt-ms}")
    private String ingredientMgmtMsUrl;

    public void saveProduct(ProductDto productDto) {
        restClient.post()
                .uri(ingredientMgmtMsUrl + "/api/products/create")
                .body(productDto)
                .retrieve()
                .toBodilessEntity();
    }

    public List<ProductDto> findAllProducts() {
        return restClient.get()
                .uri(ingredientMgmtMsUrl + "/api/products/list")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
}
