package com.example.ecommerce_backend_test.client;

import com.example.ecommerce_backend_test.model.Images;
import org.apache.hc.core5.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class WordPressMediaClient {
    private final RestClient restClient;

    public WordPressMediaClient(@Qualifier("wpClient") RestClient restClient) {
        this.restClient = restClient;
    }

    public Images uploadImage(byte[] imageBytes, String filename, String mimeType) {
        return restClient
                .post()
                .header(HttpHeaders.CONTENT_TYPE, mimeType)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                .body(imageBytes)
                .retrieve()
                .body(Images.class);
    }
}
