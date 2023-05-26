package com.example.Ecommerce.Application.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ecommerce.Application.Models.User;
import com.example.Ecommerce.Application.Repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void registerUser(User user){
         userRepo.save(user);
    }
}
