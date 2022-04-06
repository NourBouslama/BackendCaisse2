package com.backend.caisse.repos;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.backend.caisse.entities.Agent;
import com.backend.caisse.entities.Encaissement;
import com.backend.caisse.entities.Paiement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {

    List<Paiement> findByDateP(LocalDate d);


    @Transactional
    @Modifying
    @Query("select paiement.idP from  Facture f  where f.referenceFact=?1 ")
    int selectIDPLong(long ff);

    @Transactional
    @Modifying
    @Query("update Paiement p set p.etat='Annuler' where p.idP=?1")
    void updateEtatAnnulerPaiement(long ff);

    @Transactional
    @Modifying
    @Query("select encaissement.idE from  Paiement p  where p.idP=?1 ")
    int selectIDELong(long idP);

    @Transactional
    @Modifying
    @Query("update Paiement p set p.encaissement=?1 where p.idP=?2")
    void updateEncaissementPaiement(Encaissement enc, long idp);

    
    @Transactional
    @Modifying
    @Query("update Paiement p set p.agent=?1 where p.idP=?2")
    void updatePaiement(Agent agent, long idp);
    
}
