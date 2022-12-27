package com.example.lab_1_zaimov_andreev.bean;

import com.example.lab_1_zaimov_andreev.entity.SummaryOfTheAnimal;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.util.List;

@Stateless
public class SummaryOfTheAnimalBean {
    @PersistenceContext()
    private EntityManager summary;
    //Добавляем информацию о владельце
    public SummaryOfTheAnimal add(SummaryOfTheAnimal summaryOfTheAnimal){
        return summary.merge(summaryOfTheAnimal);
    }
    //Получаем информацию о владельце по Id
    public SummaryOfTheAnimal get(long chipId){
        return summary.find(SummaryOfTheAnimal.class, chipId);
    }
    //Обновляем информацию о владельце
    public void update (SummaryOfTheAnimal summaryOfTheAnimal){
        add(summaryOfTheAnimal);
    }
    //Удаляем информацию о владельце
    public void delete (long chipId){
        summary.remove(get(chipId));
    }
    public List<SummaryOfTheAnimal> getAll(){
        TypedQuery<SummaryOfTheAnimal> animalQuery = summary.createNamedQuery("SummaryOfTheAnimal.getAll" ,SummaryOfTheAnimal.class);
        return animalQuery.getResultList();
    }

    public List<Long> getIds() {
        TypedQuery<Long> animalQuery = summary.createNamedQuery("SummaryOfTheAnimal.getIds", Long.class);
        return animalQuery.getResultList();
    }
}
