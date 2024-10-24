/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coberturas;

import Clases.Estacion;
import EDD.Cola;
import EDD.Grafo;
import EDD.ListaSimple;
import javax.swing.JOptionPane;
/**
 * Clase que implementa el algoritmo de cobertura Breadth-First Search (BFS) para un grafo de estaciones.
 * Extiende la clase abstracta Cobertura y permite calcular la cobertura de estaciones desde una estación inicial,
 * respetando un límite de distancia máximo t.
 * 
 * @author Alesia Castro
 */
public class BFSCobertura extends Cobertura {

    /**
     * Constructor que inicializa el grafo y el límite t para la cobertura BFS.
     * 
     * @param grafo El grafo que contiene las estaciones y conexiones.
     * @param t El límite máximo de distancia para la cobertura.
     */
    public BFSCobertura(Grafo grafo, int t) {
        super(grafo, t);
    }

    /**
     * Método que calcula la cobertura BFS desde una estación inicial, recorriendo
     * las estaciones adyacentes hasta una distancia máxima de t, considerando también
     * las conexiones peatonales con un costo de t = 0.
     * 
     * @param estacionInicial La estación desde la cual se comienza el cálculo de cobertura.
     */
    @Override
    public void calcularCobertura(Estacion estacionInicial) {
        if (estacionInicial == null) {
            JOptionPane.showMessageDialog(null, "Estación inicial no puede ser nula.");
            return;
        }

        String resultado = "Calculando cobertura BFS desde la estación: " + estacionInicial.getNombre() + "\n";

        Cola cola = new Cola();  // Cola personalizada para realizar el BFS
        ListaSimple visitadas = new ListaSimple();  // Lista de estaciones ya visitadas
        Cola distancias = new Cola();  // Cola que almacena las distancias desde la estación inicial

        // Encolar la estación inicial y marcarla como visitada
        cola.enColar(estacionInicial);
        visitadas.InsertarFinal(estacionInicial);
        distancias.enColar(0);  // La estación inicial tiene una distancia de 0

        // Bucle para recorrer las estaciones hasta que no queden más en la cola
        while (!cola.colaVacia()) {
            Estacion actual = (Estacion) cola.desEnColar();  // Desencolar la estación actual
            int distanciaActual = (int) distancias.desEnColar();  // Desencolar la distancia correspondiente

            // Si hemos alcanzado o excedido la distancia máxima t, dejar de explorar esta rama
            if (distanciaActual > t) {
                continue;
            }

            resultado += "Estación actual: " + actual.getNombre() + " (Distancia: " + distanciaActual + ")" + "\n";

            // Explorar primero los pasos peatonales, con t = 0
            ListaSimple peatonales = actual.getPeaton();
            for (int i = 0; i < peatonales.getSize(); i++) {
                Estacion peatonal = (Estacion) peatonales.getValor(i);

                // Si la estación peatonal no ha sido visitada, se encola sin aumentar la distancia
                if (!visitadas.buscar(peatonal)) {
                    cola.enColar(peatonal);
                    visitadas.InsertarFinal(peatonal);
                    distancias.enColar(distanciaActual);  // Misma distancia porque es t = 0
                }
            }

            // Explorar las estaciones adyacentes de la estación actual
            ListaSimple adyacentes = actual.getListaAd();
            for (int i = 0; i < adyacentes.getSize(); i++) {
                Estacion adyacente = (Estacion) adyacentes.getValor(i);

                // Si la estación adyacente no ha sido visitada, se encola con distancia incrementada
                if (!visitadas.buscar(adyacente)) {
                    cola.enColar(adyacente);
                    visitadas.InsertarFinal(adyacente);
                    distancias.enColar(distanciaActual + 1);  // Aumentar la distancia
                }
            }
        }

        resultado += "Cobertura BFS completada hasta una distancia de " + t + " paradas.";
        JOptionPane.showMessageDialog(null, resultado);
    }

    /**
     * Método que marca las estaciones cubiertas desde una estación inicial hasta un máximo de t paradas,
     * añadiendo las estaciones cubiertas a la lista proporcionada. Considera también las conexiones peatonales
     * como si fueran de distancia t = 0.
     * 
     * @param estacionInicial La estación desde donde se empieza a marcar la cobertura.
     * @param estacionesCubiertas Una lista de estaciones que serán marcadas como cubiertas.
     */
    public void marcarCoberturaDesdeSucursal(Estacion estacionInicial, ListaSimple estacionesCubiertas) {
        if (estacionInicial == null) {
            return;
        }

        Cola cola = new Cola();  // Cola para el BFS
        Cola distancias = new Cola();  // Cola que almacena las distancias

        cola.enColar(estacionInicial);
        estacionesCubiertas.InsertarFinal(estacionInicial);  // Marcar la estación inicial como cubierta
        distancias.enColar(0);  // Distancia inicial es 0

        // Bucle para recorrer las estaciones
        while (!cola.colaVacia()) {
            Estacion actual = (Estacion) cola.desEnColar();
            int distanciaActual = (int) distancias.desEnColar();

            // Detener la exploración si se alcanza el límite de distancia
            if (distanciaActual >= t) {
                continue;
            }

            // Explorar primero los pasos peatonales, con t = 0
            ListaSimple peatonales = actual.getPeaton();
            for (int i = 0; i < peatonales.getSize(); i++) {
                Estacion peatonal = (Estacion) peatonales.getValor(i);

                // Si la estación peatonal no ha sido marcada como cubierta, la encolamos
                if (!estacionesCubiertas.buscar(peatonal)) {
                    cola.enColar(peatonal);
                    estacionesCubiertas.InsertarFinal(peatonal);  // Marcar la estación como cubierta
                    distancias.enColar(distanciaActual);  // Mantener la misma distancia porque es t = 0
                }
            }

            // Obtener estaciones adyacentes de la estación actual
            ListaSimple adyacentes = actual.getListaAd();
            for (int i = 0; i < adyacentes.getSize(); i++) {
                Estacion adyacente = (Estacion) adyacentes.getValor(i);

                // Si la estación adyacente no ha sido marcada como cubierta, la encolamos
                if (!estacionesCubiertas.buscar(adyacente)) {
                    cola.enColar(adyacente);
                    estacionesCubiertas.InsertarFinal(adyacente);  // Marcar la estación como cubierta
                    distancias.enColar(distanciaActual + 1);  // Aumentar la distancia
                }
            }
        }
    }
}

