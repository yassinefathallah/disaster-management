package com.example.catastrophe1.controller;

import com.example.catastrophe1.model.Administrateur;
import com.example.catastrophe1.service.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrateurs")
public class AdministrateurController {
    private final AdministrateurService administrateurService;

    @Autowired
    public AdministrateurController(AdministrateurService administrateurService) {
        this.administrateurService = administrateurService;
    }

    @GetMapping
    public ResponseEntity<List<Administrateur>> getAllAdministrateurs() {
        List<Administrateur> administrateurs = administrateurService.getAllAdministrateurs();
        return new ResponseEntity<>(administrateurs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrateur> getAdministrateurById(@PathVariable Long id) {
        Administrateur administrateur = administrateurService.getAdministrateurById(id);
        return new ResponseEntity<>(administrateur, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Administrateur> ajouterAdministrateur(@RequestBody Administrateur administrateur) {
        Administrateur newAdministrateur = administrateurService.ajouterAdministrateur(administrateur);
        return new ResponseEntity<>(newAdministrateur, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerAdministrateur(@PathVariable Long id) {
        administrateurService.supprimerAdministrateur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
