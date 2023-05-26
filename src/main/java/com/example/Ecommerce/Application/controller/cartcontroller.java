package com.example.Ecommerce.Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Ecommerce.Application.Repository.ProductRepository;



@Controller
public class cartcontroller {

    @Autowired
    private ProductRepository productRepository;
    
        
         
  
}
