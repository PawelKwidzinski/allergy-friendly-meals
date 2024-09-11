package pl.pkwidzinski.ingredient_mgmt_ms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.pkwidzinski.ingredient_mgmt_ms.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
