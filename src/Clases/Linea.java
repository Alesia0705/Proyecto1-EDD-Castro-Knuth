/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import EDD.ListaSimple;

/**
 * Clase que representa una Línea en un sistema de transporte.
 * Cada línea tiene un nombre y una lista de estaciones asociadas.
 * 
 * @author Victoria Knuth
 */
public class Linea {
    private String nombre;
    private ListaSimple estaciones;

    /**
     * Constructor de la clase Linea.
     * Inicializa una línea con un nombre dado y una lista vacía de estaciones.
     *
     * @param nombre El nombre de la línea.
     */
    public Linea(String nombre) {
        this.nombre = nombre;
        this.estaciones = new ListaSimple();
    }

    /**
     * Obtiene el nombre de la línea.
     *
     * @return El nombre de la línea.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la línea.
     *
     * @param nombre El nuevo nombre de la línea.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de estaciones que pertenecen a la línea.
     *
     * @return La lista de estaciones de la línea.
     */
    public ListaSimple getEstaciones() {
        return estaciones;
    }

    /**
     * Establece la lista de estaciones de la línea.
     *
     * @param estaciones La nueva lista de estaciones para la línea.
     */
    public void setEstaciones(ListaSimple estaciones) {
        this.estaciones = estaciones;
    }

    /**
     * Representa la línea como un String, mostrando su nombre y las estaciones que contiene.
     *
     * @return Una representación en String de la línea.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nEstaciones: " + estaciones.Transformar();
    }
}
