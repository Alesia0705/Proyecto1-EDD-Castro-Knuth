/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Clases.Estacion;
import javax.swing.JOptionPane;

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
    
    public boolean grafoVacio(){
        return this.estaciones.EsVacio();
    }

    public void añadirEstacion(Estacion estacion) {
        if (this.buscarEstacion(estacion.getNombre()) == null) {
            estacion.setNumeroEstacion(this.estaciones.getSize());
            this.estaciones.InsertarFinal(estacion);

            JOptionPane.showMessageDialog(null, "Estacion creada con exito.");
        } else {
            JOptionPane.showMessageDialog(null, "La estacion ya existe.");
        }
    }

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

    public void añadirConexion(String nombreEstacion1, String nombreEstacion2) {
        Estacion estacion1 = this.buscarEstacion(nombreEstacion1);
        Estacion estacion2 = this.buscarEstacion(nombreEstacion2);

        if (estacion1 != null && estacion2 != null) {
            estacion1.getListaAd().InsertarFinal(estacion2);
            estacion2.getListaAd().InsertarFinal(estacion1);

            JOptionPane.showMessageDialog(null, "Conexion agregada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Alguna de las ciudades no se encuentra en el grafo");
        }
    }

    public void deleteConexion(String nombreEstacion1, String nombreEstacion2) {
        Estacion estacion1 = this.buscarEstacion(nombreEstacion1);
        Estacion estacion2 = this.buscarEstacion(nombreEstacion2);
        if (estacion1 != null && estacion2 != null) {
            estacion1.getListaAd().EliminarPorReferencia(estacion2);
            estacion2.getListaAd().EliminarPorReferencia(estacion1);

            JOptionPane.showMessageDialog(null, "Conexion eliminada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Alguna de las ciudades no se encuentra en el grafo");
        }

    }

    public ListaSimple obtenerAdyacentes(String nombreEstacion) {
        Estacion estacion = this.buscarEstacion(nombreEstacion);
        if (estacion != null) {
            return estacion.getListaAd();
        } else {
            return null;
        }
    }

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
            return false;
        } else {
            return false;
        }
    }

    public void mostrarGrafo() {
        if (!this.estaciones.EsVacio()) {
            String grafoStr = "";
            for (int i = 0; i < this.estaciones.getSize(); i++) {
                Estacion estacion = (Estacion) this.estaciones.getValor(i);
                grafoStr += estacion.getNombre() + "->" + estacion.TransformarListAdy() + "\n";
            }
            //System.out.println(grafoStr);
            JOptionPane.showMessageDialog(null, grafoStr);
        } else {
            JOptionPane.showMessageDialog(null, "No hay estaciones en el grafo.");
        }
    }

}
