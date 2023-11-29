package com.example.catastrophe1.service;

import com.example.catastrophe1.model.Aide;
import com.example.catastrophe1.repository.AideRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AideService {

    private final AideRepo aideRepo;

    @Autowired
    public AideService(AideRepo aideRepo) {
        this.aideRepo = aideRepo;
    }

    public List<Aide> listerToutesLesAides() {
        return aideRepo.findAll();
    }

    public Aide ajouterAide(Aide aide) {
        return aideRepo.save(aide);
    }
}