package com.launchacademy.pettracker.repositories;

import com.launchacademy.pettracker.models.Pet;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetsRepository extends PagingAndSortingRepository<Pet, Integer> {
  public List<Pet> findAll();

}
