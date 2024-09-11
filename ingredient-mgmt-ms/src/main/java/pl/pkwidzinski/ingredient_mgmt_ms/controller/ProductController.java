package pl.pkwidzinski.ingredient_mgmt_ms.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.pkwidzinski.ingredient_mgmt_ms.constans.Constants;
import pl.pkwidzinski.ingredient_mgmt_ms.dto.HttpResponseDto;
import pl.pkwidzinski.ingredient_mgmt_ms.dto.ProductDto;
import pl.pkwidzinski.ingredient_mgmt_ms.model.Product;
import pl.pkwidzinski.ingredient_mgmt_ms.service.IProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("/api/products")
public class ProductController {

    IProductService iProductService;

    @PostMapping("/create")
    ResponseEntity<HttpResponseDto> createProduct(@Valid @RequestBody ProductDto productDto) {
        iProductService.saveProduct(productDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new HttpResponseDto(Constants.STATUS_201, Constants.MESSAGE_201));
    }

    @GetMapping("/list")
    ResponseEntity<List<ProductDto>> getAllProducts() {
        List<Product> allProducts = iProductService.findAllProducts();
        return ResponseEntity.ok(allProducts.stream().map(Product::toDto).toList());
    }

    @PatchMapping("/update")
    ResponseEntity<HttpResponseDto> updateProduct(
            @RequestParam
            @Pattern(regexp = "(^[A-Za-z0-9]+$)", message = "id must be with latin letters and digits") String id,
            @Valid @RequestBody ProductDto productDto) {
        boolean isUpdated = iProductService.updateProduct(id, productDto);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new HttpResponseDto(Constants.STATUS_200, Constants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new HttpResponseDto(Constants.STATUS_417, Constants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    ResponseEntity<HttpResponseDto> deleteProduct(
            @RequestParam
            @Pattern(regexp = "(^[A-Za-z0-9]+$)", message = "id must be with latin letters and digits") String id) {
        boolean isDeleted = iProductService.deleteProduct(id);
        if (isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new HttpResponseDto(Constants.STATUS_200, Constants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new HttpResponseDto(Constants.STATUS_417, Constants.MESSAGE_417_DELETE));
        }
    }
}
