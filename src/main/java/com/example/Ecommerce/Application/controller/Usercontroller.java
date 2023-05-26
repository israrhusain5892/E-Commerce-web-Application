package com.example.Ecommerce.Application.controller;



import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Ecommerce.Application.Models.Bill;
import com.example.Ecommerce.Application.Models.Cart;
//import com.example.Ecommerce.Application.Models.Category;
import com.example.Ecommerce.Application.Models.Product;
import com.example.Ecommerce.Application.Models.Sendmessage;
import com.example.Ecommerce.Application.Models.User;
import com.example.Ecommerce.Application.Repository.BillRepository;
import com.example.Ecommerce.Application.Repository.CartRepository;
import com.example.Ecommerce.Application.Repository.ProductRepository;
import com.example.Ecommerce.Application.Repository.UserRepo;
import com.example.Ecommerce.Application.Service.CartService;
import com.example.Ecommerce.Application.Service.CategoryService;
import com.example.Ecommerce.Application.Service.UserService;

import jakarta.servlet.http.HttpSession;





@Controller
@RequestMapping("/user")
public class Usercontroller{
      
      static List<Product> list;

     @Autowired
     private BillRepository billRepository;

     @Autowired
     private CartRepository cartRepository;

     @Autowired
     private UserRepo userRepo;
     
     @Autowired
     private UserService userService;
 
    @Autowired
    private CategoryService categoryService;
 
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartService cartService;
        
   
    

         @RequestMapping("/removecart/{id}")
         public String deletecart(@PathVariable int id){
           Cart cart=cartRepository.findById(id).get();
            cartRepository.delete(cart);
           // list.clear();
             return "redirect:/user/showcart";
         }
     
          String userName;
          User user;
          @RequestMapping("/dashboard")
           public String viewUserpage(Model model,Principal principal)throws Exception{
                userName=principal.getName();
                user=userRepo.findByEmail(userName);
               model.addAttribute("categories1", categoryService.getAllcategories());
           
               model.addAttribute("Allproducts", productRepository.findAll());
                 model.addAttribute("user",user);
               
               if(user.getEmail().equals("admin123@gmail.com")){
                       return "redirect:/admin/dashboard";
               }
                
                return "user_home";
           }


           @RequestMapping("/dashboard/{id}")
           public String showproductsById(Model model,@PathVariable("id") int id,Principal principal) throws Exception{
               model.addAttribute("categories1", categoryService.getAllcategories());
               model.addAttribute("Allproducts", productRepository.findAllByCategory_id(id));
               //String userName=principal.getName();
               User user=userRepo.findByEmail(userName);
               model.addAttribute("user",user);
               return "user_home";

           }
           
          
        @GetMapping("/addcart/{id}")
        public String addCart(@PathVariable("id") int id, Principal principal,Model model){

          
           

          try{
             String username=principal.getName();
             User user=userRepo.findByEmail(username);
             cartService.addcart(user,id);
             model.addAttribute("cartscount", cartRepository.findAllByUser_id(user.getId()).size());
             Cart cart=cartRepository.findById(id).get();
             model.addAttribute("Allproducts", cart.getProduct());
              
          }
          catch(Exception e){
            e.printStackTrace();
          }
              return "redirect:/user/dashboard";
        }
          
        
          static int totalAmount=0;

          @RequestMapping("/showcart")
          public String addcart(Model model){
            list=new ArrayList();
            for(Cart cart:cartRepository.findAll()){
                list.add(cart.getProduct());
                totalAmount+=cart.getProduct().getProduct_price();
            }
             model.addAttribute("Allproducts",list);
             model.addAttribute("size",list.size());
             model.addAttribute("totalAmount", totalAmount);
             
              return "cart";
           }


           @RequestMapping("/gobill")
           public String goBill(){
                return "bill";
           }
         
          



           @PostMapping("/addbill")
           public String addBill(@ModelAttribute("bill") Bill bill){
               try{
                 billRepository.save(bill);
               }
               catch(Exception e){
                   e.printStackTrace();
               }
                 return "bill";
               
           }

           @RequestMapping("/transaction")
           public String showTransaction(Model model,HttpSession session){
               
            // session.setAttribute("message", new Sendmessage("payment done successfully","success"));
               model.addAttribute("totalamount",totalAmount);
                return "transaction" ;
           }

           
    }
      
          
    
      

