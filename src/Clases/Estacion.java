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
public class Estacion {
    private String nombre;
    private int numeroEstacion;
    private ListaSimple listaAd;
    private boolean tieneSucursal;
    private ListaSimple peaton;

    public Estacion(String nombre) {
        this.nombre = nombre;
        this.numeroEstacion = -1;
        this.listaAd = new ListaSimple();
        this.tieneSucursal = false;
        this.peaton = new ListaSimple();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroEstacion() {
        return numeroEstacion;
    }

    public void setNumeroEstacion(int numeroEstacion) {
        this.numeroEstacion = numeroEstacion;
    }

    public ListaSimple getListaAd() {
        return listaAd;
    }

    public void setListaAd(ListaSimple listaAd) {
        this.listaAd = listaAd;
    }

    public boolean isTieneSucursal() {
        return tieneSucursal;
    }

    public void setTieneSucursal(boolean tieneSucursal) {
        this.tieneSucursal = tieneSucursal;
    }

    public ListaSimple getPeaton() {
        return peaton;
    }

    public void setPeaton(ListaSimple peaton) {
        this.peaton = peaton;
    }

    public String TransformarListAdy() {
        if (!this.listaAd.EsVacio()) {
            String listAdStr = "";
            for (int i = 0; i < this.listaAd.getSize(); i++) {
                Estacion estacion = (Estacion) this.listaAd.getValor(i);
                listAdStr += estacion.getNombre() + "->";
            }

            return listAdStr;
        }else{
            return null;
        }
    }

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
