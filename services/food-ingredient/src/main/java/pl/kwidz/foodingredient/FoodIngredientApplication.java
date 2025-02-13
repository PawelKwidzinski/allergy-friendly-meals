package pl.kwidz.foodingredient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class FoodIngredientApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodIngredientApplication.class, args);
    }

}
