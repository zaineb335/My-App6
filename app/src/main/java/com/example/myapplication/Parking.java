package com.example.myapplication;

public class Parking {
    String nomP;
    String ville;


    public Parking(String np,String vi){
        this.nomP=np;
        this.ville=vi;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public String getNomP() {
        return nomP;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getVille() {
        return ville;
    }

}
