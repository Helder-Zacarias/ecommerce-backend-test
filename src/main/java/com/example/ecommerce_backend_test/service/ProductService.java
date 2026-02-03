package com.example.ecommerce_backend_test.service;

import com.example.ecommerce_backend_test.client.WordPressMediaClient;
import com.example.ecommerce_backend_test.components.WooCommerceRestClient;
import com.example.ecommerce_backend_test.model.Images;
import com.example.ecommerce_backend_test.model.Product;
import com.example.ecommerce_backend_test.model.payloads.WooCommerceCreateProductRequest;
import com.example.ecommerce_backend_test.repository.EcommerceRepository;
import com.example.ecommerce_backend_test.utils.ProductMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    private final WordPressMediaClient wordPressMediaClient;
    private final WooCommerceRestClient wooCommerceRestClient;
    private final EcommerceRepository repository;

    public ProductService(WordPressMediaClient wordPressMediaClient, WooCommerceRestClient wooCommerceRestClient, EcommerceRepository repository) {
        this.wordPressMediaClient = wordPressMediaClient;
        this.wooCommerceRestClient = wooCommerceRestClient;
        this.repository = repository;
    }
    
    public void createProductInWoo() throws IOException {
        Product produto = repository.findById(1L).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        byte[] imageBytes;

        String imageSrc = produto.getImages().stream().findFirst().get().getSrc();

        Path imagePath = Path.of(imageSrc);
        imageBytes = Files.readAllBytes(imagePath);

        Images imagem = wordPressMediaClient.uploadImage(
                imageBytes,
                imagePath.getFileName().toString(),
                "image/png");

//        System.out.println("Image: " + imagem);

        WooCommerceCreateProductRequest wooCommerceCreateProductRequest = ProductMapper.toWooProductRequest(produto);
        wooCommerceCreateProductRequest.setImages(List.of(ProductMapper.toWooImageRequest(imagem)));

        System.out.println("Product Request: " + wooCommerceCreateProductRequest);
        wooCommerceRestClient.createProduct(wooCommerceCreateProductRequest);
    }
}
