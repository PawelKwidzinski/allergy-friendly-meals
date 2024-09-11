package pl.pkwidzinski.ingredient_mgmt_ms.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.pkwidzinski.ingredient_mgmt_ms.dto.ProductDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Document
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product extends BaseDocument {

    String name;
    String imageUrl;
    String unit;
    Integer quantity;
    List<Ingredient> ingredients;
    List<String> productInfos;
    Integer calories;
    BigDecimal protein;
    BigDecimal carbs;
    BigDecimal fat;
    BigDecimal fiber;
    BigDecimal sodium;
    BigDecimal vitamins;

    public ProductDto toDto() {
        return ProductDto.builder()
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

    public static Product fromDto(ProductDto productDto) {
        Product product = new Product();
        mapToCreateBaseDocument(product);
        mapToProduct(productDto, product);
        return product;
    }

    private static void mapToCreateBaseDocument(Product product) {
        product.setCreatedAt(LocalDateTime.now());
        product.setCreatedBy("Test User");
        product.setUpdatedAt(null);
        product.setUpdatedBy(null);
    }

    public static void mapToUpdateBaseDocument(Product product) {
        product.setUpdatedAt(LocalDateTime.now());
        product.setUpdatedBy("Test User");
    }

    public static void mapToProduct(ProductDto productDto, Product product) {
        product.setName(productDto.name());
        product.setImageUrl(productDto.imageUrl());
        product.setUnit(productDto.unit());
        product.setQuantity(productDto.quantity());
        product.setIngredients(productDto.ingredients());
        product.setProductInfos(productDto.productInfos());
        product.setCalories(productDto.calories());
        product.setProtein(productDto.protein());
        product.setCarbs(productDto.carbs());
        product.setFat(productDto.fat());
        product.setFiber(productDto.fiber());
        product.setSodium(productDto.sodium());
        product.setVitamins(productDto.vitamins());
    }

}
