package com.example.lab2_zaimov_andreev.controller;

import com.example.lab2_zaimov_andreev.model.Animal;
import com.example.lab2_zaimov_andreev.model.Owner;
import com.example.lab2_zaimov_andreev.repository.AnimalRepository;
import com.example.lab2_zaimov_andreev.repository.OwnerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/animal")
public class AnimalController {

    final AnimalRepository animalRepository;
    final OwnerRepository ownerRepository;

    public AnimalController(AnimalRepository animalRepository, OwnerRepository ownerRepository) {
        this.animalRepository = animalRepository;
        this.ownerRepository = ownerRepository;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("animals", animalRepository.findAll());
        return "animals";
    }

    @GetMapping("/add")
    public String addAnimal(Model model){
        model.addAttribute("animal", new Animal());
        model.addAttribute("owners", ownerRepository.findAll());
        return "addAnimal";
    }
    @PostMapping("/add")
    public String insertAnimal(@ModelAttribute("animal") Animal animal, BindingResult bindingResult){
        animalRepository.save(animal);
        return "redirect:/animal";
    }
    @GetMapping("/edit")
    public String editAnimal(@RequestParam Long chipId, Model model){
        Optional<Animal> animalOptional= animalRepository.findById(chipId);
        Animal animal = animalOptional.get();
        model.addAttribute("animal",animal);
        model.addAttribute("owners", ownerRepository.findAll());
        return "editAnimal";
    }
    @PostMapping("/edit")
    public String updateAnimal(@ModelAttribute("animal") Animal animal, BindingResult bindingResult){
        if (!bindingResult.hasErrors())
            animalRepository.save(animal);
        return "redirect:/animal";
    }

    @GetMapping("/remove")
    public String deleteAnimal(@RequestParam Long chipId){
        animalRepository.deleteById(chipId);
        return "redirect:/animal";
    }
}
