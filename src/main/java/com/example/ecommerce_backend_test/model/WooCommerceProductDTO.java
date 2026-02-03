package com.example.ecommerce_backend_test.model;

import java.math.BigDecimal;

public class WooCommerceProductDTO {
    private Long id;
    private String name;
    private String slug;
    private String description;
    private String short_description;
    private BigDecimal regular_price;

    public WooCommerceProductDTO() {}

    public WooCommerceProductDTO(Long id, String name, String slug, String description, String short_description, BigDecimal regular_price) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.short_description = short_description;
        this.regular_price = regular_price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return short_description;
    }

    public void setShortDescription(String short_description) {
        this.short_description = short_description;
    }

    public BigDecimal getRegularPrice() {
        return regular_price;
    }

    public void setRegularPrice(BigDecimal regular_price) {
        this.regular_price = regular_price;
    }

    @Override
    public String toString() {
        return "WooCommerceProductDTO{" +
                "name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", description='" + description + '\'' +
                ", short_description='" + short_description + '\'' +
                ", regular_price=" + regular_price +
                '}';
    }
}
