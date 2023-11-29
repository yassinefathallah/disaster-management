package com.example.catastrophe1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ServiceUrgence {
    @Id
    private Long id ;
    private String nom ;
    private String descreption ;
    private int numeroTl ;


    @ManyToOne
    @JoinColumn(name = "catastrophr_id")
    private Catastrophe catastrophe;


    @ManyToOne
    @JoinColumn(name = "administrateur_id")
    private Administrateur administrateur;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Catastrophe getCatastrophe() {
        return catastrophe;
    }

    public void setCatastrophe(Catastrophe catastrophe) {
        this.catastrophe = catastrophe;
    }
}
