package com.iaad.compteservice.entities;

import com.iaad.compteservice.enums.TypeCompte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Compte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long code;
    double solde;
    Date dateCreation;
    @Enumerated(EnumType.STRING)
    TypeCompte type;
}
