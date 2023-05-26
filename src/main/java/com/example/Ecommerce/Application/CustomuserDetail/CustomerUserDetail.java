package com.example.Ecommerce.Application.CustomuserDetail;

import com.example.Ecommerce.Application.Models.Roles;
import com.example.Ecommerce.Application.Models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerUserDetail extends User implements UserDetails {
    private User user;
      public CustomerUserDetail(User user){
          super(user);
          this.user=user;
      }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       
        List<GrantedAuthority> grantedAuthorityList=new ArrayList<>();
             List<Roles> roles=user.getRoles();
             for(Roles role:roles){

                grantedAuthorityList.add(new SimpleGrantedAuthority(role.getName()));
             }
                return grantedAuthorityList;
        }

    @Override
    public String getUsername() {
        return super.getEmail();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
