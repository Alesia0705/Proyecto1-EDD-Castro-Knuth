/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import javax.swing.JOptionPane;

/**
 * Clase que implementa una lista enlazada simple, donde cada nodo apunta al siguiente.
 * Proporciona operaciones para insertar, eliminar, buscar, editar y consultar nodos en la lista.
 * 
 * La lista permite almacenar cualquier tipo de objeto y gestiona la memoria de forma dinámica.
 * 
 * @author Alesia Castro
 */
public class ListaSimple {

    private Nodo pFirst; // Nodo que apunta al primer elemento de la lista
    private int size;    // Tamaño de la lista

    /**
     * Constructor que inicializa una lista vacía.
     */
    public ListaSimple() {
        this.pFirst = null;
        this.size = 0;
    }

    /**
     * Devuelve el nodo que es el primer elemento de la lista.
     * 
     * @return El primer nodo de la lista.
     */
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     * Establece el primer nodo de la lista.
     * 
     * @param pFirst El nuevo primer nodo de la lista.
     */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Devuelve el tamaño actual de la lista.
     * 
     * @return El tamaño de la lista.
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño de la lista.
     * 
     * @param size El nuevo tamaño de la lista.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Verifica si la lista está vacía.
     * 
     * @return {@code true} si la lista no contiene elementos, {@code false} en caso contrario.
     */
    public boolean EsVacio() {
        return this.pFirst == null;
    }

    /**
     * Inserta un nuevo elemento al inicio de la lista.
     * 
     * @param dato El dato que se va a insertar.
     */
    public void InsertarInicio(Object dato) {
        Nodo pNew = new Nodo();
        pNew.setDato(dato);

        if (EsVacio()) {
            this.pFirst = pNew;
            this.pFirst.setPnext(null);
        } else {
            pNew.setPnext(pFirst);
            pFirst = pNew;
        }
        size++;
    }

    /**
     * Inserta un nuevo elemento al final de la lista.
     * 
     * @param dato El dato que se va a insertar.
     */
    public void InsertarFinal(Object dato) {
        Nodo pNew = new Nodo(dato);
        if (EsVacio()) {
            pFirst = pNew;
        } else {
            Nodo aux = pFirst;
            while (aux.getPnext() != null) {
                aux = aux.getPnext();
            }
            aux.setPnext(pNew);
        }
        size++;
    }

    /**
     * Inserta un nuevo elemento en una posición específica de la lista.
     * 
     * @param posicion La posición en la cual insertar el nuevo elemento.
     * @param valor El valor del nuevo elemento.
     */
    public void insertarPorPosicion(int posicion, Object valor) {
        if (posicion >= 0 && posicion < size) {
            Nodo nuevo = new Nodo(valor);
            if (posicion == 0) {
                nuevo.setPnext(pFirst);
                pFirst = nuevo;
            } else {
                Nodo aux = pFirst;
                for (int i = 0; i < posicion - 1; i++) {
                    aux = aux.getPnext();
                }
                Nodo siguiente = aux.getPnext();
                aux.setPnext(nuevo);
                nuevo.setPnext(siguiente);
            }
            size++;
        }
    }

    /**
     * Inserta un nuevo elemento después de un nodo de referencia.
     * 
     * @param ref El nodo de referencia.
     * @param valor El valor del nuevo nodo a insertar.
     */
    public void insertarPorReferencia(Object ref, Object valor) {
        Nodo nuevo = new Nodo();
        nuevo.setDato(valor);

        if (!EsVacio() && buscar(ref)) {
            Nodo aux = pFirst;
            while (aux.getDato() != ref) {
                aux = aux.getPnext();
            }
            Nodo siguiente = aux.getPnext();
            aux.setPnext(nuevo);
            nuevo.setPnext(siguiente);
            size++;
        }
    }

    /**
     * Transforma la lista en una representación de cadena de texto.
     * 
     * @return Una cadena que representa los elementos de la lista.
     */
    public String Transformar() {
        if (!EsVacio()) {
            Nodo aux = pFirst;
            StringBuilder expresion = new StringBuilder();
            for (int i = 0; i < size; i++) {
                expresion.append(aux.getDato().toString()).append("\n");
                aux = aux.getPnext();
            }
            return expresion.toString();
        }
        return "Lista vacía";
    }

    /**
     * Muestra los elementos de la lista en un cuadro de diálogo y en la consola.
     */
    public void mostrar() {
        if (!EsVacio()) {
            Nodo aux = pFirst;
            StringBuilder expresion = new StringBuilder();
            while (aux != null) {
                expresion.append(aux.getDato().toString()).append("\n");
                aux = aux.getPnext();
            }
            JOptionPane.showMessageDialog(null, expresion.toString());
            System.out.println(expresion);
        } else {
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        }
    }

    /**
     * Elimina el primer elemento de la lista.
     * 
     * @return {@code true} si se eliminó correctamente, {@code false} si la lista está vacía.
     */
    public boolean Eliminar_Inicio() {
        if (!EsVacio()) {
            pFirst = pFirst.getPnext();
            size--;
            return true;
        }
        return false;
    }

    /**
     * Elimina el último elemento de la lista.
     */
    public void Eliminar_Final() {
        if (!EsVacio()) {
            if (size == 1) {
                eliminar();
            } else {
                Nodo aux = pFirst;
                while (aux.getPnext().getPnext() != null) {
                    aux = aux.getPnext();
                }
                aux.setPnext(null);
                size--;
            }
        }
    }

    /**
     * Elimina un nodo por referencia a su valor.
     * 
     * @param referencia El valor del nodo a eliminar.
     */
    public void EliminarPorReferencia(Object referencia) {
        if (buscar(referencia)) {
            if (pFirst.getDato() == referencia) {
                pFirst = pFirst.getPnext();
            } else {
                Nodo aux = pFirst;
                while (aux.getPnext().getDato() != referencia) {
                    aux = aux.getPnext();
                }
                Nodo siguiente = aux.getPnext().getPnext();
                aux.setPnext(siguiente);
            }
            size--;
        }
    }

    /**
     * Elimina un nodo en una posición específica.
     * 
     * @param posicion La posición del nodo a eliminar.
     */
    public void EliminarPorPosicion(int posicion) {
        if (posicion >= 0 && posicion < size) {
            if (posicion == 0) {
                pFirst = pFirst.getPnext();
            } else {
                Nodo aux = pFirst;
                for (int i = 0; i < posicion - 1; i++) {
                    aux = aux.getPnext();
                }
                aux.setPnext(aux.getPnext().getPnext());
            }
            size--;
        }
    }

    /**
     * Edita el valor de un nodo que tiene una referencia específica.
     * 
     * @param referencia La referencia del nodo a editar.
     * @param dato El nuevo valor del nodo.
     */
    public void editarPorReferencia(Object referencia, Object dato) {
        if (buscar(referencia)) {
            Nodo aux = pFirst;
            while (aux.getDato() != referencia) {
                aux = aux.getPnext();
            }
            aux.setDato(dato);
        }
    }

    /**
     * Edita el valor de un nodo en una posición específica.
     * 
     * @param posicion La posición del nodo a editar.
     * @param dato El nuevo valor del nodo.
     */
    public void editarPorPosicion(int posicion, Object dato) {
        if (posicion >= 0 && posicion < size) {
            Nodo aux = pFirst;
            for (int i = 0; i < posicion; i++) {
                aux = aux.getPnext();
            }
            aux.setDato(dato);
        }
    }

    /**
     * Obtiene el valor de un nodo en una posición específica.
     * 
     * @param posicion La posición del nodo.
     * @return El valor del nodo o {@code null} si la posición es inválida.
     */
    public Object getValor(int posicion) {
        if (posicion >= 0 && posicion < size) {
            Nodo aux = pFirst;
            for (int i = 0; i < posicion; i++) {
                aux = aux.getPnext();
            }
            return aux.getDato();
        }
        return null;
    }

    /**
     * Obtiene el nodo en una posición específica.
     * 
     * @param posicion La posición del nodo.
     * @return El nodo o {@code null} si la posición es inválida.
     */
    public Nodo getNodo(int posicion) {
        if (posicion >= 0 && posicion < size) {
            Nodo aux = pFirst;
            for (int i = 0; i < posicion; i++) {
                aux = aux.getPnext();
            }
            return aux;
        }
        return null;
    }

    /**
     * Obtiene la posición de un nodo en la lista.
     * 
     * @param nodito El nodo cuya posición se desea obtener.
     * @return La posición del nodo o {@code -1} si no se encuentra en la lista.
     */
    public int getIndex(Nodo nodito) {
        if (!EsVacio()) {
            Nodo aux = pFirst;
            int count = 0;
            while (aux != null) {
                if (nodito == aux) {
                    return count;
                }
                count++;
                aux = aux.getPnext();
            }
        }
        return -1;
    }

    /**
     * Obtiene la posición de un elemento en la lista según su valor.
     * 
     * @param referencia El valor del nodo a buscar.
     * @return La posición del nodo o {@code -1} si no se encuentra.
     */
    public int getPosicion(Object referencia) {
        if (buscar(referencia)) {
            Nodo aux = pFirst;
            int cont = 0;
            while (referencia != aux.getDato()) {
                cont++;
                aux = aux.getPnext();
            }
            return cont;
        }
        return -1;
    }

    /**
     * Busca un nodo en la lista por su valor.
     * 
     * @param referencia El valor del nodo a buscar.
     * @return {@code true} si se encuentra el nodo, {@code false} en caso contrario.
     */
    public boolean buscar(Object referencia) {
        Nodo aux = pFirst;
        while (aux != null) {
            if (referencia == aux.getDato()) {
                return true;
            }
            aux = aux.getPnext();
        }
        return false;
    }

    /**
     * Elimina todos los elementos de la lista, dejándola vacía.
     */
    public void eliminar() {
        pFirst = null;
        size = 0;
    }
}
