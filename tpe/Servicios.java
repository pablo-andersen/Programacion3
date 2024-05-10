package tpe;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import tpe.utils.CSVReader;

/**
 * NO modificar la interfaz de esta clase ni sus métodos públicos.
 * Sólo se podrá adaptar el nombre de la clase "Tarea" según sus decisiones
 * de implementación.
 */
public class Servicios {

	private HashMap<String, Tarea> tareas = new HashMap<String, Tarea>();
	private HashMap<String, Procesador> procesadores = new HashMap<String, Procesador>();
	/*
     * Expresar la complejidad temporal del constructor.
     */
	public Servicios(String pathProcesadores, String pathTareas)
	{
		CSVReader reader = new CSVReader();
		this.procesadores = reader.readProcessors(pathProcesadores);
		this.tareas = reader.readTasks(pathTareas);
	}
	
	/*
     * Expresar la complejidad temporal del servicio 1.
	 * Complejidad temporal: O(1)
     */
	public Tarea servicio1(String ID) {
		return tareas.get(ID);
	}
    
    /*
     * Expresar la complejidad temporal del servicio 2.
     */
	public List<Tarea> servicio2(boolean esCritica) {
		LinkedList<Tarea> resultado = new LinkedList<Tarea>();
		// Iterator<String> itTareas= tareas.keySet().iterator();
		while (itTareas.hasNext()){
			Tarea temp = itTareas.next();
			if(temp.isCritica()){

			}


		}
		return ;	
	}

    /*
     * Expresar la complejidad temporal del servicio 3.
     */
	public List<Tarea> servicio3(int prioridadInferior, int prioridadSuperior) {
		return new LinkedList<Tarea>();	
	}
}
