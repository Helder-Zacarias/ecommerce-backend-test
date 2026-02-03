package com.example.ecommerce_backend_test.repository;

import com.example.ecommerce_backend_test.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EcommerceRepository extends JpaRepository<Product, Long> {
}
