package pl.kwidz.foodproduct.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RestClientConfig {

    @Value("${application.config.ingredient-url}")
    private String ingredientUrl;


}
