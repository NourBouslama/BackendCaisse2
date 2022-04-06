package com.backend.caisse.RestController;

import java.util.List;

import com.backend.caisse.entities.Facture;
import com.backend.caisse.service.FactureService;

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
@RequestMapping("/api/fact")
@CrossOrigin
public class FactureRestController {
    @Autowired
    FactureService factureService;

    @RequestMapping(value = "/refClient/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> chercherFactureRéférenceClient(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<Object>(factureService.ChercherRéférenceClient(id), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/refContrat/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> chercherFactureRéférenceContrat(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<Object>(factureService.ChercherRéférenceContrat(id), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/refFacture/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> chercherFactureRéférenceFacture(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<Object>(factureService.ChercherRéférenceFact(id), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/ajouterFacture", method = RequestMethod.POST)
    public ResponseEntity<Object> ajouterFacture(@RequestBody Facture facture) {
        try {
            return new ResponseEntity<Object>(factureService.saveFacture(facture), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
