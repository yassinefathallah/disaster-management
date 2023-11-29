package com.example.catastrophe1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Administrateur extends Utilisateur{



    @OneToMany(mappedBy = "administrateur")
    private List<ServiceUrgence> serviceDUrgances ;






}
