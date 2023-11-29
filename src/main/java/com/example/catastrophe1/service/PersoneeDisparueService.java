package com.example.catastrophe1.service;

import com.example.catastrophe1.model.Catastrophe;
import com.example.catastrophe1.model.PersonneDisparue;
import com.example.catastrophe1.repository.PersonneDisparueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersoneeDisparueService {
    private final PersonneDisparueRepo personneDisparueRepo ;
    @Autowired
    public PersoneeDisparueService(PersonneDisparueRepo personneDisparueRepo) {
        this.personneDisparueRepo = personneDisparueRepo;
    }


    public List<PersonneDisparue> findAllPersoneeDisparue(){
        return personneDisparueRepo.findAll();
    }



    public PersonneDisparue addPersonneDisparue(PersonneDisparue personneDisparue){
        return personneDisparueRepo.save(personneDisparue);
    }

    public List<PersonneDisparue> rechercherParNomCatastrophe(String nomCatastrophe) {
        return personneDisparueRepo.findByCatastropheNom(nomCatastrophe);
    }
}
