package com.launchacademy.pettracker.seeders;

import com.launchacademy.pettracker.models.Pet;
import com.launchacademy.pettracker.models.Species;
import com.launchacademy.pettracker.repositories.SpeciesRepository;
import com.launchacademy.pettracker.repositories.PetsRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpeciesSeeder {
  private SpeciesRepository speciesRepo;
  private PetsRepository petsRepository;

  @Autowired
  public void setPetTypeRepo(SpeciesRepository speciesRepo) {
    this.speciesRepo = speciesRepo;
  }

  @Autowired
  public void setPetsRepository(PetsRepository petsRepository) {
    this.petsRepository = petsRepository;
  }

  public void seed() {
    List<Species> speciesList = new ArrayList();
    List<Pet> petsList = new ArrayList();

    Species speciesOne = new Species();
    speciesOne.setType("dog");
    speciesOne.setDescription("Human's Best Friend");
    speciesList.add(speciesOne);

    Species speciesTwo = new Species();
    speciesTwo.setType("cat");
    speciesTwo.setDescription("Humanity's Arch Enemy");
    speciesList.add(speciesTwo);

    if (speciesRepo.count() == 0) {
      for (Species type : speciesList) {
        speciesRepo.save(type);
      }
    }
  }
}
