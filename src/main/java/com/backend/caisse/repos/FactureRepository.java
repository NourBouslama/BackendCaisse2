package com.backend.caisse.repos;

import java.util.List;

import com.backend.caisse.entities.Client;
import com.backend.caisse.entities.Contrat;
import com.backend.caisse.entities.Facture;
import com.backend.caisse.entities.Paiement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface FactureRepository extends JpaRepository<Facture, Long> {

    List<Facture> findByClient(Client client);

    List<Facture> findByContrat(Contrat contrat);

    Facture findByReferenceFact(Long ff);

    Paiement findByPaiement(Long ff);

    // List<Facture> findByUtilisateurCIN(Long id);

    @Transactional
    @Modifying
    @Query("update Facture f set  f.paiement=?1  where f.referenceFact=?2")
    void updateFacture(Paiement paie, long ff);

    @Transactional
    @Modifying
    @Query("update Facture f set f.etat='Payer' where f.referenceFact=?1")
    void updateEtatPayer(long ff);

    @Transactional
    @Modifying
    @Query("update Facture f set f.etat='impayé' where f.referenceFact=?1")
    void updateEtatAnnulerFacture(long ff);
    @Transactional
    @Modifying
    @Query("update Facture f set f.paiement=null where f.referenceFact=?1")
    void updateFacturePaiement(long ff);

    
}
