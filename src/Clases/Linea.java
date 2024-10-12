/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import EDD.ListaSimple;

/**
 *
 * @author Victoria Knuth
 */
public class Linea {
    private String nombre;
    private ListaSimple estaciones;

    public Linea(String nombre) {
        this.nombre = nombre;
        this.estaciones = new ListaSimple();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaSimple getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(ListaSimple estaciones) {
        this.estaciones = estaciones;
    }

    @Override
    public String toString() {
        return "Nombre" + nombre + "\nEstaciones: " + estaciones.Transformar();
    }
}
