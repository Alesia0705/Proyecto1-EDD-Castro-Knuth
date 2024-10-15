/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import Clases.Estacion;
import Coberturas.BFSCobertura;
import Coberturas.Cobertura;
import Coberturas.DFSCobertura;
import EDD.Grafo;
import EDD.ListaSimple;
import Funciones.helpers;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class GestionGrafo {
    private Grafo grafo;
    private int t;
    private helpers help = new helpers();

    public GestionGrafo(int t) {
        this.grafo = new Grafo();
        this.t = 3;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public void inicializar(ListaSimple estaciones) {
        this.grafo.setEstaciones(estaciones);
    }

    public void actualizarT(String nuevaT) {
        if (help.ValidarNumeros(nuevaT) != -1) {
            int t = help.ValidarNumeros(nuevaT);
            int tVieja = this.t;
            this.setT(t);
            JOptionPane.showMessageDialog(null, "Se actualizo el valor de t de: " + tVieja + " a " + this.t);
        } else {
            JOptionPane.showMessageDialog(null, "El valor ingresado debe ser un entero positivo");
        }
    }

    public void añadirEstacion(String nombreEstacion) {
        Estacion estacion = new Estacion(nombreEstacion);
        grafo.añadirEstacion(estacion);
        JOptionPane.showMessageDialog(null, "Estacion agregada con exito.");
    }

    public void conectarEstacion(String nombreEstacion1, String nombreEstacion2) {
        grafo.añadirConexion(nombreEstacion1, nombreEstacion2);
    }

    public void eliminarEstacion(String nombreEstacion1, String nombreEstacion2) {
        grafo.deleteConexion(nombreEstacion1, nombreEstacion2);
    }

    public void establecerSucursal(String nombreEstacion) {
        Estacion estacion = grafo.buscarEstacion(nombreEstacion);
        if (estacion != null) {
            estacion.setTieneSucursal(true);
            JOptionPane.showMessageDialog(null, "Sucurcal agregada con exito.");
        } else {
            JOptionPane.showMessageDialog(null, "La estacion no existe. Por lo tanro su sucurcal no se pudo agregar.");
        }
    }

    public void removerSucursal(String nombreEstacion) {
        Estacion estacion = grafo.buscarEstacion(nombreEstacion);
        if (estacion != null) {
            estacion.setTieneSucursal(false);
            JOptionPane.showMessageDialog(null, "Sucurcal removida con exito.");
        } else {
            JOptionPane.showMessageDialog(null, "La estacion no existe. Por lo tanro su sucurcal no se pudo remover.");
        }
    }

    public void calcularCoberturaBFS(String nombreEstacionInicial) {
        Estacion estacionInicial = grafo.buscarEstacion(nombreEstacionInicial);
        if (estacionInicial != null) {
            Cobertura cobertura = new BFSCobertura(grafo, t);
            cobertura.calcularCobertura(estacionInicial);
        }
    }

    public void calcularCoberturaDFS(String nombreEstacionInicial) {
        Estacion estacionInicial = grafo.buscarEstacion(nombreEstacionInicial);
        if (estacionInicial != null) {
            Cobertura cobertura = new DFSCobertura(grafo, t);
            cobertura.calcularCobertura(estacionInicial);
        }

    }

    public ListaSimple verEstaciones() {
        if (!this.grafo.grafoVacio()) {
            ListaSimple nombres = new ListaSimple();
            for (int i = 0; i < this.grafo.getEstaciones().getSize(); i++) {
                Estacion estacion = (Estacion) this.grafo.getEstaciones().getValor(i);
                nombres.InsertarFinal(estacion.getNombre());
            }
            return nombres;
        }else{
            return null;
        }
    }
    
     // Nueva función: devolver una lista de los nombres de las estaciones con sucursal
    public ListaSimple verEstacionesConSucursal() {
        ListaSimple conSucursal = new ListaSimple();
        if (!this.grafo.grafoVacio()) {
            for (int i = 0; i < this.grafo.getEstaciones().getSize(); i++) {
                Estacion estacion = (Estacion) this.grafo.getEstaciones().getValor(i);
                if (estacion.isTieneSucursal()) {
                    conSucursal.InsertarFinal(estacion.getNombre());
                }
            }
        }
        return conSucursal;
    }

    // Nueva función: devolver una lista de los nombres de las estaciones sin sucursal
    public ListaSimple verEstacionesSinSucursal() {
        ListaSimple sinSucursal = new ListaSimple();
        if (!this.grafo.grafoVacio()) {
            for (int i = 0; i < this.grafo.getEstaciones().getSize(); i++) {
                Estacion estacion = (Estacion) this.grafo.getEstaciones().getValor(i);
                if (!estacion.isTieneSucursal()) {
                    sinSucursal.InsertarFinal(estacion.getNombre());
                }
            }
        }
        return sinSucursal;
    }
    
     // Nueva función: Verificar si hay cobertura total de todas las estaciones
    public boolean verificarCoberturaTotal() {
        // Lista de estaciones cubiertas
        ListaSimple estacionesCubiertas = new ListaSimple();

        // Iterar sobre todas las estaciones y hacer BFS o DFS desde las estaciones con sucursal
        for (int i = 0; i < grafo.getEstaciones().getSize(); i++) {
            Estacion estacion = (Estacion) grafo.getEstaciones().getValor(i);
            
            // Si la estación tiene una sucursal, calculamos la cobertura desde ahí
            if (estacion.isTieneSucursal()) {
                Cobertura cobertura = new BFSCobertura(grafo, t);  // Puedes cambiar a DFSCobertura si prefiere
                cobertura.marcarCoberturaDesdeSucursal(estacion, estacionesCubiertas);
            }
        }

        // Verificar si todas las estaciones están cubiertas
        for (int i = 0; i < grafo.getEstaciones().getSize(); i++) {
            Estacion estacion = (Estacion) grafo.getEstaciones().getValor(i);
            // Si alguna estación no está en la lista de cubiertas, no hay cobertura total
            if (!estacionesCubiertas.buscar(estacion)) {
                JOptionPane.showMessageDialog(null, "Cobertura incompleta. Estación sin cobertura: " + estacion.getNombre() + "\n" + "Colacar una sucursal en esa estacion ayudaria a cubrir completamente la ciudad");
                return false;  // Si alguna estación no está cubierta, retornar false
            }
        }

        return true;  // Si todas las estaciones están cubiertas, retornar true
    }
    
    public void destruirGestor(){
        this.grafo = new Grafo();
        this.t = 3;
    }
}
