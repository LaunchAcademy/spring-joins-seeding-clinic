package com.launchacademy.pettracker.controllers;

import com.launchacademy.pettracker.models.Pet;
import com.launchacademy.pettracker.repositories.PetsRepository;
import com.launchacademy.pettracker.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetsRestController {
  private PetsRepository petsRepository;
  private PetService petService;

  @Autowired
  public PetsRestController(PetsRepository petsRepository, PetService petService){
    this.petsRepository = petsRepository;
    this.petService = petService;
  }

  @GetMapping("/api/v1/pets")
  public Page<Pet> getList(Pageable pageable) {
    return petService.findAll(pageable);
  }

  @PostMapping("/api/v1/pets")
  public Pet create(@RequestBody Pet pet) {
    return petsRepository.save(pet);
  }

}
