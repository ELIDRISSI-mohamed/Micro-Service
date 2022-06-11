package com.iaad.compteservice;

import com.iaad.compteservice.entities.Compte;
import com.iaad.compteservice.enums.TypeCompte;
import com.iaad.compteservice.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class MicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository, RepositoryRestConfiguration restConfiguration){
		return args -> {
			restConfiguration.exposeIdsFor(Compte.class);
			compteRepository.save(new Compte(null,8000,new Date(), TypeCompte.COURANT));
			compteRepository.save(new Compte(null,200,new Date(), TypeCompte.EPARGNE));
			compteRepository.save(new Compte(null,4900,new Date(), TypeCompte.COURANT));
			compteRepository.save(new Compte(null,9900,new Date(), TypeCompte.COURANT));
			compteRepository.findAll().forEach(cp->{
				System.out.println(cp.getType());
				System.out.println(cp.getSolde());
			});

		};
	}
}
