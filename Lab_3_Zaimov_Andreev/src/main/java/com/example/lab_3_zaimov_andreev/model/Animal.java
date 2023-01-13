package com.example.lab_3_zaimov_andreev.model;

import com.example.lab_3_zaimov_andreev.model.Owner;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity(name = "animal")
@Table(name = "summary_of_the_animal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chip_id")
    private long chipId;
    @Basic()
    @Column(name = "name", nullable = false)
    private String name;
    @Basic()
    @Column(name = "sex", nullable = false)
    private String sex;

    @Basic
    @Column(name = "color", nullable = false)
    private String color;

    @Basic
    @Column(name = "breed", nullable = false)
    private String breed;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "animal_owner_id")
    private Owner owner;

    public Animal(String name, String sex, String color, String breed, Owner owner) {

        this.name = name;
        this.sex = sex;
        this.color = color;
        this.breed = breed;
        if (owner != null)
            owner.addAnimal(this);
    }
    public void setOwner(Owner owner) {
        if (owner != null){
            this.owner = owner;
        }
        else{
            this.owner= null;
        }

    }
    public String getFullNameOwner(){
        return ("Хозяин: " + (owner != null ? owner.getStringFullName() : " отсутствует"));
    }
    public String getStringAnimal() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Кличка: ");
        stringBuilder.append(name);
        stringBuilder.append(" | Пол: ");
        stringBuilder.append(sex);
        stringBuilder.append(" | Окрас: ");
        stringBuilder.append(color);
        stringBuilder.append(" | Порода: ");
        stringBuilder.append(breed);
        return stringBuilder.toString();
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Кличка: ");
        stringBuilder.append(name);
        stringBuilder.append(" | Пол: ");
        stringBuilder.append(sex);
        stringBuilder.append(" | Окрас: ");
        stringBuilder.append(color);
        stringBuilder.append(" | Порода: ");
        stringBuilder.append(breed);
        stringBuilder.append(" | ");
        stringBuilder.append(getFullNameOwner());
        return stringBuilder.toString();
    }
}
