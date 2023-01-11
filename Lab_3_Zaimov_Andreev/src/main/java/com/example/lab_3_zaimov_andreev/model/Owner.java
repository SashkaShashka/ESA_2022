package com.example.lab_3_zaimov_andreev.model;


import com.example.lab_3_zaimov_andreev.model.Owner;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

//import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
//import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
@Entity(name = "owner")
@Table(name = "animal_owner_information")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonTypeInfo(include=As.WRAPPER_OBJECT, use=Id.NAME)
public class Owner {

    //@jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_owner_id")
    private long animal_owner_id;
    @Basic
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Basic
    @Column(name = "surname", nullable = false)
    private String surname;
    @Basic
    @Column(name = "patronymic", nullable = false)
    private String patronymic;
    @Basic
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Basic
    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "owner")
    private List<Animal> animals;

    public Owner(String firstName, String surname, String patronymic, String phoneNumber, String address) {
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public List<Animal> getAnimals() {
        return animals;
    }
    public void addAnimal(Animal animal){
        animals.add(animal);
        animal.setOwner(this);

    }
    public void removeAnimal(Animal animal){
        animals.remove(animal);
        animal.setOwner(null);
    }
    public String getStringFullName(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(firstName);
        stringBuilder.append(" ");
        stringBuilder.append(surname);
        stringBuilder.append(" ");
        stringBuilder.append(patronymic);
        return stringBuilder.toString();
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ФИО: ");
        stringBuilder.append(firstName);
        stringBuilder.append(" ");
        stringBuilder.append(surname);
        stringBuilder.append(" ");
        stringBuilder.append(patronymic);
        stringBuilder.append(" | Телефон: ");
        stringBuilder.append(phoneNumber);
        stringBuilder.append(" | Адрес: ");
        stringBuilder.append(address);
        return stringBuilder.toString();
    }
}
