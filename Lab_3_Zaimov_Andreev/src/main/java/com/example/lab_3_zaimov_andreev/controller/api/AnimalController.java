package com.example.lab_3_zaimov_andreev.controller.api;

import com.example.lab_3_zaimov_andreev.model.Animal;
import com.example.lab_3_zaimov_andreev.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/animals", produces = {"application/json", "application/xml"})
public class AnimalController {

    @Autowired
    AnimalRepository animalRepository;

    @GetMapping("/{id}")
    public Animal findById(@PathVariable Long id){
        return animalRepository.findById(id).orElseThrow();
    }

    @GetMapping("/all")
    public List<Animal> findAll(){
        return animalRepository.findAll();
    }

    @PostMapping("/update")
    public void update(@RequestBody Animal animal){
        animalRepository.saveAndFlush(animal);
    }

    @PostMapping("/create")
    public Animal create(@RequestBody Animal animal){
        animalRepository.saveAndFlush(animal);
        return animal;
    }

    @DeleteMapping("/delete/{id}")
    public Animal delete(@PathVariable Long id){
        Animal animal = animalRepository.findById(id).orElseThrow();
        animalRepository.delete(animal);
        return animal;
    }
}
