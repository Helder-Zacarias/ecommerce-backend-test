package com.example.ecommerce_backend_test.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String name;

    @Column
    private String slug;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String short_description;

    @Column
    private String regular_price;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<Images> images;

    @Column
    private Long woocommerceId;

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

    public Long getWoocommerceId() {
        return woocommerceId;
    }

    public void setWoocommerceId(Long woocommerceId) {
        this.woocommerceId = woocommerceId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", description='" + description + '\'' +
                ", short_description='" + short_description + '\'' +
                ", regular_price=" + regular_price +
                ", images=" + images.toString() +
                ", woocommerceId=" + woocommerceId +
                '}';
    }
}
