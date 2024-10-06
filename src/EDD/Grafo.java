/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Clases.Estacion;

/**
 *
 * @author Alesia Castro
 */
public class Grafo {
private ListaSimple estaciones;

    
    public Grafo() {
        this.estaciones = new ListaSimple();
    }
    
    public Grafo(ListaSimple estaciones) {
        this.estaciones = estaciones;
    }

    public ListaSimple getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(ListaSimple estaciones) {
        this.estaciones = estaciones;
    }
    
    public void añadirEstacion(Estacion estacion){
        this.estaciones.InsertarFinal(estacion);
    }
    
    
    
}

