package com.example.catastrophe1.service;

import com.example.catastrophe1.repository.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {
    private final UtilisateurRepo utilisateurRepo ;
    @Autowired
    public UtilisateurService(UtilisateurRepo utilisateurRepo) {
        this.utilisateurRepo = utilisateurRepo;
    }




}
