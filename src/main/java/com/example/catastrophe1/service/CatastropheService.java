package com.example.catastrophe1.service;

import com.example.catastrophe1.model.Catastrophe;
import com.example.catastrophe1.repository.CatastropheRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class CatastropheService {
    private final CatastropheRepo catastropheRepo ;



    @Autowired
    public CatastropheService(CatastropheRepo catastropheRepo) {
        this.catastropheRepo = catastropheRepo;
    }





    public Catastrophe addCatastrophe(Catastrophe catastrophe){
        return catastropheRepo.save(catastrophe);
    }

    public List<Catastrophe> findAllCatastrophe(){
        return catastropheRepo.findAll();
    }


    public List<Catastrophe> findCatastrophesByCountry(String country) {
        return catastropheRepo.findByPays(country);
    }

    public List<Catastrophe> findCatastrophesGouvernement(String gouvernement) {
        return catastropheRepo.findByGouvernoument(gouvernement);
    }

    public List<Catastrophe> findCatastrophesByStatut(String statut) {
        return catastropheRepo.findByStatut(statut);
    }


}
