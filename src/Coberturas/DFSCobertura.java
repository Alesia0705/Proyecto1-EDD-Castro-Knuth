/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coberturas;

import Clases.Estacion;
import EDD.Grafo;
import EDD.ListaSimple;
import javax.swing.JOptionPane;
/**
 * Clase que implementa el algoritmo de búsqueda en profundidad (DFS) para calcular la cobertura en un grafo de estaciones.
 * Extiende la clase `Cobertura` y utiliza un enfoque recursivo para explorar el grafo, almacenando el resultado de la búsqueda en un StringBuilder.
 *
 * @author Alesia Castro
 */
public class DFSCobertura extends Cobertura {

    /**
     * StringBuilder utilizado para almacenar el resultado de la búsqueda en profundidad,
     * concatenando las estaciones visitadas y sus respectivas distancias.
     */
    private StringBuilder resultado;

    /**
     * Constructor que inicializa el grafo, el límite de distancia y crea un StringBuilder para almacenar el resultado.
     *
     * @param grafo El grafo de estaciones.
     * @param t El límite máximo de distancia a considerar en la búsqueda.
     */
    public DFSCobertura(Grafo grafo, int t) {
        super(grafo, t);
        resultado = new StringBuilder();
    }

    /**
     * Calcula la cobertura utilizando una búsqueda en profundidad (DFS) a partir de una estación inicial.
     * Marca las estaciones visitadas y acumula el resultado en el StringBuilder `resultado`.
     *
     * @param estacionInicial La estación desde donde se inicia la búsqueda DFS.
     */
    @Override
    public void calcularCobertura(Estacion estacionInicial) {
        if (estacionInicial == null) {
            JOptionPane.showMessageDialog(null, "Estación inicial no puede ser nula.");
            return;
        }

        // Inicializar el resultado
        resultado.append("Calculando cobertura DFS desde la estación: ")
                .append(estacionInicial.getNombre()).append("\n");
        ListaSimple visitadas = new ListaSimple();

        // Iniciamos la búsqueda en profundidad
        dfsRecursivo(estacionInicial, visitadas, 0);

        // Mostramos todo el resultado acumulado en un JOptionPane
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    // Método recursivo para realizar DFS con soporte para pasos peatonales
    private void dfsRecursivo(Estacion estacion, ListaSimple visitadas, int distanciaActual) {
        // Marcamos la estación como visitada
        visitadas.InsertarFinal(estacion);

        // Agregamos la estación actual y la distancia al resultado
        resultado.append("Estación actual: ").append(estacion.getNombre())
                .append(" (Distancia: ").append(distanciaActual).append(")").append("\n");

        // Si la distancia actual es mayor o igual que t, dejamos de buscar en esta rama
        if (distanciaActual >= t) {
            return;
        }

        // Obtener las estaciones conectadas peatonalmente y explorarlas primero (con t = 0)
        ListaSimple peatonales = estacion.getPeaton();
        for (int i = 0; i < peatonales.getSize(); i++) {
            Estacion peatonal = (Estacion) peatonales.getValor(i);
            // Si la estación peatonal no ha sido visitada, la exploramos
            if (!visitadas.buscar(peatonal)) {
                dfsRecursivo(peatonal, visitadas, distanciaActual); // Misma distancia porque es t = 0
            }
        }

        // Obtenemos las estaciones adyacentes y las exploramos
        ListaSimple adyacentes = estacion.getListaAd();
        for (int i = 0; i < adyacentes.getSize(); i++) {
            Estacion adyacente = (Estacion) adyacentes.getValor(i);

            // Si la estación adyacente no ha sido visitada, la exploramos
            if (!visitadas.buscar(adyacente)) {
                dfsRecursivo(adyacente, visitadas, distanciaActual + 1); // Aumentamos la distancia
            }
        }
    }
}
