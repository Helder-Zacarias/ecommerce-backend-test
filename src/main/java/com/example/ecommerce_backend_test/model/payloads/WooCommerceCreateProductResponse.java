package com.example.ecommerce_backend_test.model.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WooCommerceCreateProductResponse {
    private String name;
    private String slug;
    private String description;
    @JsonProperty("short_description")
    private String shortDescription;
    @JsonProperty("regular_price")
    private String regularPrice;
    private List<WooCommerceCreateImageResponse> images;

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
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(String regularPrice) {
        this.regularPrice = regularPrice;
    }

    public List<WooCommerceCreateImageResponse> getImages() {
        return images;
    }

    public void setImages(List<WooCommerceCreateImageResponse> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "WooCommerceCreateProductRequest{" +
                "name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", description='" + description + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", regularPrice='" + regularPrice + '\'' +
                ", images=" + images +
                '}';
    }
}
