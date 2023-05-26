package com.example.Ecommerce.Application.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String product_title;
    private String product_description;
    private String product_pic;
    private int product_price;
    private double discount;
    
    public Product() {
    }

    public Product(String porduct_title, String product_description, String product_pic, int product_price,double discount) {
        this.product_title = porduct_title;
        this.product_description = product_description;
        this.product_pic = product_pic;
        this.product_price = product_price;
        this.discount=discount;
    }
  
    //  @ManyToOne
    //  @JoinColumn
    //  private User user;

     @ManyToOne
     @JoinColumn(name="category_id")
     private Category category;

}
