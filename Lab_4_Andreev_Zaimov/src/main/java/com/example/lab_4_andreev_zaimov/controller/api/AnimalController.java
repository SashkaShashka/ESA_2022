package com.example.lab_4_andreev_zaimov.controller.api;

import com.example.lab_4_andreev_zaimov.model.Animal;
import com.example.lab_4_andreev_zaimov.repository.AnimalRepository;
import com.example.lab_4_andreev_zaimov.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/animals", produces = {"application/json", "application/xml"})
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/{id}")
    public Animal findById(@PathVariable Long id){

        return animalService.findById(id);
    }

    @GetMapping("/all")
    public List<Animal> findAll(){
        return animalService.findAll();
    }

    @PostMapping("/update")
    public Animal update(@RequestBody Animal animal){
        return animalService.update(animal);
    }

    @PostMapping("/create")
    public Animal create(@RequestBody Animal animal){
        animalService.create(animal);
        return animal;
    }

    @DeleteMapping("/delete/{id}")
    public Animal delete(@PathVariable Long id){
        return animalService.delete(id);
    }
}
