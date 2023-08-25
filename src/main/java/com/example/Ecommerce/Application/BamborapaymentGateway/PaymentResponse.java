package com.example.Ecommerce.Application.BamborapaymentGateway;

import java.util.UUID;

import lombok.Data;

@Data
public class PaymentResponse {
    private String status;
    private String message;
    private String orderId;
    // Add any other relevant properties

    public PaymentResponse() {
        //this.orderId = UUID.randomUUID().toString();
        this.orderId=orderId;
    }

    public PaymentResponse(String status, String message) {
        this.status = status;
        this.message = message;
        this.orderId=orderId;
       // this.orderId = UUID.randomUUID().toString();
    }

    // Getters and setters for all properties

    // Additional methods as needed
}

