package com.example.Ecommerce.Application.BamborapaymentGateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BamboraClientConfig {

    private String merchantId;
    private String username;
    private String password;

    
    public BamboraClientConfig(
        @Value("${bambora.merchantId}") String merchantId,
        @Value("${bambora.username}") String username,
        @Value("${bambora.password}") String password
    ) 
    {
        this.merchantId = merchantId;
        this.username = username;
        this.password = password;
    }

    @Bean
    public BamboraClient createBamboraClient() throws Exception {
        BamboraClient bamboraClient = new BamboraClient();
        bamboraClient.setMerchantId(merchantId);
        bamboraClient.setUsername(username);
        bamboraClient.setPassword(password);
        bamboraClient.authenticate(); // Authenticate the client with Bambora API

        return bamboraClient;
    }
}


