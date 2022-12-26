package com.example.lab_1_zaimov_andreev.entity;


import jakarta.persistence.*;


@Entity(name = "account")
@Table(name = "accounting_for_pets")
@NamedQuery(name = "AccountingForPets.getAll", query = "SELECT a from account a")
public class AccountingForPets {

    @Id
    @Column(name = "kind_of_animal", nullable = false)
    private String kindOfAnimal;

    @Column(name = "chip_id")
    private long chipId;



    public AccountingForPets(){

    }

    public AccountingForPets(String kindOfAnimal) {
        this.kindOfAnimal = kindOfAnimal;
    }

    public String getKindOfAnimal() {
        return kindOfAnimal;
    }

    public void setKindOfAnimal(String kindOfAnimal) {
        this.kindOfAnimal = kindOfAnimal;
    }
}
