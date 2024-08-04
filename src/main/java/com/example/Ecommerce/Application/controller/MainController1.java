package com.example.Ecommerce.Application.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Ecommerce.Application.Models.Cart;
import com.example.Ecommerce.Application.Models.Product;
import com.example.Ecommerce.Application.Models.Roles;
import com.example.Ecommerce.Application.Models.Sendmessage;
import com.example.Ecommerce.Application.Models.User;
import com.example.Ecommerce.Application.Repository.ProductRepository;
import com.example.Ecommerce.Application.Service.CategoryService;
import com.example.Ecommerce.Application.Service.RoleService;
import com.example.Ecommerce.Application.Service.UserService;


import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class MainController1 {

    @Autowired
    private RoleService rolService;

    @Autowired
    private BCryptPasswordEncoder encoder;
  
    @Autowired
    private UserService userService;

   @Autowired
   private CategoryService categoryService;

   @Autowired
   private ProductRepository productRepository;

 

    @RequestMapping("dologin")
     public String loginpage(){
         return "login";
         
     }

     @RequestMapping("showproduct/{id}")
     public String showproductsById(Model model,@PathVariable("id") int id) throws Exception{
        model.addAttribute("categories1", categoryService.getAllcategories());
        model.addAttribute("Allproducts", productRepository.findAllByCategory_id(id));
        return "index";
     }

     @RequestMapping("")
     public String showCategoryandproducts(Model model) throws Exception{
        model.addAttribute("categories1", categoryService.getAllcategories());
        model.addAttribute("Allproducts", productRepository.findAll());
        return "index";
     }
    
     @RequestMapping("registerpage")
     public String registerPage(){
        return "register";

     }
  

     @PostMapping("register")
     public String register(@ModelAttribute("user") User user,HttpSession session){
           
       try{
          String password=user.getPassword();
    
           user.setPassword(encoder.encode(password));
           Set<Roles> roles=user.getRoles();
            if(roles==null){
            roles=new HashSet<>();
          }
           
           roles.add(rolService.getrolebyid(2));
           user.setRoles(roles);
           userService.registerUser(user);
            session.setAttribute("message", new Sendmessage("You have been registered successfully","success"));
          }
          
          catch(Exception e){
              
               session.setAttribute("message", new Sendmessage("Not registered some thing went wrong try again!","danger"));
          }
        
           return "redirect:/registerpage";

   }
}
