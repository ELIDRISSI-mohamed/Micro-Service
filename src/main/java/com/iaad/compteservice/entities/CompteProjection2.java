package com.iaad.compteservice.entities;

import com.iaad.compteservice.enums.TypeCompte;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="p2", types = {Compte.class})
public interface CompteProjection2 {
    public  double getSolde();
    public TypeCompte getType();
}
