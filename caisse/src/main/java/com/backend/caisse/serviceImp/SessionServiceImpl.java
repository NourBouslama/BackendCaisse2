package com.backend.caisse.serviceImp;

import java.util.List;

import com.backend.caisse.entities.Caisse;
import com.backend.caisse.entities.Caissier;
import com.backend.caisse.entities.SessionCaisse;
import com.backend.caisse.service.CaissierService;
import com.backend.caisse.service.SessionService;
import com.backend.caisse.repos.SessionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    private SessionRepository SessionRepository;

    @Override
    public SessionCaisse CréerSessionCaisse(SessionCaisse s) {

        return SessionRepository.save(s);
    }

    @Override
    public void fermerSessionCaisseById(Long nums) {

        SessionRepository.updateEtatFermer(nums);
    }

    @Override
    public SessionCaisse consulterSessionCaisse(Long id) {

        return SessionRepository.findById(id).get();
    }

    @Override
    public List<SessionCaisse> listerSessionCaisses() {

        return SessionRepository.findAll();
    }



    @Override
    public List<SessionCaisse> chercherByCaisse(Caisse caisse) {

        return SessionRepository.findByCaisse(caisse);
    }

    @Override
    public List<SessionCaisse> chercherByCaisseNumC(Long numc) {

        return SessionRepository.findByCaisseNumC(numc);
    }

    @Override
    public List<SessionCaisse> chercherByCaissier(Caissier caissier) {

        return SessionRepository.findByCaissier(caissier);
    }

    @Override
    public List<SessionCaisse> chercherByCaissierMatricule(Long mat) {

        return SessionRepository.findByCaissierMatricule(mat);
    }

    @Override
    public void OuvrirSessionCaisseById(Long nums) {

        SessionRepository.updateEtatOuvrir(nums);
        
    }

    @Override
    public void fermerJournalCaisse(Long numc) {
     
        SessionRepository.updateEtatJournal(numc);
        
    }

}
