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

    @RequestMapping(value = "/consulterSessionCaisse/{numS}", method = RequestMethod.GET)
    public  ResponseEntity<Object>  cosulterSessionCaisse(@PathVariable("numS") Long numS) {
        try{
            return new ResponseEntity<Object>(sessionService.consulterSessionCaisse(numS),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/creerSessionCaisse",method = RequestMethod.POST)
    public  ResponseEntity<Object>  creerSessionCaisse(@RequestBody SessionCaisse SessionCaisse) {
        try{
            return new ResponseEntity<Object>(sessionService.CréerSessionCaisse(SessionCaisse),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/fermerSessionCaisse/{NumS}",method = RequestMethod.PUT)
    public void fermerSessionCaisse(@PathVariable("NumS") Long nums) {
        sessionService.fermerSessionCaisseById(nums);
    }

    @RequestMapping(value = "/ouvrirSessionCaisse/{NumS}",method = RequestMethod.PUT)
    public void ouvrirSessionCaisse(@PathVariable("NumS") Long nums) {
        sessionService.OuvrirSessionCaisseById(nums);
    }

    @RequestMapping(value = "/fermerJournalCaisse/{NumS}",method = RequestMethod.PUT)
    public void fermerJournalCaisse(@PathVariable("NumS") Long nums) {
        sessionService.fermerJournalCaisse(nums);
    }

}
