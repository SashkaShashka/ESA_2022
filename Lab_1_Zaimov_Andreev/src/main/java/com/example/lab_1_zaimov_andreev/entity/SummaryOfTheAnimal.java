package com.example.lab_1_zaimov_andreev.entity;


import jakarta.persistence.*;

@Entity(name = "animal")
@Table(name = "summary_of_the_animal")
@NamedQuery(name = "SummaryOfTheAnimal.getAll", query = "SELECT s from animal s")

public class SummaryOfTheAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chip_id")
    private long chipId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "breed", nullable = false)
    private String breed;

    public SummaryOfTheAnimal(){

    }

    public SummaryOfTheAnimal(long chipId) {
        this.chipId = chipId;
    }

    public long getChipId() {
        return chipId;
    }

    public void setChipId(long chipId) {
        this.chipId = chipId;
    }

    public SummaryOfTheAnimal(String name, String sex, String color, String breed) {

        this.name = name;
        this.sex = sex;
        this.color = color;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
