package com.backend.caisse.repos;

import com.backend.caisse.entities.Encaissement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface EncaissementRepository extends JpaRepository<Encaissement, Long>  {
    @Transactional
    @Modifying
    @Query("update Encaissement e set e.etat='Annuler' where e.idE=?1")
    void updateEtatAnnulerEncaissement(long idp);
    
}
