package com.backend.caisse.service;

import java.util.List;

import com.backend.caisse.entities.Facture;
import com.backend.caisse.entities.Paiement;

public interface PaiementService {

  void AjouterPaiementFactureAgent(List<Facture> factures);

  Paiement saveSaisieAvance(Facture fact);

  void AnnulerPaiementListeFacture(List<Facture> fact);

  void AnnulerPaiementRefContrat(Long refContrat);

  void AnnulerPaiementRefClient(Long reClient);

  void AnnulerPaiementRefFacture(Long refFacture);

  // historique des paiements
  List<Paiement> ListerPaiements();

  Paiement ajouterPaiement(Paiement p);

  List<Facture> AjouterPaiementFacture(List<Facture> factures);

  /*
   * void AjouterPaiementFactureAgent(List<Facture> factures);
   * 
   * //Paiement saveSaisieAvance(Facture fact);
   * Paiement saisirAvance(Paiement p);
   * 
   * void AnnulerPaiementFacture(List<Facture> fact);
   * 
   * void AnnulerPaiementFacture1(List<Long> lref);
   * 
   * void AnnulerPaiementFacture2(Long refContrat);
   * 
   * void AnnulerPaiementFacture3(Long reClient);
   * 
   * void AnnulerPaiementFacture4(Long refFacture);
   * 
   * // historique des paiements
   * List<Paiement> ListerPaiements();
   * 
   * //////////////////////////
   * Paiement ajouterPaiement(Paiement p);
   * 
   * List<Facture> AjouterPaiementFacture(List<Facture> factures);
   */
}
