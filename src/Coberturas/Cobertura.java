/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coberturas;

import Clases.Estacion;
import EDD.Grafo;
import EDD.ListaSimple;
/**
 *
 * @author Alesia Castro
 */
public abstract class Cobertura {
    protected Grafo grafo;
    protected int t;

    public Cobertura(Grafo grafo, int t) {
        this.grafo = grafo;
        this.t = t;
    }
    
    public abstract void calcularCobertura(Estacion estacionInicial);

    public void marcarCoberturaDesdeSucursal(Estacion estacion, ListaSimple estacionesCubiertas) {
       
    }
    
}

