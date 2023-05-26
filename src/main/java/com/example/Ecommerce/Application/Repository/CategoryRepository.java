package com.example.Ecommerce.Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ecommerce.Application.Models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
      
    
}
