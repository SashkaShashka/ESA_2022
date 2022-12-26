package com.example.lab_1_zaimov_andreev.bean;

import jakarta.ejb.Stateless;

@Stateless
public class HelloBean {

    public String HelloWorld(){
        return "Hell!";
    }
}
