package com.example.Ecommerce.Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ecommerce.Application.Models.Roles;

@Repository
public interface Rolerepository extends JpaRepository<Roles,Integer>{
    
}
