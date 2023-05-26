package com.example.Ecommerce.Application.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ecommerce.Application.Models.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
    //   void addCartByUser_id(int id);
    List<Cart> findAllByUser_id(int id);
} 
