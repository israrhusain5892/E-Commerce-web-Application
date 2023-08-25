package com.example.Ecommerce.Application.BamborapaymentGateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BamboraApiConfig {

    @Value("${bambora.api.base-url}")
    private String baseUrl;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}

