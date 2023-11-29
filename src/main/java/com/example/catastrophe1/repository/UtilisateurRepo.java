package com.example.catastrophe1.repository;

import com.example.catastrophe1.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UtilisateurRepo extends JpaRepository<Utilisateur, Integer> {


    Utilisateur findByEmail(String email);
}
