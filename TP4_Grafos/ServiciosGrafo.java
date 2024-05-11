package TP4_Grafos;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class ServiciosGrafo<T> {
    /*Esta clase es utilizada para implementar recorrido, obtener camino mas largo, y otro tipo de servicios sobre el grafo */
    private Hashtable<Integer, Integer> tiempoDescubrimiento;
    private Hashtable<Integer, Integer> tiempoFinalizacion;
    private Hashtable<Integer, String> visitados;
    private Queue<Vertice<T>> fila;


    public LinkedList<Integer> obtenerRecorridoMasLargo(GrafoDirigido<T> g, int verticeInicial, int verticeFinal){
        //implementar
        return null;
    }
}
