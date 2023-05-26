package com.example.Ecommerce.Application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Ecommerce.Application.Models.Category;

import com.example.Ecommerce.Application.Service.CategoryService;



@Controller
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    // @PostMapping("/addcategory")
    // public void addCategory(@ModelAttribute("category") Category category) throws Exception{
    //     categoryService.addCategory(category);
    // }

    @RequestMapping("/updatecategory")
    public void updateCategory(@RequestParam int id) throws Exception{
        categoryService.updateCategory(id);
    }

    @RequestMapping("/getcategory")
    public Category getcategory(@RequestParam int id) throws Exception {
        return categoryService.getCategory(id);
    }
    @RequestMapping("/deletecategory")
    public void deleteCategory( @RequestParam int id) throws Exception{
           categoryService.deleteCategory(id);
    }
    @RequestMapping("/getallcategory")
    public List<Category> getAllcategories() throws Exception{
        return categoryService.getAllcategories();
    }
    
    }
    

