package com.example.Ecommerce.Application.BamborapaymentGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//mport org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import lombok.Data;

//importjava.net.http.HttpHeaders;

@Data

@Service
public class PaymentService1 {

    @Value("${bambora.merchantId}")
    private String merchantId;

    @Value("${bambora.username}")
    private String username;

    @Value("${bambora.password}")
    private String password;

    @Autowired
    private BamboraClient bamboraClient;

    
    public PaymentService1(BamboraClientConfig bamboraClientConfig) throws Exception {
        this.bamboraClient = bamboraClientConfig.createBamboraClient();
    }
   
    // ...

}
