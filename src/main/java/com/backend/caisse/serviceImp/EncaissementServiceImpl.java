package com.backend.caisse.serviceImp;

import java.util.List;

import com.backend.caisse.entities.Encaissement;
import com.backend.caisse.entities.SessionCaisse;
import com.backend.caisse.repos.EncaissementRepository;
import com.backend.caisse.service.EncaissementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncaissementServiceImpl implements EncaissementService{

    @Autowired
    private EncaissementRepository encaissementRepository;

    @Override
    public List<Encaissement> listerEncaissements() {
   
        return encaissementRepository.findAll();
    }

    /*@Override
    public List<Encaissement> listerEncaissementsByEtat(Long numS) {
 
        return encaissementRepository.findBySession(numS);
    }*/

    @Override
    public List<Encaissement> listerEncaissementsBySession(Long nums) {
        
        return encaissementRepository.findBySessionNumS(nums);
    }
    
}
