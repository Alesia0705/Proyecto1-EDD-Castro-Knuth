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
 *
 * @author Victoria Knuth
 */
public class CargarJSON {
     private ListaSimple estaciones = new ListaSimple(); // Lista de estaciones
    private ListaSimple lineas = new ListaSimple(); // Lista de líneas

    public ListaSimple getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(ListaSimple estaciones) {
        this.estaciones = estaciones;
    }

    public ListaSimple getLineas() {
        return lineas;
    }

    public void setLineas(ListaSimple lineas) {
        this.lineas = lineas;
    }

    // Función que procesa el archivo JSON y crea los objetos de tipo Estacion y Linea
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

                // Verificamos si es un objeto o un arreglo y lo manejamos adecuadamente
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

    // Método auxiliar para obtener las claves de un JsonObject como ListaSimple
    private ListaSimple obtenerClavesDeJsonObject(JsonObject jsonObject) {
        ListaSimple listaClaves = new ListaSimple();
        for (String key : jsonObject.keySet()) {
            listaClaves.InsertarFinal(key);
        }
        return listaClaves;
    }

    // Método auxiliar para procesar las líneas y estaciones
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
                    // Caso de una conexión peatonal (ejemplo: {"Capitolio":"El Silencio"})
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

    // Método auxiliar para obtener una estación existente o crear una nueva
    private Estacion obtenerOcrearEstacion(String nombreEstacion) {
        // Buscar si la estación ya fue creada en la lista de estaciones
        for (int i = 0; i < estaciones.getSize(); i++) {
            Estacion estacion = (Estacion) estaciones.getValor(i);
            if (estacion.getNombre().equals(nombreEstacion)) {
                return estacion;
            }
        }
        // Si no existe, la creamos y la añadimos a la lista de estaciones
        Estacion nuevaEstacion = new Estacion(nombreEstacion);
        estaciones.InsertarFinal(nuevaEstacion);
        return nuevaEstacion;
    }
}
