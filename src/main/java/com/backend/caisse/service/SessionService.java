package com.backend.caisse.service;

import java.util.List;

import com.backend.caisse.entities.Caisse;
import com.backend.caisse.entities.Caissier;
import com.backend.caisse.entities.SessionCaisse;

public interface SessionService {

    SessionCaisse CréerSessionCaisse(SessionCaisse p);

    void fermerSessionCaisseById(Long nums);

    void OuvrirSessionCaisseById(Long nums);

    SessionCaisse consulterSessionCaisse(Long id);

    List<SessionCaisse> listerSessionCaisses();
    
    void fermerJournalCaisse(Long id);
    

    /******************************************/

    List<SessionCaisse> chercherByCaisse(Caisse caisse);

    List<SessionCaisse> chercherByCaisseNumC(Long id);

    List<SessionCaisse> chercherByCaissier(Caissier caissier);

    List<SessionCaisse> chercherByCaissierMatricule(Long id);

    

}
