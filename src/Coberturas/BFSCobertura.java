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
 *
 * @author Alesia Castro
 */
public class BFSCobertura extends Cobertura{

    // Constructor que inicializa el grafo y el límite t para la cobertura BFS
    public BFSCobertura(Grafo grafo, int t) {
        super(grafo, t);
    }

    @Override
    public void calcularCobertura(Estacion estacionInicial) {
        if (estacionInicial == null) {
            JOptionPane.showMessageDialog(null,  "Estación inicial no puede ser nula.");
            return;
        }

        String resultado = "Calculando cobertura BFS desde la estación: " + estacionInicial.getNombre();

        Cola cola = new Cola();  // Usamos la clase Cola personalizada
        ListaSimple visitadas = new ListaSimple();  // Lista de estaciones visitadas
        Cola distancias = new Cola();  // Lista que almacena las distancias desde la estación inicial

        // Encolar la estación inicial y marcarla como visitada
        cola.enColar(estacionInicial);
        visitadas.InsertarFinal(estacionInicial);
        distancias.enColar(0);  // La estación inicial tiene distancia 0

        // Mientras haya estaciones en la cola
        while (!cola.colaVacia()) {
            Estacion actual = (Estacion) cola.desEnColar();  // Desencolamos la estación actual
            int distanciaActual = (int) distancias.desEnColar();  // Desencolamos la distancia correspondiente

            // Si hemos alcanzado la distancia máxima t, dejamos de explorar más allá
            if (distanciaActual > t) {
                continue;
            }

            resultado += "Estación actual: " + actual.getNombre() + " (Distancia: " + distanciaActual + ")" + "\n";

            // Obtener las estaciones adyacentes
            ListaSimple adyacentes = actual.getListaAd();
            for (int i = 0; i < adyacentes.getSize(); i++) {
                Estacion adyacente = (Estacion) adyacentes.getValor(i);

                // Si la estación adyacente no ha sido visitada, la encolamos
                if (!visitadas.buscar(adyacente)) {
                    cola.enColar(adyacente);  // Encolamos la estación adyacente
                    visitadas.InsertarFinal(adyacente);  // Marcamos como visitada
                    distancias.enColar(distanciaActual + 1);  // Aumentamos la distancia
                }
            }
        }

        resultado += "Cobertura BFS completada hasta una distancia de " + t + " paradas.";
        JOptionPane.showMessageDialog(null, resultado);
        
    }
    
    public void marcarCoberturaDesdeSucursal(Estacion estacionInicial, ListaSimple estacionesCubiertas) {
        if (estacionInicial == null) {
            return;
        }

        Cola cola = new Cola();
        Cola distancias = new Cola();

        cola.enColar(estacionInicial);
        estacionesCubiertas.InsertarFinal(estacionInicial);  // Marcar la estación inicial como cubierta
        distancias.enColar(0);

        while (!cola.colaVacia()) {
            Estacion actual = (Estacion) cola.desEnColar();
            int distanciaActual = (int) distancias.desEnColar();

            if (distanciaActual >= t) {
                continue;
            }

            ListaSimple adyacentes = actual.getListaAd();
            for (int i = 0; i < adyacentes.getSize(); i++) {
                Estacion adyacente = (Estacion) adyacentes.getValor(i);

                // Si la estación adyacente no ha sido cubierta, la marcamos
                if (!estacionesCubiertas.buscar(adyacente)) {
                    cola.enColar(adyacente);
                    estacionesCubiertas.InsertarFinal(adyacente);  // Marcar la estación como cubierta
                    distancias.enColar(distanciaActual + 1);
                }
            }
        }
    }
    
}
