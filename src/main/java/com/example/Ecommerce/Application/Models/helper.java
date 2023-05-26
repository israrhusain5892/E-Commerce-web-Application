package com.example.Ecommerce.Application.Models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class helper {

   // @Bean
    public String getwords(String desc){
        String[] str=desc.split(" ");
        if(str.length>10){
            String res="";
            for(int i=0; i<10; i++){
                res+=str[i]+" ";
            }
            return (res+"...");
        }
        else{
            return (desc+"...");
        }
        
    }

}
