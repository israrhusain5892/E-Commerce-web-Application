package com.example.Ecommerce.Application.Models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String email;
    private String password;
    private Long phone;
    private String address;


    // @OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    //  private List<Cart> carts;


    @ManyToMany(cascade = {CascadeType.ALL,CascadeType.REMOVE},fetch = FetchType.EAGER )
    @JoinTable(name="user_role",
             joinColumns = {@JoinColumn(name="USER",referencedColumnName = "ID")},
            inverseJoinColumns ={@JoinColumn(name="ROLE",referencedColumnName = "role_id")})
      private Set<Roles> roles=new HashSet<>();

      public User(){
        
      }
 
 //      constructor
       public User(User user){
           this.userName=user.getUserName();
           this.email=user.getEmail();
           this.password=user.getPassword();
           this.phone=user.getPhone();
           this.address=user.getAddress();
           this.roles=user.getRoles();
 
       }
    
}
