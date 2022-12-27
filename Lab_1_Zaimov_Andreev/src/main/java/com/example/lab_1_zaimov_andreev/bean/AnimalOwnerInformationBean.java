package com.example.lab_1_zaimov_andreev.bean;

import com.example.lab_1_zaimov_andreev.entity.AnimalOwnerInformation;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;
//import javax.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class AnimalOwnerInformationBean {

    @PersistenceContext()
    private EntityManager animalOwnerInfo;
    //Добавляем информацию о владельце
    public AnimalOwnerInformation add(AnimalOwnerInformation animalOwnerInformation){
        return animalOwnerInfo.merge(animalOwnerInformation);
    }
    //Получаем информацию о владельце по Id
    public AnimalOwnerInformation get(long animalOwnerId){
        return animalOwnerInfo.find(AnimalOwnerInformation.class, animalOwnerId);
    }
    //Обновляем информацию о владельце
    public void update (AnimalOwnerInformation animalOwnerInformation){
        add(animalOwnerInformation);
    }
    //Удаляем информацию о владельце
    public void delete (long animalOwnerId){
        animalOwnerInfo.remove(get(animalOwnerId));
    }
    public List<AnimalOwnerInformation> getAll(){
        TypedQuery<AnimalOwnerInformation> ownerQuery = animalOwnerInfo.createNamedQuery("AnimalOwnerInformation.getAll", AnimalOwnerInformation.class);
        return ownerQuery.getResultList();
    }
    public String getOwner(Long animalOwnerId){
        if (animalOwnerId == null)
            return "Владелец отсуствует";
        AnimalOwnerInformation owner = get(animalOwnerId);
        return owner.getFirstName() + " " + owner.getSurname() + " " + owner.getPatronymic();
    }

}
