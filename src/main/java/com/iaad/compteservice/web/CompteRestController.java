package com.iaad.compteservice.web;

import com.iaad.compteservice.entities.Compte;
import com.iaad.compteservice.enums.TypeCompte;
import com.iaad.compteservice.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RestController
public class CompteRestController {
    @Autowired
    private CompteRepository compteRepository;

    @GetMapping("/comptes")
    public List<Compte> listComptes(){
        return compteRepository.findAll();
    }
    @GetMapping("/comptes/{id}")
    public Optional<Compte> getCompte(@PathVariable(name = "id") Long id){
        Optional<Compte> compte = compteRepository.findById(id);
        return compte;
    }
    @PostMapping("/comptes")
    public Compte save(@RequestBody Compte compte){
        return compteRepository.save(compte);
    }
    @PutMapping("/comptes/{code}")
    public Compte update(@PathVariable Long code, @RequestBody Compte compte){
        compte.setCode(code);
        return compteRepository.save(compte);
    }
    @DeleteMapping("/comptes/{code}")
    public void delete(@PathVariable Long code){
        compteRepository.deleteById(code);
    }
    @GetMapping("/getCompte/{solde}")
    public List<Compte> getByType(@PathVariable double solde){
        List<Compte> comptes = (List) compteRepository.findBySolde(solde);
        return comptes;
    }
    @GetMapping("/getCompteByType/{type}")
    public List<Compte> getByType(@PathVariable TypeCompte type){
        List<Compte> comptes = (List) compteRepository.findByType(type);
        return comptes;
    }
    @GetMapping("/getCompteByType")
    public List<Compte> getByTypeBody(@RequestBody Compte compte){
        System.out.println(compte);
        List<Compte> comptes = (List) compteRepository.findByType(compte.getType());
        return comptes;
    }
}
