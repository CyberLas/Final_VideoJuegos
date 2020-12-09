package com.example.poke;


public class Pokemon {

    private String nombre;

    private String tipo;

    private String imagen;

    private Number latitude;

    private Number longitude;

    public Pokemon(String nombre, String tipo, String imagen, Number latitude, Number longitude) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.imagen = imagen;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNombre() { return nombre; }

    public String getTipo() {
        return tipo;
    }

    public String getImagen() {
        return imagen;
    }

    public Number getLatitude() {
        return latitude;
    }

    public Number getLongitude() {
        return longitude;
    }
}
