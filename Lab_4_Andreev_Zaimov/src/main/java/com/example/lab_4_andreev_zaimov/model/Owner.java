package com.example.lab_4_andreev_zaimov.model;


import com.example.lab_4_andreev_zaimov.model.Owner;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

//import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
//import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
@Entity(name = "owner")
@Table(name = "owner")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonTypeInfo(include=As.WRAPPER_OBJECT, use=Id.NAME)
public class Owner implements Serializable, Mappable{

    //@jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_owner_id")
    private Long animal_owner_id;
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

    @Override
    public int hashCode() {
        int result = animal_owner_id != null ? animal_owner_id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public Map<String, String> toMap(){
        return Map.of("animal_owner_id", String.valueOf(animal_owner_id),
                "firstName", String.valueOf(firstName),
                "surname", String.valueOf(surname),
                "patronymic", String.valueOf(patronymic),
                "phoneNumber",String.valueOf(phoneNumber),
                "address",String.valueOf(address));
    }

    public Owner(Long animal_owner_id, String firstName, String surname, String patronymic, String phoneNumber, String address) {
        this.animal_owner_id = animal_owner_id;
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public static Owner fromMap(Map<String, String> map){
        if(map == null)
            return new Owner();
        else {
            Long Id = Long.valueOf(map.get("animal_owner_id"));
            String firstName = map.get("firstName");
            String surname = map.get("surname");
            String patronymic = map.get("patronymic");
            String phoneNumber = map.get("phoneNumber");
            String address = map.get("address");
            return new Owner(Id, firstName, surname, patronymic,phoneNumber, address);
        }
    }
}
