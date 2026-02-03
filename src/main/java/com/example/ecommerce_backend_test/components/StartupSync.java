package com.example.ecommerce_backend_test.components;

import com.example.ecommerce_backend_test.service.ProductSyncService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupSync {
    private final ProductSyncService syncService;

    public StartupSync(ProductSyncService syncService) {
        this.syncService = syncService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onStartup() {
        syncService.syncProducts();
    }
}
