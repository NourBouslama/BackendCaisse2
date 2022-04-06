package com.backend.caisse.service;

import java.util.List;

import com.backend.caisse.entities.Facture;

public interface FactureService {
    
    List<Facture> ChercherRéférenceContrat(Long rfc);

    List<Facture> ChercherRéférenceClient(Long rf);
  
    Facture ChercherRéférenceFact(Long ff);
  
    // List<Facture> findByUtilisateurCIN(Long id);
  
    // Facture updateFacture(Long ff);
  
    void updateFacturePayer(long ref);
  
    Facture saveFacture(Facture facture);
}
