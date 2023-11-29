package com.example.catastrophe1.model;

import jakarta.persistence.*;
import org.apache.catalina.User;

@Entity
public class Aide {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String type;
    private String discreption;
    private String quantite ;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Utilisateur utilisateur;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDiscreption() {
        return discreption;
    }

    public void setDiscreption(String discreption) {
        this.discreption = discreption;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }
}
