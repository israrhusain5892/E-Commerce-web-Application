package com.example.Ecommerce.Application.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.OneToOne;

@Data
@Entity
@Table
public class Cart {
     @Id
     private int id;
    
    @OneToOne
    @JoinColumn
    private User user;
    
    @OneToOne
    @JoinColumn
    private Product product;

    public Cart() {
    }

    public Cart(int id, User user, Product product) {
        this.id=id;
        this.user = user;
        this.product = product;
    }


    
}
