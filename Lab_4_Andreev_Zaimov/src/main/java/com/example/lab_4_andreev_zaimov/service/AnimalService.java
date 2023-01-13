package com.example.lab_4_andreev_zaimov.service;

import com.example.lab_4_andreev_zaimov.model.Animal;
import com.example.lab_4_andreev_zaimov.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private AuditService auditService;

    public Animal findById(Long id){
        return animalRepository.findById(id).orElseThrow();
    }

    public Animal create(Animal animal) {
        animalRepository.saveAndFlush(animal);
        auditService.log(animal, "animal", AuditService.EVENT_CREATE);
        return animal;
    }

    public Animal update(Animal newAnimal) {
        Animal oldAnimal = animalRepository.findById(newAnimal.getChipId()).orElseThrow();

        auditService.log(oldAnimal, newAnimal, "animal", AuditService.EVENT_UPDATE);

        return animalRepository.saveAndFlush(newAnimal);
    }

    public Animal delete(Long id) {
        Animal animal = animalRepository.findById(id).orElseThrow();
        animalRepository.delete(animal);

        auditService.log(animal, "animal", AuditService.EVENT_DELETE);

        return animal;
    }

    public List<Animal> findAll(){
        return animalRepository.findAll();
    }
}
