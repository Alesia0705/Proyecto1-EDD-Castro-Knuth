/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import Clases.Estacion;
import Clases.Linea;
import EDD.ListaSimple;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que se encarga de procesar un archivo JSON que contiene una red de transporte,
 * creando los objetos de tipo Estacion y Linea correspondientes.
 * Esta clase permite cargar la información de un archivo JSON y representarla en listas
 * de estaciones y líneas.
 * 
 * @author Victoria Knuth
 */
public class CargarJSON {

    private ListaSimple estaciones = new ListaSimple(); // Lista de estaciones
    private ListaSimple lineas = new ListaSimple();     // Lista de líneas

    /**
     * Obtiene la lista de estaciones procesadas desde el archivo JSON.
     * 
     * @return La lista de estaciones.
     */
    public ListaSimple getEstaciones() {
        return estaciones;
    }

    /**
     * Establece la lista de estaciones.
     * 
     * @param estaciones La nueva lista de estaciones.
     */
    public void setEstaciones(ListaSimple estaciones) {
        this.estaciones = estaciones;
    }

    /**
     * Obtiene la lista de líneas procesadas desde el archivo JSON.
     * 
     * @return La lista de líneas.
     */
    public ListaSimple getLineas() {
        return lineas;
    }

    /**
     * Establece la lista de líneas.
     * 
     * @param lineas La nueva lista de líneas.
     */
    public void setLineas(ListaSimple lineas) {
        this.lineas = lineas;
    }

    /**
     * Procesa un archivo JSON que contiene información sobre redes de transporte, creando
     * las estaciones y líneas correspondientes. 
     * Cada red de transporte en el archivo JSON se puede organizar como un objeto o un array.
     * 
     * @param rutaArchivo La ruta del archivo JSON a procesar.
     */
    public void procesarRedTransporteJSON(String rutaArchivo) {
        try {
            // Leer el archivo JSON usando Gson
            Gson gson = new Gson();
            JsonObject redTransporteData = gson.fromJson(new FileReader(rutaArchivo), JsonObject.class);

            // Obtener los nombres de las redes de transporte (claves principales)
            ListaSimple nombresRedes = obtenerClavesDeJsonObject(redTransporteData);

            // Iterar sobre cada red de transporte
            for (int i = 0; i < nombresRedes.getSize(); i++) {
                String nombreRed = (String) nombresRedes.getValor(i);
                JsonElement redElement = redTransporteData.get(nombreRed);

                // Verificar si es un objeto o un array y procesarlo
                if (redElement.isJsonObject()) {
                    JsonObject lineasObject = redElement.getAsJsonObject();
                    procesarLineas(lineasObject);
                } else if (redElement.isJsonArray()) {
                    JsonArray lineasArray = redElement.getAsJsonArray();
                    for (JsonElement elementoLinea : lineasArray) {
                        if (elementoLinea.isJsonObject()) {
                            JsonObject lineaObject = elementoLinea.getAsJsonObject();
                            procesarLineas(lineaObject);  // Procesar cada objeto de línea
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método auxiliar que obtiene las claves de un JsonObject y las devuelve como una ListaSimple.
     * 
     * @param jsonObject El objeto JSON del cual se obtendrán las claves.
     * @return Una ListaSimple que contiene las claves del JsonObject.
     */
    private ListaSimple obtenerClavesDeJsonObject(JsonObject jsonObject) {
        ListaSimple listaClaves = new ListaSimple();
        for (String key : jsonObject.keySet()) {
            listaClaves.InsertarFinal(key);
        }
        return listaClaves;
    }

    /**
     * Método que procesa las líneas de un objeto JSON y crea las estaciones adyacentes y peatonales.
     * También asigna las estaciones procesadas a las líneas correspondientes.
     * 
     * @param lineasObject El objeto JSON que contiene las líneas y sus estaciones.
     */
    private void procesarLineas(JsonObject lineasObject) {
        // Obtener las claves de las líneas
        ListaSimple nombresLineas = obtenerClavesDeJsonObject(lineasObject);

        for (int i = 0; i < nombresLineas.getSize(); i++) {
            String nombreLinea = (String) nombresLineas.getValor(i);
            JsonArray estacionesArray = lineasObject.getAsJsonArray(nombreLinea);

            // Crear la línea
            Linea linea = new Linea(nombreLinea);
            Estacion estacionAnterior = null;  // Para enlazar adyacencias entre estaciones consecutivas
            Estacion estacionActual;

            // Procesar cada estación de la línea
            for (JsonElement estacionElement : estacionesArray) {
                if (estacionElement.isJsonPrimitive()) {
                    // Caso de una estación sin conexión peatonal
                    String nombreEstacion = estacionElement.getAsString();
                    estacionActual = obtenerOcrearEstacion(nombreEstacion);
                    linea.getEstaciones().InsertarFinal(estacionActual); // Añadir estación a la línea

                    // Si hay una estación anterior, hacerlas adyacentes
                    if (estacionAnterior != null) {
                        estacionAnterior.getListaAd().InsertarFinal(estacionActual);
                        estacionActual.getListaAd().InsertarFinal(estacionAnterior);
                    }

                    // La estación actual se convierte en la anterior para el próximo ciclo
                    estacionAnterior = estacionActual;

                } else if (estacionElement.isJsonObject()) {
                    // Caso de una conexión peatonal
                    JsonObject conexionPeatonal = estacionElement.getAsJsonObject();
                    ListaSimple clavesPeatonales = obtenerClavesDeJsonObject(conexionPeatonal);

                    for (int j = 0; j < clavesPeatonales.getSize(); j++) {
                        String estacion1 = (String) clavesPeatonales.getValor(j);
                        String estacion2 = conexionPeatonal.get(estacion1).getAsString();

                        // Obtener o crear las estaciones
                        Estacion e1 = obtenerOcrearEstacion(estacion1);
                        Estacion e2 = obtenerOcrearEstacion(estacion2);

                        // Añadirlas como adyacentes en las listas peatonales
                        e1.getPeaton().InsertarFinal(e2); // Añadir conexión peatonal
                        e2.getPeaton().InsertarFinal(e1); // Conexión en ambos sentidos

                        // Añadir ambas estaciones a la línea
                        linea.getEstaciones().InsertarFinal(e1);

                        // Establecer también la adyacencia lógica entre las estaciones de la misma línea
                        if (estacionAnterior != null) {
                            estacionAnterior.getListaAd().InsertarFinal(e1);
                            e1.getListaAd().InsertarFinal(estacionAnterior);
                        }
                        estacionAnterior = e1; // La estación siguiente se convierte en la anterior
                    }
                }
            }

            // Añadir la línea completa a la lista de líneas
            lineas.InsertarFinal(linea);
        }
    }

    /**
     * Método auxiliar que busca una estación existente en la lista o crea una nueva si no existe.
     * 
     * @param nombreEstacion El nombre de la estación que se desea buscar o crear.
     * @return La estación existente o una nueva estación si no fue encontrada.
     */
    private Estacion obtenerOcrearEstacion(String nombreEstacion) {
        // Buscar si la estación ya fue creada en la lista de estaciones
        for (int i = 0; i < estaciones.getSize(); i++) {
            Estacion estacion = (Estacion) estaciones.getValor(i);
            if (estacion.getNombre().equals(nombreEstacion)) {
                return estacion;
            }
        }
        // Si no existe, crear una nueva estación y añadirla a la lista
        Estacion nuevaEstacion = new Estacion(nombreEstacion);
        estaciones.InsertarFinal(nuevaEstacion);
        return nuevaEstacion;
    }
}
