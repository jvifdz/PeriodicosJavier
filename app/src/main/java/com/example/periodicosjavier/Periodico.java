package com.example.periodicosjavier;

public class Periodico {

    long id;
    String nombre;
    String tematica;

    public Periodico(long id, String nombre, String tematica) {
        this.id = id;
        this.nombre = nombre;
        this.tematica = tematica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
