package com.example.ecommerce_backend_test.model.payloads;

public class WooCommerceCreateImageResponse {
    private Long id;

    private String src;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "WooCommerceCreateImageResponse{" +
                "id=" + id +
                ", src='" + src + '\'' +
                '}';
    }
}
