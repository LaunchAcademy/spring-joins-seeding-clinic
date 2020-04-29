package com.launchacademy.pettracker.controllers;

import com.launchacademy.pettracker.models.Pet;
import com.launchacademy.pettracker.repositories.PetsRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PetsController {
  private PetsRepository petsRepository;

  @Autowired
  public PetsController(PetsRepository petsRepository){
    this.petsRepository = petsRepository;
  }


  @GetMapping("/pets/index")
  public String listPets(Model model){
    List<Pet> pets = petsRepository.findAll();
    model.addAttribute("pets", pets);
    return "pets/index";
  }

  @GetMapping("/pets/index/{page}")
  public String listMorePets(@PathVariable int page, Model model){
    Pageable pageable = PageRequest.of(page, 10);
    Page<Pet> pets = petsRepository.findAll(pageable);
    model.addAttribute("pets", pets);
    return "pets/index";
  }

  @GetMapping("/pets/new")
  public String newPet(@Autowired Pet pet, Model model){
    model.addAttribute("pet", pet);
    return "pets/new";
  }

  @PostMapping("/addPet")
  public String addPet(@ModelAttribute @Valid Pet pet, BindingResult binding, Model model) {
    if(binding.hasErrors()){
      return "pets/new";
    }
    else {
      petsRepository.save(pet);
      model.addAttribute(pet);
      return "redirect:/pets/index";
    }
  }
}
