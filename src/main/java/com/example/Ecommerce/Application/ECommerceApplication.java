package com.example.Ecommerce.Application;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
//@ComponentScan({"com.example.Ecommerce.Application.controller"})
public class ECommerceApplication  {
     

	// @Autowired
    //  private BCryptPasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	// @Override
	// public void run(String... args) throws Exception {
	// 	// TODO Auto-generated method stub
    //      System.out.println(encoder.encode("Admin@1234"));
	// 	throw new UnsupportedOperationException("Unimplemented method 'run'");
	// }

}
