package com.backend.caisse.serviceImp;

import java.util.List;

import com.backend.caisse.entities.Client;
import com.backend.caisse.entities.Contrat;
import com.backend.caisse.entities.Facture;
import com.backend.caisse.repos.ClientRepository;
import com.backend.caisse.repos.ContratRepository;
import com.backend.caisse.repos.FactureRepository;
import com.backend.caisse.service.FactureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactureServiceImpl implements FactureService {

    @Autowired
    FactureRepository factureRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ContratRepository contratRepository;

    @Override
    public List<Facture> ChercherRéférenceContrat(Long rfc) {
        // return factureRepository.findByRéférenceContrat(rfc);
        Contrat contrat = contratRepository.findByReferenceContrat(rfc);
        return factureRepository.findByContrat(contrat);
    }

    @Override
    public List<Facture> ChercherRéférenceClient(Long rf) {
        // return factureRepository.findByRéférenceClient(rf);
        Client client = clientRepository.findByReferenceClient(rf);
        return factureRepository.findByClient(client);
    }

    @Override
    public Facture ChercherRéférenceFact(Long ff) {
        return factureRepository.findByReferenceFact(ff);
    }

    @Override
    public void updateFacturePayer(long ref) {
        factureRepository.updateEtatPayer(ref);

    }

    @Override
    public Facture saveFacture(Facture facture) {

        return factureRepository.save(facture);
    }
}
