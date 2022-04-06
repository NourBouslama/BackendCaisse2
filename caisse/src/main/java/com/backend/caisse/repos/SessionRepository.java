package com.backend.caisse.repos;

import java.util.List;

import com.backend.caisse.entities.Caisse;
import com.backend.caisse.entities.Caissier;
import com.backend.caisse.entities.SessionCaisse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface SessionRepository extends JpaRepository<SessionCaisse, Long> {

	@Query("select p from SessionCaisse p where p.caisse = ?1")
	List<SessionCaisse> findByCaisse(Caisse caisse);

	List<SessionCaisse> findByCaisseNumC(Long numc);

	@Query("select p from SessionCaisse p where p.caissier = ?1")
	List<SessionCaisse> findByCaissier(Caissier caissier);

	List<SessionCaisse> findByCaissierMatricule(Long matricule);

	@Transactional
	@Modifying
	@Query("update SessionCaisse p set p.etat='fermer' where p.NumS = ?1")
	void updateEtatFermer(long nums);

	@Transactional
	@Modifying
	@Query("update SessionCaisse p set p.etat='en cours' where p.NumS = ?1")
	void updateEtatOuvrir(long nums);

	@Transactional
	@Modifying
	@Query("update SessionCaisse p set p.etatJournal ='fermer' where p.NumS = ?1")
	void updateEtatJournal(long numc);

}
