package com.backend.caisse.serviceImp;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.backend.caisse.entities.Caissier;
import com.backend.caisse.entities.Client;
import com.backend.caisse.entities.Contrat;
import com.backend.caisse.entities.Encaissement;
import com.backend.caisse.entities.Facture;
import com.backend.caisse.entities.Paiement;
import com.backend.caisse.repos.ClientRepository;
import com.backend.caisse.repos.ContratRepository;
import com.backend.caisse.repos.EncaissementRepository;
import com.backend.caisse.repos.FactureRepository;
import com.backend.caisse.repos.PaiementRepository;
import com.backend.caisse.service.PaiementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaiementServiceImpl implements PaiementService {

    @Autowired
    FactureRepository factureRepository;

    @Autowired
    PaiementRepository paiementRepository;

    @Autowired
    EncaissementRepository encaissementRepository;

    @Autowired
    ContratRepository contratRepository;

    @Autowired
    ClientRepository clientRepository;

  

    @Override
    public void AjouterPaiementFactureAgent(List<Facture> factures) {

        double mt = 0;
        for (Facture f : factures) {

            // FactureServiceImpl.updateFacturePayer(f.getRéférenceFact());
            factureRepository.updateEtatPayer(f.getReferenceFact());
            factureRepository.updateFacture(f.getPaiement(), f.getReferenceFact());
            paiementRepository.updatePaiement(f.getPaiement().getAgent(), f.getPaiement().getIdP());
            mt = mt + f.getMontant();

        }
    }

    @Override
    public Paiement saveSaisieAvance(Facture facture) {

        facture.setEtat("prépayer");
        // facture.setDatePaiement(new Date());
        factureRepository.save(facture);

        // enregistrer le paiement
        Paiement paie = new Paiement();
        return paiementRepository.save(paie);

    }

    // annulation d'une liste des factures
    @Override
    public void AnnulerPaiementListeFacture(List<Facture> fact) {
        Paiement p = new Paiement();
        for (Facture f : fact) {
            factureRepository.updateEtatAnnulerFacture(f.getReferenceFact());
            p = f.getPaiement();
            factureRepository.updateFacturePaiement(f.getReferenceFact());
        }
        paiementRepository.updateEtatAnnulerPaiement(p.getIdP());
        encaissementRepository.updateEtatAnnulerEncaissement(p.getEncaissement().getIdE());

    }

    // annulation d'une liste des factures selon réf contrat

    @Override
    public void AnnulerPaiementRefContrat(Long refContrat) {

        Contrat contrat = contratRepository.findByReferenceContrat(refContrat);

        List<Facture> factures = factureRepository.findByContrat(contrat);

        Paiement p = new Paiement();
        for (Facture f : factures) {
            factureRepository.updateEtatAnnulerFacture(f.getReferenceFact());
            p = f.getPaiement();
            factureRepository.updateFacturePaiement(f.getReferenceFact());
        }
        paiementRepository.updateEtatAnnulerPaiement(p.getIdP());
        encaissementRepository.updateEtatAnnulerEncaissement(p.getEncaissement().getIdE());

    }

    // annulation d'une liste des factures selon réf client

    @Override
    public void AnnulerPaiementRefClient(Long refClient) {

        Client client = clientRepository.findByReferenceClient(refClient);
        List<Facture> factures = factureRepository.findByClient(client);
        Paiement p = new Paiement();
        for (Facture f : factures) {
            factureRepository.updateEtatAnnulerFacture(f.getReferenceFact());
            p = f.getPaiement();
            factureRepository.updateFacturePaiement(f.getReferenceFact());
        }
        paiementRepository.updateEtatAnnulerPaiement(p.getIdP());
        encaissementRepository.updateEtatAnnulerEncaissement(p.getEncaissement().getIdE());

    }

    // annulation d'une facture selon la réf facture
    @Override
    public void AnnulerPaiementRefFacture(Long refFacture) {

        Facture facture = factureRepository.findByReferenceFact(refFacture);
        factureRepository.updateEtatAnnulerFacture(facture.getReferenceFact());
        paiementRepository.updateEtatAnnulerPaiement(facture.getPaiement().getIdP());
        encaissementRepository.updateEtatAnnulerEncaissement(facture.getPaiement().getEncaissement().getIdE());
        factureRepository.updateFacturePaiement(facture.getReferenceFact());

    }

    @Override
    public List<Paiement> ListerPaiements() {

        return paiementRepository.findByDateP(LocalDate.now());
    }

    @Override
    public Paiement ajouterPaiement(Paiement p) {

        return paiementRepository.save(p);
    }

    @Override
    public List<Facture> AjouterPaiementFacture(List<Facture> factures) {

        double mt = 0;
        Paiement paiement = new Paiement();
        for (Facture f : factures) {

            factureRepository.updateEtatPayer(f.getReferenceFact());
            factureRepository.updateFacture(f.getPaiement(), f.getReferenceFact());
            mt = mt + f.getMontant();
            paiement = f.getPaiement();

        }
        Encaissement enc = new Encaissement(new Date(), mt);
        encaissementRepository.save(enc);
        // update le paiement
        paiementRepository.updateEncaissementPaiement(enc, paiement.getIdP());

        return factures;
    }
    
}
