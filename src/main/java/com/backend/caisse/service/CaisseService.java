package com.backend.caisse.service;

import java.util.List;

import com.backend.caisse.entities.Caisse;
import com.backend.caisse.entities.ModePaiement;

public interface CaisseService {

    Caisse ajouterCaisse(Caisse p);

    Caisse modifierCaisse(Caisse p);

    void desactiverCaisseById(Long id);

    void activerCaisseById(Long id);

    Caisse consulterCaisse(Long id);

    List<Caisse> listerCaisses();



    List<Caisse> listerCaissesByEtat(String etat);

    

    /********************************/

    /*List<Caisse> ChercherCaissesByMode(ModePaiement mode);

    List<Caisse> chercherCaissesbyModeCode(Long code);*/

    // void deleteCaisse(Caisse p);
}
