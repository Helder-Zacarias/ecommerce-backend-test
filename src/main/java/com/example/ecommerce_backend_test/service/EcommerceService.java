package com.example.ecommerce_backend_test.service;

import com.example.ecommerce_backend_test.model.Product;
import com.example.ecommerce_backend_test.repository.EcommerceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcommerceService {
    private final EcommerceRepository repository;

    public EcommerceService(EcommerceRepository repository) {
        this.repository = repository;
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }
}
