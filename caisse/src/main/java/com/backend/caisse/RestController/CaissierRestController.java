package com.backend.caisse.RestController;

import java.util.List;

import com.backend.caisse.service.CaissierService;
import com.backend.caisse.entities.Caissier;

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
@RequestMapping("/caissier")
@CrossOrigin(origins = "*")

public class CaissierRestController {

    @Autowired
    CaissierService CaissierService;

    @RequestMapping(path = "/listerCaissiers",method = RequestMethod.GET)
    public ResponseEntity<Object> listerCaissiers() {
        try{
            return new ResponseEntity<Object>(CaissierService.listerCaissiers(),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/ajouterCaissier",method = RequestMethod.POST)
    public ResponseEntity<Object> ajouterCaissier(@RequestBody Caissier Caissier) {
        try{
            return new ResponseEntity<Object>(CaissierService.ajouterCaissier(Caissier),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/modifierCaissier",method = RequestMethod.PUT)
    public ResponseEntity<Object> modifierCaissier(@RequestBody Caissier Caissier) {
        try{
            return new ResponseEntity<Object>(CaissierService.modifierCaissier(Caissier),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "consulterCaissier/{matricule}", method = RequestMethod.GET)
    public ResponseEntity<Object> consulterCaissier(@PathVariable("matricule") Long matricule) {
        try{
            return new ResponseEntity<Object>(CaissierService.consulterCaissier(matricule),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/desactiverCaissier/{matricule}", method = RequestMethod.PUT)
    public void desactiverCaissier(@PathVariable("matricule") Long mat) {
        CaissierService.desactiverCaissierByMat(mat);
    }

    @RequestMapping(value = "/activerCaissier/{matricule}", method = RequestMethod.PUT)
    public void activerCaissier(@PathVariable("matricule") Long mat) {
        CaissierService.activerCaissierByMat(mat);
    }

}
