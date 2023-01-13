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
@Table(name = "owner_audit")
public class OwnerAudit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "first_name_old", nullable = true)
    private String firstNameOld;
    @Basic
    @Column(name = "first_name_new", nullable = true)
    private String firstNameNew;
    @Basic
    @Column(name = "surname_old", nullable = true)
    private String surnameOld;
    @Basic
    @Column(name = "surname_new", nullable = true)
    private String surnameNew;
    @Basic
    @Column(name = "patronymic_old", nullable = true)
    private String patronymicOld;
    @Basic
    @Column(name = "patronymic_new", nullable = true)
    private String patronymicNew;
    @Basic
    @Column(name = "phone_number_old", nullable = true)
    private String phoneNumberOld;
    @Basic
    @Column(name = "phone_number_new", nullable = true)
    private String phoneNumberNew;
    @Basic
    @Column(name = "address_old", nullable = true)
    private String addressOld;

    @Basic
    @Column(name = "address_new", nullable = true)
    private String addressNew;

    public OwnerAudit(Owner ownerOld, Owner ownerNew) {
        this.firstNameOld = ownerOld.getFirstName();
        this.firstNameNew = ownerNew.getFirstName();
        this.surnameOld = ownerOld.getSurname();
        this.surnameNew = ownerNew.getSurname();
        this.patronymicOld = ownerOld.getPatronymic();
        this.patronymicNew = ownerNew.getPatronymic();
        this.phoneNumberOld = ownerOld.getPhoneNumber();
        this.phoneNumberNew = ownerNew.getPhoneNumber();
        this.addressOld = ownerOld.getAddress();
        this.addressNew = ownerNew.getAddress();
    }

}
