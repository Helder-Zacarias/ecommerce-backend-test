package com.example.ecommerce_backend_test.controller;

import com.example.ecommerce_backend_test.components.WooCommerceRestClient;
import com.example.ecommerce_backend_test.model.Product;
import com.example.ecommerce_backend_test.model.WooCommerceProductDTO;
import com.example.ecommerce_backend_test.service.EcommerceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EcommerceController {
    private final EcommerceService service;
    private final WooCommerceRestClient wooClient;

    public EcommerceController(EcommerceService service, WooCommerceRestClient wooClient) {
        this.service = service;
        this.wooClient = wooClient;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/woo-products")
    public List<WooCommerceProductDTO> sendToWoocommerce() {
        return wooClient.receiveProducts();
    }
}
