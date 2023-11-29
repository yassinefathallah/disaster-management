package com.example.catastrophe1.service;

import com.example.catastrophe1.model.Administrateur;
import com.example.catastrophe1.repository.AdministrateurRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdministrateurService {
    private final AdministrateurRepo administrateurRepository;

    @Autowired
    public AdministrateurService(AdministrateurRepo administrateurRepository) {
        this.administrateurRepository = administrateurRepository;
    }

    public List<Administrateur> getAllAdministrateurs() {
        return administrateurRepository.findAll();
    }

    public Administrateur getAdministrateurById(Long id) {
        return administrateurRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Administrateur non trouvé avec l'ID : " + id));
    }

    public Administrateur ajouterAdministrateur(Administrateur administrateur) {
        // Logique pour ajouter un administrateur, par exemple, enregistrer dans la base de données
        return administrateurRepository.save(administrateur);
    }

    public void supprimerAdministrateur(Long id) {
        // Logique pour supprimer un administrateur par ID
        administrateurRepository.deleteById(id);
    }
}



