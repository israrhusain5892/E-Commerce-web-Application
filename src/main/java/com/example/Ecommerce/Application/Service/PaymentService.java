// package com.example.Ecommerce.Application.Service;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.Ecommerce.Application.BamborapaymentGateway.BamboraClient;
// import com.example.Ecommerce.Application.BamborapaymentGateway.PaymentResponse;
// import com.example.Ecommerce.Application.Models.PaymentRequest;
// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.ObjectMapper;

// @Service
// public class PaymentService {

//     @Autowired
//     private BamboraClient bamboraClient;
    
//     public PaymentResponse processPayment(PaymentRequest paymentRequest) throws Exception {
//         // Perform the payment processing logic here
//         // You can interact with the Bambora SDK or any other payment gateway
//         String data=convertPaymentRequestToJson(paymentRequest);
//          bamboraClient.makePaymentRequest(data);
//         // Example response data
//         PaymentResponse paymentResponse = new PaymentResponse();
//         paymentResponse.setStatus("success");
//         paymentResponse.setMessage("Payment successful");
//         paymentResponse.setTransactionId(paymentResponse.getTransactionId());
//         // Set any other relevant data in the payment response
        
//         return paymentResponse;
//     }

//     public String convertPaymentRequestToJson(PaymentRequest RequestPayment) throws JsonProcessingException {
//         ObjectMapper objectMapper = new ObjectMapper();
//         return objectMapper.writeValueAsString(RequestPayment);
//     }
// }