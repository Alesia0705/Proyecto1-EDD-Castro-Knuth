/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 * Clase que implementa una cola (queue) simple mediante una estructura de nodos enlazados.
 * Esta clase permite encolar y desencolar elementos de manera secuencial,
 * siguiendo el principio FIFO (First In, First Out).
 * 
 * Cada nodo contiene un dato y una referencia al siguiente nodo en la cola.
 * 
 * @author Alesia Castro
 */
public class Cola {

    private Nodo cabeza; // El primer nodo en la cola
    private Nodo cola;   // El último nodo en la cola
    private int size;    // Tamaño de la cola

    /**
     * Constructor de la clase Cola. Inicializa una cola vacía.
     */
    public Cola() {
        this.cabeza = null;
        this.cola = null;
        this.size = 0;
    }

    /**
     * Obtiene el nodo cabeza (primer elemento) de la cola.
     * 
     * @return El nodo cabeza de la cola.
     */
    public Nodo getCabeza() {
        return cabeza;
    }

    /**
     * Establece el nodo cabeza de la cola.
     * 
     * @param cabeza El nodo cabeza a establecer.
     */
    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    /**
     * Obtiene el nodo cola (último elemento) de la cola.
     * 
     * @return El nodo cola de la cola.
     */
    public Nodo getCola() {
        return cola;
    }

    /**
     * Establece el nodo cola de la cola.
     * 
     * @param cola El nodo cola a establecer.
     */
    public void setCola(Nodo cola) {
        this.cola = cola;
    }

    /**
     * Obtiene el tamaño actual de la cola.
     * 
     * @return El tamaño de la cola.
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño de la cola.
     * 
     * @param size El tamaño a establecer.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Verifica si la cola está vacía.
     * 
     * @return {@code true} si la cola está vacía, {@code false} en caso contrario.
     */
    public boolean colaVacia() {
        return this.cabeza == null;
    }

    /**
     * Encola (agrega) un nuevo elemento al final de la cola.
     * 
     * @param dato El objeto que se va a encolar.
     */
    public void enColar(Object dato) {
        Nodo pNew = new Nodo(dato);
        if (this.colaVacia()) {
            this.setCabeza(pNew);
            this.setCola(pNew);
        } else {
            this.cola.setPnext(pNew);
            this.setCola(pNew);
        }
        size++;
    }

    /**
     * Desencola (remueve) el primer elemento de la cola y lo devuelve.
     * 
     * @return El objeto que fue desencolado.
     */
    public Object desEnColar() {
        if (this.colaVacia()) {
            return null;  // Si la cola está vacía, no hay nada que desencolar
        } else {
            Object quitar = this.cabeza.getDato();
            this.setCabeza(this.cabeza.getPnext());
            if (this.cabeza == null) {
                this.setCola(null);  // Si la cabeza es nula, la cola también debe serlo
            }
            size--;
            return quitar;
        }
    }

    /**
     * Destruye la cola, eliminando todos sus elementos.
     * Después de llamar a este método, la cola estará vacía.
     */
    public void destruir() {
        cabeza = null;
        cola = null;
        size = 0;
    }

    /**
     * Muestra los elementos actuales de la cola en la consola.
     * Los elementos se muestran en el orden en el que fueron encolados.
     */
    public void listar() {
        Nodo aux = cabeza;
        String pila = "COLA:\n";
        while (aux != null) {
            pila = pila + aux.getDato() + "\n";
            aux = aux.getPnext();
        }
        System.out.println(pila);
    }
}