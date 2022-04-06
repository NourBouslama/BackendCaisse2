package com.backend.caisse.service;

import java.util.List;

import com.backend.caisse.entities.Caissier;

public interface CaissierService {

    Caissier ajouterCaissier(Caissier p);

    Caissier modifierCaissier(Caissier p);

    void desactiverCaissierByMat(Long mat);

    void activerCaissierByMat(Long mat);

    Caissier consulterCaissier(Long mat);

    List<Caissier> listerCaissiers();
    
}
