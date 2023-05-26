package com.example.Ecommerce.Application.Dao;
import lombok.Data;

@Data
public class ProductDao {
    
    
    private String product_title;
    private String product_description;
    
    private int product_price;
    private int category_id;
    private double discount;
    private String product_pic;

}
