package com.example.Ecommerce.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@ComponentScan({"com.example.Ecommerce.Application.controller"})
public class ECommerceApplication {


	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

}
