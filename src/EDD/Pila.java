/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Alesia Castro
 */
public class Pila {
    private Nodo cabeza;
    private int size;
    
    //Constructor de la clase
    public void Pila(){
        cabeza = null;
        size = 0;
    }
    
    //Getter and Setter
    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    //Funciones y Metodos de la clase
    
    //Funcion para consultar si la Pila esta vacia
    public boolean esVacia(){
        return cabeza == null;
    }
    
    //Metodo para apilar (agg)
    public void apilar(Object valor){
        Nodo nuevo = new Nodo();
        nuevo.setDato(valor);
        
        if (esVacia()) {
            cabeza = nuevo;
        }else{
            nuevo.setPnext(cabeza);
            cabeza = nuevo;
        }
        size++;
    }
    
    //Metodo para desapilar (delete)
    public void desapilar(){
        if(!esVacia()){
            cabeza = cabeza.getPnext();
            size--;
        }
    }
    
    //Funcion para buscar un elemento en la Pila
    public boolean buscar(Object referencia){
        Nodo aux = cabeza;
        boolean encontrado = false;
        
        while(encontrado != true && aux != null){
            
            if (referencia == aux.getDato()) {
                encontrado = true;
            }
            else{
                aux = aux.getPnext();
            }
        }
        return encontrado;
    }
    
    //Elimina un nodo por su valor
    public void eliminarPorValor(Object referencia){

        if (buscar(referencia)) {
            Nodo pilaAux = null;
            
            while(referencia != cabeza.getDato()){
                
                Nodo temp = new Nodo();
                temp.setDato(cabeza.getDato());
                
                if(pilaAux == null){
                    pilaAux = temp;
                }else{
                    temp.setPnext(pilaAux);
                    pilaAux = temp;
                }
                desapilar();
            }
            desapilar();

            while(pilaAux != null){
                apilar(pilaAux.getDato());
                pilaAux = pilaAux.getPnext();
            }
            pilaAux = null;
        }
    }
    
     public void editar(Object referencia, Object valor){
        if (buscar(referencia)) {
            Nodo pilaAux = null;

            while(referencia != cabeza.getDato()){
                Nodo temp = new Nodo();
                temp.setDato(cabeza.getDato());
                if(pilaAux == null){
                    pilaAux = temp;
                }else{
                    temp.setPnext(pilaAux);
                    pilaAux = temp;
                }
                desapilar();
            }
            cabeza.setDato(valor);
            while(pilaAux != null){
                apilar(pilaAux.getDato());
                pilaAux = pilaAux.getPnext();
            }
            pilaAux = null;
        }
    }
    
    //Destructor
    public void destruir(){
        cabeza = null;
        size = 0;
    }
    
    //Mostrar los elementos de una Pila}
    public void listar(){
        Nodo aux = cabeza;
        String pila = "PILA:\n";
        while(aux != null){
            pila = pila + aux.getDato() + "\n";
            aux = aux.getPnext();
        }
        System.out.println(pila);
    }
}
