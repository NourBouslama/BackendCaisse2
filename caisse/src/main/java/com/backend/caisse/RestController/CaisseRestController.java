package com.backend.caisse.RestController;

import com.backend.caisse.service.CaisseService;

import java.util.List;

import com.backend.caisse.entities.AffectMode;
import com.backend.caisse.entities.Caisse;

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
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CaisseRestController {
    @Autowired
    CaisseService caisseService;

    @RequestMapping(path = "/listerCaisses", method = RequestMethod.GET)
    public ResponseEntity<Object> listerCaisses() {
        try{
            return new ResponseEntity<Object>(caisseService.listerCaisses(),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @RequestMapping(value = "/consulterCaisse/{numC}", method = RequestMethod.GET)
    public ResponseEntity<Object> consulterCaisse(@PathVariable("numC") Long numC) {
        try{
            return new ResponseEntity<Object>(caisseService.consulterCaisse(numC),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
      
    }

    @RequestMapping(value="/ajouterCaisse",method = RequestMethod.POST)
    public ResponseEntity<Object> ajouterCaisse(@RequestBody Caisse Caisse) {
        try{
            return new ResponseEntity<Object>(caisseService.ajouterCaisse(Caisse),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/modifierCaisse",method = RequestMethod.PUT)
    public ResponseEntity<Object> modifierCaisse(@RequestBody Caisse Caisse) {
        try{
            return new ResponseEntity<Object>(caisseService.modifierCaisse(Caisse),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/desactiverCaisse/{numC}",method = RequestMethod.PUT)
    public void desactiverCaisse(@PathVariable("numC") Long numc) {
         caisseService.desactiverCaisseById(numc);
    }

    @RequestMapping(value = "/activerCaisse/{numC}",method = RequestMethod.PUT)
    public void activerCaisse(@PathVariable("numC") Long numc) {
         caisseService.activerCaisseById(numc);
    }

    @RequestMapping(value = "/affecterMode",method = RequestMethod.POST)
    public void affecterMode(@RequestBody AffectMode a) {
         caisseService.affecterMode(a);
    }

  /*  @RequestMapping(value = "/chercherCaissesParMode/{code}", method = RequestMethod.GET)
    public ResponseEntity<Object> chercherCaissesParModeCode(@PathVariable("code") Long code) {
        try{
            return new ResponseEntity<Object>(caisseService.chercherCaissesbyModeCode(code),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
*/
    
    
}
