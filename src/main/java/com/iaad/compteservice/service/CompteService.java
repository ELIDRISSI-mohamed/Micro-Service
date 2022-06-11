package com.iaad.compteservice.service;



public interface CompteService {
    public void virement(Long codeSource , Long codeDestination, double montant);
}