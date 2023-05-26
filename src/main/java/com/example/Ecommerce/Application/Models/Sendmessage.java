package com.example.Ecommerce.Application.Models;

import lombok.Data;

@Data
public class Sendmessage {
     private String msg;
     private String type;

     

    public Sendmessage() {
    }



    public Sendmessage(String msg,String type) {
        this.msg = msg;
        this.type=type;
    }

     
}
