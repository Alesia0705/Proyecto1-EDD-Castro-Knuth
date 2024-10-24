/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Clases.Estacion;
import EDD.Grafo;
import EDD.ListaSimple;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

public class GrafoVisualizador extends JFrame {

    private Grafo grafo;
    private Viewer viewer;
    private ViewPanel viewPanel;  // Almacenar el ViewPanel para reutilizarlo

    public GrafoVisualizador(Grafo grafo) {
        this.grafo = grafo;
        setTitle("Visualización de Estaciones");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear el grafo de visualización usando GraphStream
        Graph graph = new SingleGraph("Estaciones");
        inicializarGrafo(graph);

        // Crear el viewer y mostrar el grafo solo si no existe
        if (viewer == null) {
            viewer = graph.display(false);  // Obtiene el viewer sin abrir una nueva ventana
            viewer.enableAutoLayout();
        }

        // Si el panel de visualización no existe, lo creamos
        if (viewPanel == null) {
            viewPanel = (ViewPanel) viewer.getDefaultView();  // Obtén el panel de visualización
            add(viewPanel, BorderLayout.CENTER);  // Añadir el panel de visualización al JFrame
        }

        // Botón para volver
        JButton volverBtn = new JButton("Volver");
        volverBtn.addActionListener(e -> {
            // Detener y cerrar el viewer antes de volver
            cerrarViewer();

            this.dispose();  // Cierra esta ventana
            Menu menu = new Menu();
            menu.setVisible(true);
        });
        add(volverBtn, BorderLayout.SOUTH);
    }

    private void inicializarGrafo(Graph graph) {
        // Primero agregar todos los nodos al grafo
        for (int i = 0; i < grafo.getEstaciones().getSize(); i++) {
            Estacion estacion = (Estacion) grafo.getEstaciones().getValor(i);

            // Crear un nodo para cada estación
            Node node = graph.addNode(estacion.getNombre());
            node.setAttribute("ui.label", estacion.getNombre());

            // Si la estación tiene sucursal, cambiar el color del nodo
            if (estacion.isTieneSucursal()) {
                node.setAttribute("ui.style", "fill-color: red;");  // Cambiar el color a rojo
            } else {
                node.setAttribute("ui.style", "fill-color: green;");  // Color verde por defecto
            }
        }

        // Después de agregar todos los nodos, añadir las conexiones (adyacencias)
        for (int i = 0; i < grafo.getEstaciones().getSize(); i++) {
            Estacion estacion = (Estacion) grafo.getEstaciones().getValor(i);
            ListaSimple adyacentes = estacion.getListaAd();

            for (int j = 0; j < adyacentes.getSize(); j++) {
                Estacion adyacente = (Estacion) adyacentes.getValor(j);

                // Crear aristas (conexiones) si no existen
                String edgeId = estacion.getNombre() + "-" + adyacente.getNombre();
                if (graph.getEdge(edgeId) == null && graph.getEdge(adyacente.getNombre() + "-" + estacion.getNombre()) == null) {
                    graph.addEdge(edgeId, estacion.getNombre(), adyacente.getNombre());
                }
            }

            // También podrías visualizar las conexiones peatonales de forma diferente
            ListaSimple peatonales = estacion.getPeaton();
            for (int j = 0; j < peatonales.getSize(); j++) {
                Estacion peatonal = (Estacion) peatonales.getValor(j);

                String edgeId = estacion.getNombre() + "-" + peatonal.getNombre() + "-peatonal";
                if (graph.getEdge(edgeId) == null) {
                    Edge edge = graph.addEdge(edgeId, estacion.getNombre(), peatonal.getNombre(), true);
                    edge.setAttribute("ui.style", "stroke-mode: dots; stroke-color: blue;");  // Dotted lines for pedestrian connections
                }
            }
        }

        // Estilos básicos para el grafo
        graph.setAttribute("ui.stylesheet",
                "node { text-size: 20px; size: 30px; text-alignment: center; } "
                + "edge { size: 2px; }" // Ajusta el tamaño de las conexiones
        );
    }

    private void cerrarViewer() {
        if (viewer != null) {
            viewer.disableAutoLayout();  // Desactivar el auto-layout
            viewer.close();  // Cerrar el viewer
        }
        if (viewPanel != null) {
            remove(viewPanel);  // Remover el panel de visualización de la ventana
            viewPanel = null;  // Asegurar que el panel se pueda recrear la próxima vez
        }
    }
}
