package com.example.catastrophe1.service;

import com.example.catastrophe1.repository.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VictimeService {
    private final UtilisateurRepo utilisateurRepo ;
    @Autowired
    public VictimeService(UtilisateurRepo utilisateurRepo) {
        this.utilisateurRepo = utilisateurRepo;
    }
}
