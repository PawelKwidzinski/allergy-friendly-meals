package pl.pkwidzinski.ingredient_mgmt_ms.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import pl.pkwidzinski.ingredient_mgmt_ms.dto.ProductDto;
import pl.pkwidzinski.ingredient_mgmt_ms.exception.ResourceNotFoundException;
import pl.pkwidzinski.ingredient_mgmt_ms.model.Product;
import pl.pkwidzinski.ingredient_mgmt_ms.repository.ProductRepository;
import pl.pkwidzinski.ingredient_mgmt_ms.service.IProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductServiceImp implements IProductService {

    ProductRepository productRepository;

    /**
     * @param productDto - ProductDto Object
     */
    @Override
    public void saveProduct(ProductDto productDto) {
        Product product = Product.fromDto(productDto);
        productRepository.save(product);
    }

    /**
     * @return list of Products
     */
    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    /**
     * @param productId - Product ID
     * @return ProductDTO Object
     */
    @Override
    public ProductDto findProductById(String productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product", "productId", productId)
        );
        return product.toDto();
    }

    /**
     * @param productId - Product ID
     * @param productDto - CustomerDto Object
     * @return boolean indicating if the update of Product is successful or not
     */
    @Override
    public boolean updateProduct(String productId, ProductDto productDto) {
        boolean isUpdated = false;

        if (productDto != null) {
            Product foundedProduct = productRepository.findById(productId).orElseThrow(
                    () -> new ResourceNotFoundException("Product", "productId", productId));

            Product.mapToUpdateBaseDocument(foundedProduct);
            Product.mapToProduct(productDto, foundedProduct);

            productRepository.save(foundedProduct);
            isUpdated = true;
        }
        return isUpdated;
    }

    /**
     * @param productId - Product ID
     * @return boolean indicating if the delete of Product is successful or not
     */
    @Override
    public boolean deleteProduct(String productId) {
        Product toDelete = productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product", "productId", productId));

        productRepository.delete(toDelete);
        return true;
    }

}