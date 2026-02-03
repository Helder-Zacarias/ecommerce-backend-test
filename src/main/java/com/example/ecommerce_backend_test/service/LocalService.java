package com.example.ecommerce_backend_test.service;

import com.example.ecommerce_backend_test.model.Product;
import com.example.ecommerce_backend_test.repository.EcommerceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalService {
    private final EcommerceRepository repository;

    public LocalService(EcommerceRepository repository) {
        this.repository = repository;
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }
}
