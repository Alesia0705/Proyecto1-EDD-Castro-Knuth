/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Clases.Estacion;
import javax.swing.JOptionPane;

/**
 * Clase que representa un grafo no dirigido de estaciones, donde cada estación puede tener conexiones
 * adyacentes a otras estaciones. Proporciona métodos para añadir, buscar, conectar y eliminar estaciones,
 * además de verificar conexiones entre ellas.
 * 
 * El grafo utiliza una lista enlazada (ListaSimple) para almacenar las estaciones y sus conexiones.
 * 
 * @author Alesia Castro
 */
public class Grafo {

    private ListaSimple estaciones;  // Lista de estaciones del grafo

    /**
     * Constructor por defecto que inicializa un grafo vacío.
     */
    public Grafo() {
        this.estaciones = new ListaSimple();
    }

    /**
     * Constructor que inicializa el grafo con una lista de estaciones existente.
     * 
     * @param estaciones La lista de estaciones iniciales.
     */
    public Grafo(ListaSimple estaciones) {
        this.estaciones = estaciones;
    }

    /**
     * Obtiene la lista de estaciones en el grafo.
     * 
     * @return La lista de estaciones del grafo.
     */
    public ListaSimple getEstaciones() {
        return estaciones;
    }

    /**
     * Establece una lista de estaciones para el grafo.
     * 
     * @param estaciones La nueva lista de estaciones.
     */
    public void setEstaciones(ListaSimple estaciones) {
        this.estaciones = estaciones;
    }

    /**
     * Verifica si el grafo está vacío.
     * 
     * @return {@code true} si el grafo no tiene estaciones, {@code false} en caso contrario.
     */
    public boolean grafoVacio() {
        return this.estaciones.EsVacio();
    }

    /**
     * Añade una nueva estación al grafo si no existe ya una estación con el mismo nombre.
     * 
     * @param estacion La estación que se desea añadir.
     */
    public void añadirEstacion(Estacion estacion) {
        if (this.buscarEstacion(estacion.getNombre()) == null) {
            estacion.setNumeroEstacion(this.estaciones.getSize());
            this.estaciones.InsertarFinal(estacion);
            JOptionPane.showMessageDialog(null, "Estación creada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "La estación ya existe.");
        }
    }

    /**
     * Busca una estación en el grafo por su nombre.
     * 
     * @param nombre El nombre de la estación a buscar.
     * @return La estación encontrada, o {@code null} si no existe.
     */
    public Estacion buscarEstacion(String nombre) {
        if (!this.estaciones.EsVacio()) {
            for (int i = 0; i < this.estaciones.getSize(); i++) {
                Estacion estacion = (Estacion) this.estaciones.getValor(i);
                if (estacion.getNombre().equalsIgnoreCase(nombre)) {
                    return estacion;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    /**
     * Añade una conexión entre dos estaciones existentes en el grafo.
     * 
     * @param nombreEstacion1 El nombre de la primera estación.
     * @param nombreEstacion2 El nombre de la segunda estación.
     */
    public void añadirConexion(String nombreEstacion1, String nombreEstacion2) {
        Estacion estacion1 = this.buscarEstacion(nombreEstacion1);
        Estacion estacion2 = this.buscarEstacion(nombreEstacion2);

        if (estacion1 != null && estacion2 != null) {
            estacion1.getListaAd().InsertarFinal(estacion2);
            estacion2.getListaAd().InsertarFinal(estacion1);
            JOptionPane.showMessageDialog(null, "Conexión agregada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Alguna de las estaciones no se encuentra en el grafo.");
        }
    }

    /**
     * Elimina la conexión entre dos estaciones si existe.
     * 
     * @param nombreEstacion1 El nombre de la primera estación.
     * @param nombreEstacion2 El nombre de la segunda estación.
     */
    public void deleteConexion(String nombreEstacion1, String nombreEstacion2) {
        Estacion estacion1 = this.buscarEstacion(nombreEstacion1);
        Estacion estacion2 = this.buscarEstacion(nombreEstacion2);
        
        if (estacion1 != null && estacion2 != null) {
            estacion1.getListaAd().EliminarPorReferencia(estacion2);
            estacion2.getListaAd().EliminarPorReferencia(estacion1);
            JOptionPane.showMessageDialog(null, "Conexión eliminada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Alguna de las estaciones no se encuentra en el grafo.");
        }
    }

    /**
     * Obtiene las estaciones adyacentes a una estación específica.
     * 
     * @param nombreEstacion El nombre de la estación para la cual se desea obtener las adyacentes.
     * @return La lista de estaciones adyacentes, o {@code null} si la estación no existe.
     */
    public ListaSimple obtenerAdyacentes(String nombreEstacion) {
        Estacion estacion = this.buscarEstacion(nombreEstacion);
        if (estacion != null) {
            return estacion.getListaAd();
        } else {
            return null;
        }
    }

    /**
     * Verifica si dos estaciones están conectadas directamente.
     * 
     * @param nombreEstacion1 El nombre de la primera estación.
     * @param nombreEstacion2 El nombre de la segunda estación.
     * @return {@code true} si las estaciones están conectadas, {@code false} en caso contrario.
     */
    public boolean estanConectadas(String nombreEstacion1, String nombreEstacion2) {
        Estacion estacion1 = this.buscarEstacion(nombreEstacion1);
        Estacion estacion2 = this.buscarEstacion(nombreEstacion2);

        if (estacion1 != null && estacion2 != null) {
            ListaSimple adyacentes = estacion1.getListaAd();
            for (int i = 0; i < adyacentes.getSize(); i++) {
                if (adyacentes.getValor(i) == estacion2) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Muestra todas las estaciones del grafo y sus conexiones adyacentes.
     * Si el grafo está vacío, muestra un mensaje indicando que no hay estaciones.
     */
    public void mostrarGrafo() {
        if (!this.estaciones.EsVacio()) {
            String grafoStr = "";
            for (int i = 0; i < this.estaciones.getSize(); i++) {
                Estacion estacion = (Estacion) this.estaciones.getValor(i);
                grafoStr += estacion.getNombre() + "->" + estacion.TransformarListAdy() + "\n";
            }
            JOptionPane.showMessageDialog(null, grafoStr);
        } else {
            JOptionPane.showMessageDialog(null, "No hay estaciones en el grafo.");
        }
    }
}