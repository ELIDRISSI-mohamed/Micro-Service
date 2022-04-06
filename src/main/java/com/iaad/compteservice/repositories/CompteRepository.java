package com.iaad.compteservice.repositories;

import com.iaad.compteservice.entities.Compte;
import com.iaad.compteservice.enums.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {
    List<Compte> findByType(TypeCompte type);
    List<Compte> findBySolde(double solde);
}
