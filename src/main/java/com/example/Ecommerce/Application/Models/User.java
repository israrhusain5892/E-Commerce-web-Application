package com.example.Ecommerce.Application.Models;

import java.util.ArrayList;
import java.util.List;


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
import lombok.Data;


@Data
@Entity
@Table
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


      @ManyToMany(cascade = CascadeType.MERGE,fetch=FetchType.EAGER)
      @JoinTable(
          name="user_role",
          joinColumns={@JoinColumn (name="USER_ID",referencedColumnName = "ID")},
          inverseJoinColumns={@JoinColumn (name="ROLE_ID",referencedColumnName="ID")}

      )
      private List<Roles> roles;
     public User(){
        
     }

//      constructor
      public User(User user){
          this.userName=user.getUserName();
          this.email=user.getEmail();
          this.password=user.getPassword();
          this.phone=user.getPhone();
          this.address=user.getAddress();

      }
}
