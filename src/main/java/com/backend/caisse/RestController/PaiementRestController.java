package com.backend.caisse.RestController;

import java.util.List;
import com.backend.caisse.entities.Facture;
import com.backend.caisse.entities.Paiement;
import com.backend.caisse.service.PaiementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paiement")
@CrossOrigin

public class PaiementRestController {
    @Autowired
    PaiementService paiementService;

    @RequestMapping(value = "/annuler/{id}", method = RequestMethod.PUT)
    public void annulerPaiement(@PathVariable("id") Long id) {
        paiementService.AnnulerPaiementRefFacture(id);
    }

    @RequestMapping(path = "/annuler", method = RequestMethod.PUT)
    public void annulerPaiement3(@RequestBody List<Facture> factures) {
        paiementService.AnnulerPaiementListeFacture(factures);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> listerPaiements() {
        try {
            return new ResponseEntity<Object>(paiementService.ListerPaiements(), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/payer", method = RequestMethod.PUT)
    public ResponseEntity<Object> ajouterPaiementFacture(@RequestBody List<Facture> factures) {
        try {
            return new ResponseEntity<Object>(paiementService.AjouterPaiementFacture(factures), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/payeragent", method = RequestMethod.PUT)
    public void ajouterPaiementFactureAgent(@RequestBody List<Facture> factures) {
        paiementService.AjouterPaiementFactureAgent(factures);
    }

    @RequestMapping(path = "/avance", method = RequestMethod.POST)
    public ResponseEntity<Object> saisieAvanceFacture(@RequestBody Facture facture) {
        try {
            return new ResponseEntity<Object>(paiementService.saveSaisieAvance(facture), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
