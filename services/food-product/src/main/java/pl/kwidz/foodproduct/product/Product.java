package pl.kwidz.foodproduct.product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.kwidz.foodproduct.ingredient.IngredientResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "food_products")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    @Id
    String id;
    @CreatedDate
    LocalDateTime createdAt;
    String createdBy;
    @LastModifiedDate
    LocalDateTime updatedAt;
    String updatedBy;
    String name;
    String imageUrl;
    String unit;
    Integer quantity;
    List<IngredientResponse> ingredients;
    List<String> productInfos;
    Integer calories;
    BigDecimal protein;
    BigDecimal carbs;
    BigDecimal fat;
    BigDecimal fiber;
    BigDecimal sodium;
    BigDecimal vitamins;

    public ProductResponse toProductResponse() {
        return ProductResponse.builder()
                .id(id)
                .createdAt(createdAt)
                .createdBy(createdBy)
                .updatedAt(updatedAt)
                .updatedBy(updatedBy)
                .name(name)
                .imageUrl(imageUrl)
                .unit(unit)
                .quantity(quantity)
                .ingredients(ingredients)
                .productInfos(productInfos)
                .calories(calories)
                .protein(protein)
                .carbs(carbs)
                .fat(fat)
                .fiber(fiber)
                .sodium(sodium)
                .vitamins(vitamins)
                .build();
    }

    public static Product toProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.name());
        product.setImageUrl(productRequest.imageUrl());
        product.setUnit(productRequest.unit());
        product.setQuantity(productRequest.quantity());
        product.setIngredients(productRequest.ingredients());
        product.setProductInfos(productRequest.productInfos());
        product.setCalories(productRequest.calories());
        product.setProtein(productRequest.protein());
        product.setCarbs(productRequest.carbs());
        product.setFat(productRequest.fat());
        product.setFiber(productRequest.fiber());
        product.setSodium(productRequest.sodium());
        product.setVitamins(productRequest.vitamins());
        return product;
    }
}
