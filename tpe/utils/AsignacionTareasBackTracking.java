package tpe.utils;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

import tpe.Procesador;
import tpe.Tarea;

public class AsignacionTareasBackTracking {
    Integer tiempoX;
    Estado mejorSolucion;
    Estado estadoInicial;
    LinkedList<Tarea> tareasDisponibles;
    

    public AsignacionTareasBackTracking(HashMap<String, Procesador> procesadores, HashMap<String, Tarea>tareas, Integer tiempoMaxEjecucion) {
        this.tareasDisponibles = new LinkedList<Tarea>(tareas.values());
        this.tiempoX = tiempoMaxEjecucion;
        this.mejorSolucion = null;
        this.estadoInicial = new Estado(procesadores);
    }
    

    public void asignarTareas() {
        backtracking(estadoInicial, tareasDisponibles);
        //no puedo asignar al mismo procesador mas de dos tareas críticas.
        //no puedo asignar a un procesador no refrigerado si el tiempo de ejecución de la tarea es mayor a tiempoMaxEjecucion
    }

    private void backtracking(Estado estado, LinkedList<Tarea> tareasDisponibles) {
        // Implementar
        if(tareasDisponibles.size()== 0){
            //operar solucion
        }
        else{
            
        }
    }
}