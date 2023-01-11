package com.example.lab_3_zaimov_andreev.controller.api;
import com.example.lab_3_zaimov_andreev.model.Animal;
import com.example.lab_3_zaimov_andreev.model.Owner;
import com.example.lab_3_zaimov_andreev.repository.AnimalRepository;
import com.example.lab_3_zaimov_andreev.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/owners", produces = {"application/json", "application/xml"})
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping("/{id}")
    public Owner findById(@PathVariable Long id){
        return ownerRepository.findById(id).orElseThrow();
    }

    @GetMapping("/all")
    public List<Owner> findAll(){
        return ownerRepository.findAll();
    }

    @PostMapping("/update")
    public void update(@RequestBody Owner owner){
        ownerRepository.saveAndFlush(owner);
    }

    @PostMapping("/create")
    public Owner create(@RequestBody Owner owner){
        ownerRepository.saveAndFlush(owner);
        return owner;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        Owner owner = ownerRepository.findById(id).orElseThrow();
        ownerRepository.delete(owner);
    }
}
