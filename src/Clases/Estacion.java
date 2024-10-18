/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import EDD.ListaSimple;

/**
 * Clase que representa una Estación en un sistema de transporte.
 * Cada estación tiene un nombre, un número de estación, y está conectada a otras estaciones
 * adyacentes y peatonales. Además, puede o no tener una sucursal.
 * 
 * @author Victoria Knuth
 */
public class Estacion {
    private String nombre;
    private int numeroEstacion;
    private ListaSimple listaAd;
    private boolean tieneSucursal;
    private ListaSimple peaton;
    
    /**
     * Constructor de la clase Estacion.
     * Inicializa una estación con un nombre dado y establece las propiedades por defecto.
     *
     * @param nombre El nombre de la estación.
     */
    public Estacion(String nombre) {
        this.nombre = nombre;
        this.numeroEstacion = -1;
        this.listaAd = new ListaSimple();
        this.tieneSucursal = false;
        this.peaton = new ListaSimple();
    }

    /**
     * Obtiene el nombre de la estación.
     *
     * @return El nombre de la estación.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la estación.
     *
     * @param nombre El nuevo nombre de la estación.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de la estación.
     *
     * @return El número de la estación.
     */
    public int getNumeroEstacion() {
        return numeroEstacion;
    }

    /**
     * Establece el número de la estación.
     *
     * @param numeroEstacion El número de la estación.
     */
    public void setNumeroEstacion(int numeroEstacion) {
        this.numeroEstacion = numeroEstacion;
    }

    /**
     * Obtiene la lista de estaciones adyacentes.
     *
     * @return La lista de estaciones adyacentes.
     */
    public ListaSimple getListaAd() {
        return listaAd;
    }

    /**
     * Establece la lista de estaciones adyacentes.
     *
     * @param listaAd La nueva lista de estaciones adyacentes.
     */
    public void setListaAd(ListaSimple listaAd) {
        this.listaAd = listaAd;
    }

    /**
     * Verifica si la estación tiene una sucursal.
     *
     * @return {@code true} si la estación tiene sucursal, {@code false} en caso contrario.
     */
    public boolean isTieneSucursal() {
        return tieneSucursal;
    }

    /**
     * Establece si la estación tiene o no una sucursal.
     *
     * @param tieneSucursal {@code true} si la estación tiene sucursal, {@code false} en caso contrario.
     */
    public void setTieneSucursal(boolean tieneSucursal) {
        this.tieneSucursal = tieneSucursal;
    }

    /**
     * Obtiene la lista de estaciones conectadas peatonalmente.
     *
     * @return La lista de estaciones conectadas peatonalmente.
     */
    public ListaSimple getPeaton() {
        return peaton;
    }

    /**
     * Establece la lista de estaciones conectadas peatonalmente.
     *
     * @param peaton La nueva lista de estaciones peatonales.
     */
    public void setPeaton(ListaSimple peaton) {
        this.peaton = peaton;
    }

    /**
     * Transforma la lista de estaciones adyacentes en un String concatenado.
     * Muestra los nombres de las estaciones adyacentes separadas por "->".
     *
     * @return Un String con la lista de nombres de las estaciones adyacentes, o {@code null} si no hay adyacentes.
     */
    public String TransformarListAdy() {
        if (!this.listaAd.EsVacio()) {
            String listAdStr = "";
            for (int i = 0; i < this.listaAd.getSize(); i++) {
                Estacion estacion = (Estacion) this.listaAd.getValor(i);
                listAdStr += estacion.getNombre() + "->";
            }
            return listAdStr;
        } else {
            return null;
        }
    }

    /**
     * Representa la estación como un String, mostrando su nombre, número,
     * si tiene sucursal, las estaciones adyacentes y las peatonales.
     *
     * @return Una representación en String de la estación.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre)
          .append("\nNumero de Estacion: ").append(numeroEstacion)
          .append("\nTiene Sucursal: ").append(tieneSucursal)
          .append("\nEstaciones Adyacentes: ");

        // Mostrar solo los nombres de las estaciones adyacentes
        for (int i = 0; i < listaAd.getSize(); i++) {
            Estacion adyacente = (Estacion) listaAd.getValor(i);
            sb.append(adyacente.getNombre()).append(", ");
        }

        sb.append("\nEstaciones Peatonales: ");
        // Mostrar solo los nombres de las estaciones conectadas peatonalmente
        for (int i = 0; i < peaton.getSize(); i++) {
            Estacion peatonal = (Estacion) peaton.getValor(i);
            sb.append(peatonal.getNombre()).append(", ");
        }

        return sb.toString();
    }
}
