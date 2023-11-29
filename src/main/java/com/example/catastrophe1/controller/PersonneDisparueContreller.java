package com.example.catastrophe1.controller;

import com.example.catastrophe1.model.Catastrophe;
import com.example.catastrophe1.model.PersonneDisparue;
import com.example.catastrophe1.service.CatastropheService;
import com.example.catastrophe1.service.PersoneeDisparueService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/personne_disparue")
public class PersonneDisparueContreller {
    private final PersoneeDisparueService personneDisparueService ;

    @GetMapping
    public ResponseEntity<List<PersonneDisparue>> getAllPersonneDisparue(){
      List<PersonneDisparue> personneDisparues = personneDisparueService.findAllPersoneeDisparue();
      return new ResponseEntity<>(personneDisparues,HttpStatus.OK);
    }



   @PostMapping("/add")
   public ResponseEntity<PersonneDisparue> addPersonneDisparue(@RequestBody PersonneDisparue personneDisparue) {
       PersonneDisparue newPersonneDisparue = personneDisparueService.addPersonneDisparue(personneDisparue);
       return new ResponseEntity<>(newPersonneDisparue, HttpStatus.CREATED);
   }



    @GetMapping("/rechercher/{nomCatastrophe}")
    public ResponseEntity<List<PersonneDisparue>> rechercherParNomCatastrophe(@PathVariable String nomCatastrophe) {
        List<PersonneDisparue> personnesDisparues = personneDisparueService.rechercherParNomCatastrophe(nomCatastrophe);

        if (personnesDisparues.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(personnesDisparues,HttpStatus.OK);
    }








}
