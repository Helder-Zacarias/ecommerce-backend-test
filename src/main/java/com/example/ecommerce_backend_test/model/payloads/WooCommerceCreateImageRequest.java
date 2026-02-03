package com.example.ecommerce_backend_test.model.payloads;

public class WooCommerceCreateImageRequest {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WooCommerceCreateImageRequest() {
    }

    public WooCommerceCreateImageRequest(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "WooCommerceCreateImageRequest{" +
                "id='" + id + '\'' +
                '}';
    }
}
