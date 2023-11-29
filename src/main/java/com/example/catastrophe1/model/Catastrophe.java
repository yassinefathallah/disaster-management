package com.example.catastrophe1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity

public class Catastrophe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id ;
    private int niveauDUrgence ;
    private String nom_catastrophe;
    private String statut ;
    private Date date ;
    private String pays ;
    private String etat ;
    private String gouvernoument ;







    @OneToMany(mappedBy = "catastrophe")
    private List<Victime> victimes;

    @OneToMany(mappedBy = "catastrophe")
    private List<ServiceUrgence> serviceDUrgances;

    @OneToMany(mappedBy = "catastrophe")
    private List<PertesMaterielles> pertesMaterielles;

    @OneToMany(mappedBy = "catastrophe")
    @JsonIgnore
    private List<PersonneDisparue> personneDisparues;












    public Catastrophe() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNiveauDUrgence() {
        return niveauDUrgence;
    }

    public void setNiveauDUrgence(int niveauDUrgence) {
        this.niveauDUrgence = niveauDUrgence;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getGouvernoument() {
        return gouvernoument;
    }

    public void setGouvernoument(String gouvernoument) {
        this.gouvernoument = gouvernoument;
    }

    public List<Victime> getVictimes() {
        return victimes;
    }

    public void setVictimes(List<Victime> victimes) {
        this.victimes = victimes;
    }

    public List<ServiceUrgence> getServiceDUrgances() {
        return serviceDUrgances;
    }

    public void setServiceDUrgances(List<ServiceUrgence> serviceDUrgances) {
        this.serviceDUrgances = serviceDUrgances;
    }

    public List<PertesMaterielles> getPertesMaterielles() {
        return pertesMaterielles;
    }

    public void setPertesMaterielles(List<PertesMaterielles> pertesMaterielles) {
        this.pertesMaterielles = pertesMaterielles;
    }

    public List<PersonneDisparue> getPersonneDisparues() {
        return personneDisparues;
    }

    public void setPersonneDisparues(List<PersonneDisparue> personneDisparues) {
        this.personneDisparues = personneDisparues;
    }

    public String getNomCatastrophe() {
        return nom_catastrophe;
    }

    public void setNomCatastrophe(String nomCatastrophe) {
        this.nom_catastrophe = nomCatastrophe;
    }
}
