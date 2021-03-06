package com.backend.caisse.repos;

import com.backend.caisse.entities.Agent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AgentRepository extends JpaRepository<Agent, Long> {
    @Transactional
    @Modifying
    @Query("update Agent u set u.etat='activer' where u.matricule=?1")
    void updateEtatActiv(long id);

    @Transactional
    @Modifying
    @Query("update Agent u set u.etat='desactiver' where u.matricule=?1")
    void updateEtatDesact(long id); 
}
