package com.backend.caisse.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;


@Data
@Entity
public class AffectMode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idM;
    @ManyToOne
    private Caisse caisse;
    @ManyToOne
    private ModePaiement modeP;

       
}
