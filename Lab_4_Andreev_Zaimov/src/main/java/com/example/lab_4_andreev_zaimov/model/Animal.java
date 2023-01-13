package com.example.lab_4_andreev_zaimov.model;

import com.example.lab_4_andreev_zaimov.model.Owner;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.xml.bind.v2.TODO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.hql.internal.ast.tree.AbstractNullnessCheckNode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

@Entity(name = "animal")
@Table(name = "animal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal implements Serializable, Mappable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chip_id")
    private Long chipId;
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
    @JoinColumn(name = "animal_owner_id", nullable = true)
    private Owner owner;

    public Animal(Long Id, String name, String sex, String color, String breed) {

        this.chipId = Id;
        this.name = name;
        this.sex = sex;
        this.color = color;
        this.breed = breed;
    }
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
    @Override
    public int hashCode() {
        int result = chipId != null ? chipId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (breed != null ? breed.hashCode() : 0);
        return result;
    }
    @Override
    public Map<String, String> toMap() {
        return Map.of("chipId", String.valueOf(chipId),
                "name", String.valueOf(name),
                "sex", String.valueOf(sex),
                "color", String.valueOf(color),
                "breed", String.valueOf(breed));
    }


    public static Animal fromMap(Map<String, String> map){
        if(map == null)
            return new Animal();
        else {
            Long Id = Long.valueOf(map.get("chipId"));
            String name = map.get("name");
            String sex = map.get("sex");
            String color = map.get("color");
            String breed = map.get("breed");
            return new Animal(Id, name, sex, color, breed);
        }
    }
}
