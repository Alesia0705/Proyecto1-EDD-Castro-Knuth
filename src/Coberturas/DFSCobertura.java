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
 *
 * @author Alesia Castro
 */
public class DFSCobertura extends Cobertura{

    private StringBuilder resultado; // Para almacenar la cobertura que se va calculando

    public DFSCobertura(Grafo grafo, int t) {
        super(grafo, t);
        resultado = new StringBuilder(); // Inicializamos el StringBuilder
    }

    @Override
    public void calcularCobertura(Estacion estacionInicial) {
        if (estacionInicial == null) {
            JOptionPane.showMessageDialog(null, "Estación inicial no puede ser nula.");
            return;
        }

        // Inicializar el resultado
        resultado.append("Calculando cobertura DFS desde la estación: ").append(estacionInicial.getNombre()).append("\n");
        ListaSimple visitadas = new ListaSimple();
        
        // Iniciamos la búsqueda en profundidad
        dfsRecursivo(estacionInicial, visitadas, 0);

        // Mostramos todo el resultado acumulado en un JOptionPane
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    // Método recursivo para realizar DFS
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

        // Obtenemos las estaciones adyacentes
        ListaSimple adyacentes = estacion.getListaAd();
        for (int i = 0; i < adyacentes.getSize(); i++) {
            Estacion adyacente = (Estacion) adyacentes.getValor(i);

            // Si no ha sido visitada, la exploramos
            if (!visitadas.buscar(adyacente)) {
                dfsRecursivo(adyacente, visitadas, distanciaActual + 1);
            }
        }
    }
    
}
