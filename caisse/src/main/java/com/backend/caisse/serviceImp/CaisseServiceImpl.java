package com.backend.caisse.serviceImp;

import java.util.List;

import com.backend.caisse.entities.AffectMode;
import com.backend.caisse.entities.Caisse;
import com.backend.caisse.repos.AffectModeRepository;
import com.backend.caisse.repos.CaisseRepository;
import com.backend.caisse.service.CaisseService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaisseServiceImpl implements CaisseService {

    @Autowired
    private CaisseRepository caisseRepository;
    @Autowired
    private AffectModeRepository affectmodeRepository;

    @Override
    public Caisse ajouterCaisse(Caisse p) {

        return caisseRepository.save(p);
    }

    @Override
    public Caisse modifierCaisse(Caisse p) {

        return caisseRepository.save(p);
    }

    @Override
    public void desactiverCaisseById(Long numc) {

        caisseRepository.updateEtatDesact(numc);

    }

    @Override
    public void activerCaisseById(Long numc) {

        caisseRepository.updateEtatAct(numc);
    }

    @Override
    public Caisse consulterCaisse(Long numc) {

        return caisseRepository.findById(numc).get();
    }

    @Override
    public List<Caisse> listerCaisses() {

        return caisseRepository.findAll();
    }

    @Override
    public void affecterMode(AffectMode a) {
        affectmodeRepository.save(a);
        
    }

    /*@Override
    public List<Caisse> ChercherCaissesByMode(ModePaiement mode) {

        return caisseRepository.findByModes(mode);
    }

    @Override
    public List<Caisse> chercherCaissesbyModeCode(Long code) {

        return caisseRepository.findByModesCode(code);
    }
*/
  

}
