package com.example.ecommerce_backend_test.utils;

import com.example.ecommerce_backend_test.model.Product;
import com.example.ecommerce_backend_test.model.WooCommerceProductDTO;

public class ProductMapper {
    public static Product toProduct(WooCommerceProductDTO wooProductDTO) {
        Product product = new Product();

        product.setName(wooProductDTO.getName());
        product.setSlug(wooProductDTO.getSlug());
        product.setDescription(wooProductDTO.getDescription());
        product.setShortDescription(wooProductDTO.getShortDescription());
        product.setRegularPrice(wooProductDTO.getRegularPrice());
        product.setWoocommerceId(wooProductDTO.getId());
        return product;
    }

    public static WooCommerceProductDTO toWooDTO(Product product) {
        return new WooCommerceProductDTO(
                product.getId(),
                product.getName(),
                product.getSlug(),
                product.getDescription(),
                product.getShortDescription(),
                product.getRegularPrice()
        );
    }
}
