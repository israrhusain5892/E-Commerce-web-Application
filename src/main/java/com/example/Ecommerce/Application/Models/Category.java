package com.example.Ecommerce.Application.Models;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private int id;
    
    @Column(unique = true)
    private String name;

    
    public Category() {
    }


    public Category(String name) {
        this.name = name;
    }
      
    @OneToMany(mappedBy = "category", cascade=CascadeType.ALL)
    private List<Product> products=new ArrayList<>();
    
}
