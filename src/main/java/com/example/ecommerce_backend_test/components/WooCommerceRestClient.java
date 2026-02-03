package com.example.ecommerce_backend_test.components;

import com.example.ecommerce_backend_test.model.WooCommerceProductDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class WooCommerceRestClient {
    private final RestClient restClient;

    public WooCommerceRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<WooCommerceProductDTO> receiveProducts() {
        return restClient
                .get()
                .uri("/products")
                .retrieve()
                .body(new ParameterizedTypeReference<List<WooCommerceProductDTO>>() {});
    }
}
