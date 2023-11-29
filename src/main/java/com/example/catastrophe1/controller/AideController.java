package com.example.catastrophe1.controller;

import com.example.catastrophe1.model.Aide;
import com.example.catastrophe1.service.AideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/aides")
public class AideController {

    private final AideService aideService;

    @Autowired
    public AideController(AideService aideService) {
        this.aideService = aideService;
    }

    @GetMapping("/liste")
    public ResponseEntity<List<Aide>> listerToutesLesAides() {
        List<Aide> aides = aideService.listerToutesLesAides();
        return new ResponseEntity<>(aides, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Aide> ajouterAide(@RequestBody Aide aide) {
        Aide nouvelleAide = aideService.ajouterAide(aide);
        return new ResponseEntity<>(nouvelleAide, HttpStatus.CREATED);
    }
}
