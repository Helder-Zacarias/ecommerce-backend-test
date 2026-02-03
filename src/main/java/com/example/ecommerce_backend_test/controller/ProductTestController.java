package com.example.ecommerce_backend_test.controller;

import com.example.ecommerce_backend_test.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/test-product-creation")
public class ProductTestController {

    private final ProductService productService;

    public ProductTestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public void createTestProduct() throws IOException {
        productService.createProductInWoo();
    }
}
