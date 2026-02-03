package com.example.ecommerce_backend_test.controller;

import com.example.ecommerce_backend_test.service.ProductSyncService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/webhooks/woocommerce")
public class WebHookController {

    private final ProductSyncService productSyncService;

    public WebHookController(ProductSyncService productSyncService) {
        this.productSyncService = productSyncService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Object> saveProduct(HttpServletRequest request) throws IOException {
        String payload = request
                .getReader()
                .lines()
                .collect(Collectors.joining("\n"));
        String contentType = request.getContentType();

        System.out.println(payload);

        if (payload.startsWith("webhook_id=")) {
            return ResponseEntity.ok().build();
        }

        if(contentType != null && contentType.contains("application/json")) {
            System.out.println("SAVE Endpoint");
            productSyncService.handleWebHook(payload);
        }

        return ResponseEntity.ok().build();
    }
}
