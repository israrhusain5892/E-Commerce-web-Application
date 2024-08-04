package com.example.Ecommerce.Application.Models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// import org.hibernate.annotations.DiscriminatorFormula;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;


@Data
@Entity
public class Roles {
      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
      private int role_id;
      private String name;

   @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
