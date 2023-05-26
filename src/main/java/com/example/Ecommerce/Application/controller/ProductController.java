package com.example.Ecommerce.Application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.Ecommerce.Application.Models.Product;
import com.example.Ecommerce.Application.Repository.CategoryRepository;
import com.example.Ecommerce.Application.Service.ProductService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryRepository categoryRepository;

   
    // @PostMapping("/addproduct")
    // public void addproductbycategoryid(@ModelAttribute("product") Product product) throws Exception {
    //        productService.addProduct(product);
           
    // }

    @RequestMapping("/deleteproduct")
    public void deleteproduct(@RequestParam("id") int id) throws Exception{
          productService.DeleteProduct(id);
    }

    @RequestMapping("/updateproduct")
    public void updateproduct(@RequestParam("id") int id) throws Exception{
        productService.Updateproduct(id);
    }

    @RequestMapping("/getproduct")
    public Product getproductById(@RequestParam("id") int id) throws Exception{
           return productService.getproduct(id);
    }

    // @RequestMapping("/getallproducts") 
    // public List<Product> getAllProducts() throws Exception{
    //     return productService.getAllProducts();
    // }
}
