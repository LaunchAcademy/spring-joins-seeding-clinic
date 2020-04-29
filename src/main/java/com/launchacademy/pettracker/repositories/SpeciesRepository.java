package com.launchacademy.pettracker.repositories;

import com.launchacademy.pettracker.models.Species;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesRepository extends PagingAndSortingRepository<Species, Integer> {

  public List<Species> findAll();
}

