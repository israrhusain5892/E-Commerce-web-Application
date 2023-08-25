package com.example.Ecommerce.Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Ecommerce.Application.BamborapaymentGateway.BamboraClient;
import com.example.Ecommerce.Application.Models.PaymentRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/user")
public class PaymentController {
    
    // @Autowired
    // private BamboraClient bamboraClient;
    
    // @PostMapping("/v1/payments")
    // public String processPayment(@ModelAttribute RequestPayment RequestPayment, Model model) throws Exception {
    //     // Call the Bambora API to process the payment
    //     String paymentdata = convertPaymentRequestToJson(RequestPayment);
    //     String paymentResponse = bamboraClient.makePaymentRequest(paymentdata);


    //     // Add the payment response to the model to be displayed on the front-end
    //      model.addAttribute("paymentResponse", paymentResponse);

    //     // Return the Thymeleaf template to render the payment response
    //     return "redirect:/user/transaction";
    // }


    // public String convertPaymentRequestToJson(RequestPayment RequestPayment) throws JsonProcessingException {
    //     ObjectMapper objectMapper = new ObjectMapper();
    //     return objectMapper.writeValueAsString(RequestPayment);
    // }

}
