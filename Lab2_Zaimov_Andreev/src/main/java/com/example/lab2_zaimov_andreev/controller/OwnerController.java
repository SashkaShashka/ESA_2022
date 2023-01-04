package com.example.lab2_zaimov_andreev.controller;
import com.example.lab2_zaimov_andreev.model.Owner;
import com.example.lab2_zaimov_andreev.repository.OwnerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/owner")
public class OwnerController {
    final OwnerRepository ownerRepository;

    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("owners", ownerRepository.findAll());
        return "owners";
    }


    @GetMapping("/add")
    public String addOwner(Model model){
        model.addAttribute("owner", new Owner());
        return "addOwner";
    }
    @PostMapping("/add")
    public String insertOwner(@ModelAttribute("owner") Owner owner, BindingResult bindingResult){
        ownerRepository.save(owner);
        return "redirect:/owner";
    }
    @GetMapping("/edit")
    public String editOwner(@RequestParam Long ownerID, Model model){
        Optional<Owner> optionalOwner= ownerRepository.findById(ownerID);
        Owner owner = optionalOwner.get();
        model.addAttribute("owner",owner);
        return "editOwner";
    }
    @PostMapping("/edit")
    public String updateOwner(@ModelAttribute("owner") Owner owner, BindingResult bindingResult){
        if (!bindingResult.hasErrors())
            ownerRepository.save(owner);
        return "redirect:/owner";
    }

    @GetMapping("/remove")
    public String deleteOwner(@RequestParam Long ownerId){
        ownerRepository.deleteById(ownerId);
        return "redirect:/owner";
    }
}
