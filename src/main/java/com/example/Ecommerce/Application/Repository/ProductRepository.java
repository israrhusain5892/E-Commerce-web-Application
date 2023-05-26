package com.example.Ecommerce.Application.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Ecommerce.Application.Models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    //Product findByName(String productname);
    // @Query("select u from Product u where u.product_title=:product_title")    
    // public Product findByName(@Param("product_title")String product_title);
      List<Product> findAllByCategory_id(int id);
}
   

