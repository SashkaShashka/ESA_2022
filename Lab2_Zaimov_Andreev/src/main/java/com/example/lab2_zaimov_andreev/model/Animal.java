package com.example.lab2_zaimov_andreev.model;

import com.example.lab2_zaimov_andreev.model.Owner;
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

    public Long getIdOwner() {
        return id_owner;
    }

    public void setIdOwner(Long id_owner) {
        this.id_owner = id_owner;
    }

    @Basic
    @Column(name = "color", nullable = false)
    private String color;

    @Basic
    @Column(name = "breed", nullable = false)
    private String breed;

    @Basic
    @Column(name = "id_owner", nullable = true)
    private Long id_owner;

    @ManyToOne
    @JoinColumn(name = "id_owner", insertable = false, updatable = false, nullable = true)
    private Owner owner = null;

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
            this.id_owner = owner.getOwnerId();
        }
        else{
            this.id_owner = null;
            this.owner= null;
        }

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
        stringBuilder.append(" | Хозяин: ");
        stringBuilder.append(owner != null ? owner.getFullName() : "отсутствует");
        return stringBuilder.toString();
    }
}
