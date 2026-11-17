package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @RequestMapping("/orders")
    public ResponseEntity<?> orderServiceFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(Map.of(
                        "status", 503,
                        "service", "order-service",
                        "message", "Order Service is currently unavailable. Please try again later.",
                        "timestamp", Instant.now().toString()
                ));
    }

    @RequestMapping("/products")
    public ResponseEntity<?> productServiceFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(Map.of(
                        "status", 503,
                        "service", "product-service",
                        "message", "Product Service is currently unavailable. Please try again later.",
                        "timestamp", Instant.now().toString()
                ));
    }
}