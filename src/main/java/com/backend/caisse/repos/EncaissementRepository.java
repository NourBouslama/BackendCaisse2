package com.backend.caisse.repos;

import java.util.List;

import com.backend.caisse.entities.Encaissement;
import com.backend.caisse.entities.SessionCaisse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface EncaissementRepository extends JpaRepository<Encaissement, Long>  {
    @Transactional
    @Modifying
    @Query("update Encaissement e set e.etat='Annuler' where e.idE=?1")
    void updateEtatAnnulerEncaissement(long idp);

  //  @Query("select * from Encaissement where etat='?1' and session.numS=?2")
   
    //@Query("select * from Encaissement e where e.etat='payer'")
    List<Encaissement>findByEtat(String etat);
   
    List<Encaissement>findBySession(Long num); 

    List<Encaissement>findBySessionNumS(Long num);
}
