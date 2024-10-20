/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 * Clase que representa un nodo en una lista enlazada simple. Cada nodo almacena un dato
 * y una referencia al siguiente nodo en la lista (enlace o puntero).
 * 
 * Esta clase se utiliza como elemento base para la implementación de estructuras de datos
 * como listas enlazadas simples.
 * 
 * @author Alesia Castro
 */
public class Nodo {
    
    // Atributos
    private Object dato; // Almacena el valor del nodo
    private Nodo pnext;  // Referencia al siguiente nodo en la lista

    /**
     * Constructor por defecto. Inicializa el nodo con valor y enlace nulos.
     */
    public Nodo() {
        this.dato = null;
        this.pnext = null;
    }

    /**
     * Constructor que inicializa el nodo con un valor específico y sin enlace al siguiente nodo.
     * 
     * @param dato El valor que almacenará el nodo.
     */
    public Nodo(Object dato) {
        this.dato = dato;
        this.pnext = null;
    }

    /**
     * Constructor que inicializa el nodo con un valor y una referencia al siguiente nodo.
     * 
     * @param dato El valor que almacenará el nodo.
     * @param node El nodo siguiente al que estará enlazado este nodo.
     */
    public Nodo(Object dato, Nodo node) {
        this.dato = dato;
        this.pnext = node;
    }

    /**
     * Obtiene el valor almacenado en el nodo.
     * 
     * @return El valor del nodo.
     */
    public Object getDato() {
        return dato;
    }

    /**
     * Establece un nuevo valor para el nodo.
     * 
     * @param dato El nuevo valor que se asignará al nodo.
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     * Obtiene el nodo al que está enlazado este nodo (el siguiente nodo en la lista).
     * 
     * @return El siguiente nodo.
     */
    public Nodo getPnext() {
        return pnext;
    }

    /**
     * Establece el nodo al que se enlazará este nodo (el siguiente nodo en la lista).
     * 
     * @param pnext El nodo siguiente al que se enlazará este nodo.
     */
    public void setPnext(Nodo pnext) {
        this.pnext = pnext;
    }
}
