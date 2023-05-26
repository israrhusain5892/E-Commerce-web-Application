package com.example.Ecommerce.Application.Repository;

import com.example.Ecommerce.Application.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    
  //  @Query("select u from User u where u.email=:email")
  //  public User findByEmail( @Param("email") String username);

       User findByEmail(String username);
 }
