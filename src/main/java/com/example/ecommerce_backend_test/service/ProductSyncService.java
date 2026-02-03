package com.example.ecommerce_backend_test.service;

import com.example.ecommerce_backend_test.components.WooCommerceRestClient;
import com.example.ecommerce_backend_test.model.Product;
import com.example.ecommerce_backend_test.model.WooCommerceProductDTO;
import com.example.ecommerce_backend_test.repository.EcommerceRepository;
import com.example.ecommerce_backend_test.utils.ProductMapper;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSyncService {
    private final WooCommerceRestClient client;
    private final EcommerceRepository repository;
    private final ObjectMapper objectMapper;

    public ProductSyncService(WooCommerceRestClient client, EcommerceRepository repository, ObjectMapper objectMapper) {
        this.client = client;
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    public void syncProducts() {
        List<WooCommerceProductDTO> wooCommerceProductDTOS = client.receiveProducts();
        wooCommerceProductDTOS.forEach(this::saveProduct);
    }

    public void saveProduct(WooCommerceProductDTO wooCommerceProductDTO) {
        Optional<Product> dbResult = repository.findById(wooCommerceProductDTO.getId());
        Product product = ProductMapper.toProduct(wooCommerceProductDTO);
        dbResult.ifPresent(p -> product.setId(p.getId()));
        repository.save(product);
    }

    public void handleWebHook(String payload) {
        WooCommerceProductDTO wooCommerceProductDTO = objectMapper.readValue(payload, WooCommerceProductDTO.class);
//        Use switch case later
       saveProduct(wooCommerceProductDTO);
    }
}
