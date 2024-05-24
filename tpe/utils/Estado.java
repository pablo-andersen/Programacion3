package tpe.utils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.HashMap;

import tpe.Procesador;
import tpe.Tarea;

public class Estado {
    private HashMap<String, Procesador> procesadores;
    private Integer tiempoFinalEjecucion;
    
    public Estado(HashMap<String, Procesador> procesadores){
        this.procesadores = procesadores;
        this.tiempoFinalEjecucion = null;
    }

    public Iterator<String> iterarProcesadores(){
        return procesadores.keySet().iterator();        
    }

    public void asignarTarea(String idProcesador, Tarea tarea){
        procesadores.get(idProcesador).asignarTarea(tarea);
        Integer tiempoProcesador = procesadores.get(idProcesador).getTiempoEjecucion();
        if (this.tiempoFinalEjecucion == null || tiempoProcesador > this.tiempoFinalEjecucion){
            this.tiempoFinalEjecucion = tiempoProcesador;
        }
    }

    public void desasignarTarea(String idProcesador){
        procesadores.get(idProcesador).removeLastTarea();
        this.tiempoFinalEjecucion = buscarTiempoFinal();
    }

    private Integer buscarTiempoFinal(){
        int tiempoFinalEstado = 0; 
        Iterator<String> itProcesadores = procesadores.keySet().iterator();
        while (itProcesadores.hasNext()){
            String idActual = itProcesadores.next();
            int tiempoActual = procesadores.get(idActual).getTiempoEjecucion();
            if(tiempoActual > tiempoFinalEstado){
                tiempoFinalEstado = tiempoActual;
            }
        }
        return tiempoFinalEstado;
    }


}
