package com.example.lab_4_andreev_zaimov.controller.api;
import com.example.lab_4_andreev_zaimov.model.Animal;
import com.example.lab_4_andreev_zaimov.model.Owner;
import com.example.lab_4_andreev_zaimov.repository.AnimalRepository;
import com.example.lab_4_andreev_zaimov.repository.OwnerRepository;
import com.example.lab_4_andreev_zaimov.service.OwnerService;
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
    private OwnerService ownerService;

    @GetMapping("/{id}")
    public Owner findById(@PathVariable Long id){
        return ownerService.findById(id);
    }

    @GetMapping("/all")
    public List<Owner> findAll(){
        return ownerService.findAll();
    }

    @PostMapping("/update")
    public Owner update(@RequestBody Owner owner){
        return ownerService.update(owner);
    }

    @PostMapping("/create")
    public Owner create(@RequestBody Owner owner){
        ownerService.create(owner);
        return owner;
    }

    @DeleteMapping("/delete/{id}")
    public Owner delete(@PathVariable Long id){
        return ownerService.delete(id);
    }
}
