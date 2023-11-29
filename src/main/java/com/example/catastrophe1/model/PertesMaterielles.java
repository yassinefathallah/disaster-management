package com.example.catastrophe1.model;

import jakarta.persistence.*;

@Entity
public class PertesMaterielles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id ;

    private String descreption;
    private double valeur;





    @ManyToOne
    @JoinColumn(name = "catastrophr_id")
    private Catastrophe catastrophe;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Utilisateur utilisateur;


}

