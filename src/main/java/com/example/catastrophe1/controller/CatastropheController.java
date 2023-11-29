package com.example.catastrophe1.controller;

import com.example.catastrophe1.model.Catastrophe;
import com.example.catastrophe1.service.CatastropheService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/catastrophe")
public class CatastropheController {
    private final CatastropheService catastropheService ;


    @GetMapping
    public ResponseEntity<List<Catastrophe>> getAllCatastrophe(){
        List<Catastrophe> catastrophes = catastropheService.findAllCatastrophe();
        return new ResponseEntity<>(catastrophes, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Catastrophe> addCatastrophe(@RequestBody Catastrophe  catastrophe) {
        Catastrophe newCatastrophe = catastropheService.addCatastrophe(catastrophe);
        return new ResponseEntity<>(newCatastrophe,HttpStatus.OK);
    }

    @GetMapping("/byCountry/{country}")
    public ResponseEntity<List<Catastrophe>> getCatastrophesByCountry(@PathVariable String country) {
        List<Catastrophe> catastrophes = catastropheService.findCatastrophesByCountry(country);

        if (catastrophes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(catastrophes, HttpStatus.OK);
    }

    @GetMapping("/bygouvernement/{gouvernement}")
    public ResponseEntity<List<Catastrophe>> getCatastrophesByGouvernement(@PathVariable String gouvernement) {
        List<Catastrophe> catastrophes = catastropheService.findCatastrophesGouvernement(gouvernement);

        if (catastrophes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(catastrophes, HttpStatus.OK);
    }
    @GetMapping("/bystatut/{statut}")
    public ResponseEntity<List<Catastrophe>> getCatastrophesByStatut(@PathVariable String statut) {
        List<Catastrophe> catastrophes = catastropheService.findCatastrophesByStatut(statut);

        if (catastrophes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(catastrophes, HttpStatus.OK);
    }





}
