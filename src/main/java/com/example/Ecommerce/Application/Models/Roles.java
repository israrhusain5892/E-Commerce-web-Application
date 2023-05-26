package com.example.Ecommerce.Application.Models;

import java.util.List;

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
@Table
public class Roles {
      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
      private int id;
      private String name;


      @ManyToMany(mappedBy="roles")
      private List<User> users;

}
