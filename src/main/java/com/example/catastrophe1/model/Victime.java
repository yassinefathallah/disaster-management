package com.example.catastrophe1.model;

import jakarta.persistence.*;

@Entity
public class Victime extends PersonneDisparue{

    private String etatDeSante ;
    private String localisation ;











    public String getEtatDeSante() {
        return etatDeSante;
    }

    public void setEtatDeSante(String etatDeSante) {
        this.etatDeSante = etatDeSante;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }


}

