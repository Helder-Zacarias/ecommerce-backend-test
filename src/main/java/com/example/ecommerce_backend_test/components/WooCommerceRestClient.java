package com.example.ecommerce_backend_test.components;

import com.example.ecommerce_backend_test.model.WooCommerceProductDTO;
import com.example.ecommerce_backend_test.model.payloads.WooCommerceCreateProductRequest;
import com.example.ecommerce_backend_test.model.payloads.WooCommerceCreateProductResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class WooCommerceRestClient {
    private final RestClient restClient;

    public WooCommerceRestClient(@Qualifier("wooClient") RestClient restClient) {
        this.restClient = restClient;
    }

    public List<WooCommerceProductDTO> receiveProducts() {
        return restClient
                .get()
                .uri("/products")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public WooCommerceCreateProductResponse createProduct(WooCommerceCreateProductRequest request) {
        WooCommerceCreateProductResponse response = restClient.post().uri("/products").body(request).retrieve().body(WooCommerceCreateProductResponse.class);
        System.out.println("Product Response " + response);
        return response;
    }
}
