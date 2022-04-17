package com.backend.caisse.RestController;

import com.backend.caisse.entities.SessionCaisse;
import com.backend.caisse.service.EncaissementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/encaissement")
@CrossOrigin(origins = "*")
public class EncaissementRestController {

    @Autowired
    EncaissementService encaissementService;

    @RequestMapping(path = "/listerEncaissements",method = RequestMethod.GET)
    public ResponseEntity<Object> listerEncaissements() {
        try{
            return new ResponseEntity<Object>(encaissementService.listerEncaissements(),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

 /*   @RequestMapping(path = "/listerEncaissementsByEtat/{num}",method = RequestMethod.GET)
    public ResponseEntity<Object> listerEncaissementsByEtat(@PathVariable("nums") Long nums) {
        try{
            return new ResponseEntity<Object>(encaissementService.listerEncaissementsByEtat(nums),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }*/

    @RequestMapping(path = "/listerEncaissementsBySession/{session}",method = RequestMethod.GET)
    public ResponseEntity<Object> listerEncaissementsBySession(@PathVariable("session") Long session) {
        try{
            return new ResponseEntity<Object>(encaissementService.listerEncaissementsBySession(session),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
}
