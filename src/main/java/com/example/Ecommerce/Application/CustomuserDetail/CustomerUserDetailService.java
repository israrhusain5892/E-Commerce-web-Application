package com.example.Ecommerce.Application.CustomuserDetail;

import com.example.Ecommerce.Application.Models.User;
import com.example.Ecommerce.Application.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomerUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=repo.findByEmail(username);
        if(user==null){
            throw new UsernameNotFoundException("no user found");
        }
        return new CustomerUserDetail(user);
    }
}
