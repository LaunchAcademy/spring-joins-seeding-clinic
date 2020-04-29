package com.launchacademy.pettracker.services;

import com.launchacademy.pettracker.models.Pet;
import com.launchacademy.pettracker.repositories.PetsRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service
public class PetService {
  @Autowired
  private PetsRepository petsRepo;

  public Page findAll(Pageable pageable){
    Page<Pet> petsFromDb = petsRepo.findAll(pageable);
    return petsFromDb;
  }
}
