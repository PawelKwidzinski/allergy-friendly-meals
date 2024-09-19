package pl.pkwidz.dashboard.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.pkwidz.dashboard.dto.HistamineFoodDto;
import pl.pkwidz.dashboard.dto.IngredientDto;
import pl.pkwidz.dashboard.dto.ProductDto;
import pl.pkwidz.dashboard.service.HistamineFoodService;
import pl.pkwidz.dashboard.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final HistamineFoodService histamineFoodService;

    @GetMapping("/product/create")
    public String showCreateProductForm(Model model) {
        ProductDto product = new ProductDto();
        product.setIngredients(new ArrayList<>());
        product.getIngredients().add(new IngredientDto()); // Dodaj pusty składnik
        model.addAttribute("product", product);
        return "create-product";
    }

    @GetMapping("/product/add-ingredient")
    public String addIngredient(Model model) {
        model.addAttribute("ingredient", new IngredientDto());
        return "create-product :: ingredientForm";
    }

    @PostMapping("/product/create")
    public String createProduct(@Valid ProductDto productDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "create-product :: form";
        }
        productService.saveProduct(productDto);
        return "redirect:/product/list";
    }

    @GetMapping("/product/list")
    public String listProducts(Model model) {
        List<ProductDto> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "product-list";
    }

    @GetMapping("/product/check-ingredient")
    public String checkIngredient(@RequestParam String ingredient, Model model) {
        List<HistamineFoodDto> histamineFoods = histamineFoodService.findIngredientsByName(ingredient);
        model.addAttribute("histamineFoods", histamineFoods);
        return "ingredient-check-result :: resultsList";
    }

    @PostMapping("/product/select-ingredient")
    public String selectIngredient(@RequestParam String name, @RequestParam Integer histFoodId, Model model) {
        IngredientDto ingredient = new IngredientDto(name, histFoodId);
        model.addAttribute("ingredient", ingredient);
        return "create-product :: selectedIngredient";
    }

}

