package com.example.Ecommerce.Application.Service;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.stereotype.Service;

import com.example.Ecommerce.Application.Models.Cart;
import com.example.Ecommerce.Application.Models.Product;
import com.example.Ecommerce.Application.Models.User;
import com.example.Ecommerce.Application.Repository.CartRepository;
import com.example.Ecommerce.Application.Repository.ProductRepository;
import com.example.Ecommerce.Application.Repository.UserRepo;

@Service
public class CartService {
   
   @Autowired
   private CartRepository cartRepository;
   
   @Autowired
   private  UserRepo userrepo;

   @Autowired
   private ProductRepository productRepository;
    
    public Cart addcart(User user,int id){
       
        Product product=productRepository.findById(id).get();
        Cart cart=new Cart(id,user,product);
        cartRepository.save(cart);
        return cart;
    }
}
