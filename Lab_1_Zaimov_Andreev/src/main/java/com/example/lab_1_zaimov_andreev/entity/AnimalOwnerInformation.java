package com.example.lab_1_zaimov_andreev.entity;

import jakarta.persistence.*;

@Entity(name = "owner")
@Table(name = "animal_owner_information")
@NamedQuery(name = "AnimalOwnerInformation.getAll", query = "SELECT a from owner a")
public class AnimalOwnerInformation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_owner_id")
    private long animalOwnerId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "patronymic", nullable = false)
    private String patronymic;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    public AnimalOwnerInformation(){

    }

    public AnimalOwnerInformation(String firstName, String surname, String patronymic, String phoneNumber, String address) {
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
