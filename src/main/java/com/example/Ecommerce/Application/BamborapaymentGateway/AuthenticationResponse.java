package com.example.Ecommerce.Application.BamborapaymentGateway;

public class AuthenticationResponse {
    private boolean successful;
    private String accessToken;

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}

