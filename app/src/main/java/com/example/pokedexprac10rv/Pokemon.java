package com.example.pokedexprac10rv;

public class Pokemon {
    public String nombre;
    public String ultimaEvolucion;
    public String tipo;
    public int imagen;

    public Pokemon (String nombre, String ultimaEvolucion, String tipo, int imagen) {
        this.nombre = nombre;
        this.ultimaEvolucion = ultimaEvolucion;
        this.tipo = tipo;
        this.imagen = imagen;
    }


    public String getNombre() {
        return nombre;
    }

    public Integer getImagen() {
        return imagen;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUltimaEvolucion() {
        return ultimaEvolucion;
    }

}
