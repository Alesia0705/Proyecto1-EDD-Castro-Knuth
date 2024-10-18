/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

/**
 *
 * @author Victoria Knuth
 */
/**
 * Clase de utilidades (helpers) que proporciona funciones auxiliares para validación de números.
 * Ofrece métodos para verificar si una cadena contiene solo números y convertirla a entero si es válida.
 * 
 * @author Victoria Knuth
 */
public class helpers {

    /**
     * Método privado que valida si una cadena de texto contiene solo caracteres numéricos.
     * 
     * @param num La cadena de texto que se va a validar.
     * @return {@code true} si la cadena contiene solo dígitos numéricos, {@code false} en caso contrario.
     */
    private boolean validarnumeros(String num) {
        return num.matches("[0-9]*");
    }

    /**
     * Método que valida si una cadena contiene solo números, y si es válida, la convierte a un entero.
     * 
     * @param numero La cadena de texto que se va a validar y convertir.
     * @return El valor entero si la cadena es válida, o -1 si no contiene solo números.
     */
    public int ValidarNumeros(String numero) {
        if (validarnumeros(numero) == true) {
            int num = Integer.parseInt(numero);
            return num;
        } else {
            return -1;
        }
    }
}

