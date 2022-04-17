package com.backend.caisse.service;

import java.util.List;

import com.backend.caisse.entities.Encaissement;
import com.backend.caisse.entities.SessionCaisse;

public interface EncaissementService {

    List<Encaissement> listerEncaissements();

  //  List<Encaissement> listerEncaissementsByEtat(Long nums);

    List<Encaissement> listerEncaissementsBySession(Long nums);
    
}
