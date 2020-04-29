package com.launchacademy.pettracker;

import com.launchacademy.pettracker.seeders.PetsSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetTrackerApplication {
	private static PetsSeeder petSeeder;

	@Autowired
	public void setPetsSeeder(PetsSeeder petsSeeder) {
		this.petSeeder = petsSeeder;
	}

	public static void main(String[] args) {
		SpringApplication.run(PetTrackerApplication.class, args);
	}

}
