package com.example.Ecommerce.Application.BamborapaymentGateway;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String merchantId;
    private String username;
    private String password;



public AuthenticationRequest(String merchantId, String username, String password) {
        this.merchantId = merchantId;
        this.username = username;
        this.password = password;
    }

    
}

