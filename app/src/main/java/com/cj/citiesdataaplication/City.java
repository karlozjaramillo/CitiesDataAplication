package com.cj.citiesdataaplication;

public class City {
    int id;
    String nombre;
    int poblacion;
    double latitud;
    double longitud;

    public City() {
    }

    public City(int id, String nombre, int poblacion, double latitud, double longitud) {
        this.id = id;
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                "Nombre: " + nombre +
                "Poblacion: " + poblacion +
                "Latitud: " + latitud +
                "Longitud: " + longitud;
    }
}
