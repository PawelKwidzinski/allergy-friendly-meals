package pl.pkwidzinski.ingredient_mgmt_ms.service;

import pl.pkwidzinski.ingredient_mgmt_ms.dto.ProductDto;
import pl.pkwidzinski.ingredient_mgmt_ms.model.Product;

import java.util.List;

public interface IProductService {
    void saveProduct(ProductDto product);
    List<Product> findAllProducts();
    ProductDto findProductById(String id);
    boolean updateProduct(String productId, ProductDto productDto);
    boolean deleteProduct(String productId);

}
