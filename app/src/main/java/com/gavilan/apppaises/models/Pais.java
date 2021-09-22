package com.gavilan.apppaises.models;

public class Pais {
    private int id;
    private String nombrePais;
    private String nombreContinente;

    public Pais() {
    }

    public Pais(String nombrePais, String nombreContinente) {
        this.nombrePais = nombrePais;
        this.nombreContinente = nombreContinente;
    }

    public Pais(int id, String nombrePais, String nombreContinente) {
        this.id = id;
        this.nombrePais = nombrePais;
        this.nombreContinente = nombreContinente;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getNombreContinente() {
        return nombreContinente;
    }

    public void setNombreContinente(String nombreContinente) {
        this.nombreContinente = nombreContinente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
