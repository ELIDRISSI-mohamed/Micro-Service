package com.iaad.compteservice;

import com.iaad.compteservice.entities.Compte;
import com.iaad.compteservice.enums.TypeCompte;
import com.iaad.compteservice.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class MicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository){
		return args -> {
			compteRepository.save(new Compte(null, 10000, new Date(), TypeCompte.COURANT));
			compteRepository.save(new Compte(null, 11100, new Date(), TypeCompte.EPARGNE));
			compteRepository.save(new Compte(null, 2200, new Date(), TypeCompte.COURANT));


		};
	}
}
