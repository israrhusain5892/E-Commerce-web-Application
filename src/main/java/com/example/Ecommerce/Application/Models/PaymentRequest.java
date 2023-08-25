package com.example.Ecommerce.Application.Models;

import java.sql.Date;

import lombok.Data;

@Data
public class PaymentRequest {
    private double amount;
    private Long card_number;
    private int cvv;
    private Date expiry_date;

     public PaymentRequest() {
    }
    public PaymentRequest(double amount, Long card_number, int cvv, Date expiry_date) {
        this.amount = amount;
        this.card_number = card_number;
        this.cvv = cvv;
        this.expiry_date = expiry_date;
    }
   

    
}
