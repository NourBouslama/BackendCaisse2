package com.backend.caisse.RestController;

import java.util.List;

import com.backend.caisse.entities.SessionCaisse;
import com.backend.caisse.service.SessionService;

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
@RequestMapping("/session")
@CrossOrigin(origins = "*")
public class SessionRestController {
    @Autowired
    SessionService sessionService;

    @RequestMapping(path = "/listerSessionCaisses", method = RequestMethod.GET)
    public  ResponseEntity<Object>  listerSessionCaisses() {
        try{
            return new ResponseEntity<Object>(sessionService.listerSessionCaisses(),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    @RequestMapping(path = "/listerEncaissementbyEtat/{etat}", method = RequestMethod.GET)
    public  ResponseEntity<Object>  listerEncaissementbyEtat(@PathVariable("etat") String etat) {
        try{
            return new ResponseEntity<Object>(sessionService.listerEncaissementbyEtat(etat),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/consulterSessionCaisse/{nums}", method = RequestMethod.GET)
    public  ResponseEntity<Object>  cosulterSessionCaisse(@PathVariable("nums") Long nums) {
        try{
            return new ResponseEntity<Object>(sessionService.consulterSessionCaisse(nums),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/creerSessionCaisse",method = RequestMethod.POST)
    public  ResponseEntity<Object>  creerSessionCaisse(@RequestBody SessionCaisse SessionCaisse) {
        try{
            return new ResponseEntity<Object>(sessionService.CreerSessionCaisse(SessionCaisse),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/fermerSessionCaisse/{nums}",method = RequestMethod.PUT)
    public void fermerSessionCaisse(@PathVariable("nums") Long nums) {
        sessionService.fermerSessionCaisseById(nums);
    }

    /*@RequestMapping(value = "/updateDateFermetureById/{nums}",method = RequestMethod.PUT)
    public void updateDateFermetureById(@PathVariable("nums") Long nums) {
        sessionService.updateDateFermetureById(nums);
    }*/

    @RequestMapping(value = "/ouvrirSessionCaisse/{nums}",method = RequestMethod.PUT)
    public void ouvrirSessionCaisse(@PathVariable("nums") Long nums) {
        sessionService.OuvrirSessionCaisseById(nums);
    }

    @RequestMapping(value = "/fermerJournalCaisse/{nums}",method = RequestMethod.PUT)
    public void fermerJournalCaisse(@PathVariable("nums") Long nums) {
        sessionService.fermerJournalCaisse(nums);
    }

}
