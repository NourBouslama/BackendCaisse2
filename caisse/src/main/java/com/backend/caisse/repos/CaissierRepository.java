package com.backend.caisse.repos;

import com.backend.caisse.entities.Caissier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CaissierRepository extends JpaRepository<Caissier, Long> {
	@Transactional
	@Modifying
	@Query("update Caissier p set p.etat = 'activer' where p.matricule = ?1")
	void updateEtatAct(long mat);

	@Transactional
	@Modifying
	@Query("update Caissier p set p.etat ='desactiver' where p.matricule = ?1")
	void updateEtatDesact(long mat);

}
