/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coberturas;

import Clases.Estacion;
import EDD.Grafo;
import EDD.ListaSimple;
/**
 * Clase abstracta que representa un algoritmo de cobertura en un grafo de estaciones. 
 * Esta clase proporciona una estructura básica para calcular la cobertura de un conjunto de estaciones 
 * a partir de una estación inicial, considerando un límite de distancia máximo.
 *
 * @author Alesia Castro
 */
public abstract class Cobertura {
    /**
     * El grafo que representa el sistema de estaciones y sus conexiones.
     */
    protected Grafo grafo;

    /**
     * El límite máximo de distancia a considerar para la cobertura.
     */
    protected int t;

    /**
     * Constructor que inicializa el grafo y el límite de distancia.
     *
     * @param grafo El grafo de estaciones.
     * @param t El límite máximo de distancia.
     */
    public Cobertura(Grafo grafo, int t) {
        this.grafo = grafo;
        this.t = t;
    }

    /**
     * Método abstracto que calcula la cobertura a partir de una estación inicial.
     * La implementación específica del algoritmo de cobertura variará según la subclase.
     *
     * @param estacionInicial La estación desde la cual se inicia el cálculo.
     */
    public abstract void calcularCobertura(Estacion estacionInicial);

    /**
     * Marca las estaciones cubiertas desde una estación dada, agregándolas a una lista.
     * Este método puede ser utilizado por las subclases para implementar funcionalidades adicionales.
     *
     * @param estacion La estación desde donde se inicia el marcado.
     * @param estacionesCubiertas La lista donde se almacenarán las estaciones cubiertas.
     */
    public void marcarCoberturaDesdeSucursal(Estacion estacion, ListaSimple estacionesCubiertas) {
 
    }
}

