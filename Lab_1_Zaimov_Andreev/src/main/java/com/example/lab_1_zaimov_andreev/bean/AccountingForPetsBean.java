package com.example.lab_1_zaimov_andreev.bean;


import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class AccountingForPetsBean {

    @PersistenceContext()
    private EntityManager em;


}
