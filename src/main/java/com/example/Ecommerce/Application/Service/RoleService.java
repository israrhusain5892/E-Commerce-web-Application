package com.example.Ecommerce.Application.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ecommerce.Application.Models.Roles;
import com.example.Ecommerce.Application.Repository.Rolerepository;

@Service
public class RoleService {
    
    @Autowired
    private Rolerepository rolerepository;

     public Roles getrolebyid(int id){
           return rolerepository.findById(id).get();
     }
}
