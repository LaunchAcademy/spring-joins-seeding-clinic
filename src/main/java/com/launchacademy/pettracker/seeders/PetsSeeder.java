package com.launchacademy.pettracker.seeders;


import com.launchacademy.pettracker.models.Pet;
import com.launchacademy.pettracker.repositories.PetsRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PetsSeeder {
  private PetsRepository petsRepository;

  @Autowired
  public void setPetsRepository(PetsRepository petsRepository) {
    this.petsRepository = petsRepository;
  }


  public void seed() {

    List<Pet> pets = new ArrayList();

    if (petsRepository.count() == 0) {
      Pet petOne = new Pet();
      petOne.setName("BillyBoy");
      petOne.setBreed("Demon");
      petOne.setAge(4);
      petOne.setFixed(true);
      petOne.setSpecies("cat");

      Pet petTwo = new Pet();
      petTwo.setName("Tommy");
      petTwo.setBreed("Angel");
      petTwo.setAge(8);
      petTwo.setFixed(false);
      petTwo.setSpecies("dog");

      petsRepository.save(petOne);
      petsRepository.save(petTwo);
    }
  }
}
