package pl.kwidz.foodproduct.product;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {

    ProductRepository productRepository;

    public String saveProduct(ProductRequest productRequest) {
        Product product = Product.toProduct(productRequest);
        return productRepository.save(product).getId();
    }

}
