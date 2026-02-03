package com.example.ecommerce_backend_test.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WooCommerceProductDTO {
    private Long id;
    private String name;
    private String slug;
    private String description;
    @JsonProperty("short_description")
    private String short_description;
    @JsonProperty("regular_price")
    private String regular_price;
    private List<Images> images;

    public WooCommerceProductDTO() {}

    public WooCommerceProductDTO(Long id, String name, String slug, String description, String short_description, String regular_price) {
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

    public String getRegularPrice() {
        return regular_price;
    }

    public void setRegularPrice(String regular_price) {
        this.regular_price = regular_price;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "WooCommerceProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", description='" + description + '\'' +
                ", short_description='" + short_description + '\'' +
                ", regular_price=" + regular_price +
                ", images=" + images +
                '}';
    }
}
