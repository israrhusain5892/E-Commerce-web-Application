package com.example.Ecommerce.Application.Models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;

import jakarta.persistence.Table;
import lombok.Data;
//import jakarta.persistence.OneToOne;

@Data
@Entity
@Table
public class Bill {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String name;
   private Long phone;
   private String address;
   private int pin;

 }
