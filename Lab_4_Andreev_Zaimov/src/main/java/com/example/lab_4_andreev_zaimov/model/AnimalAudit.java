package com.example.lab_4_andreev_zaimov.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "animal_audit")
public class AnimalAudit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "name_old", nullable = true)
    private String nameOld;
    @Basic
    @Column(name = "name_new", nullable = true)
    private String nameNew;
    @Basic
    @Column(name = "sex_old", nullable = true)
    private String sexOld;
    @Basic
    @Column(name = "sex_new", nullable = true)
    private String sexNew;
    @Basic
    @Column(name = "color_old", nullable = true)
    private String colorOld;
    @Basic
    @Column(name = "color_new", nullable = true)
    private String colorNew;
    @Basic
    @Column(name = "breed_old", nullable = true)
    private String breedOld;
    @Basic
    @Column(name = "breed_new", nullable = true)
    private String breedNew;

    public AnimalAudit( Animal animalOld, Animal animalNew) {
        this.nameOld = animalOld.getName();
        this.nameNew = animalNew.getName();
        this.sexOld = animalOld.getSex();
        this.sexNew = animalNew.getSex();
        this.colorOld = animalOld.getColor();
        this.colorNew = animalNew.getColor();
        this.breedOld = animalOld.getBreed();
        this.breedNew = animalNew.getBreed();
    }
}
