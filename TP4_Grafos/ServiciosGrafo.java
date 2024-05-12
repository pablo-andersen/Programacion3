package TP4_Grafos;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ServiciosGrafo<T> {
    /*Esta clase es utilizada para implementar recorrido, obtener camino mas largo, y otro tipo de servicios sobre el grafo */
    private Hashtable<Integer, Integer> tiempoDescubrimiento;
    private Hashtable<Integer, Integer> tiempoFinalizacion;        
    private Hashtable<Integer, String> colores;
    private Hashtable<Integer, Boolean> visitados;
    private Queue<Integer> fila;
    private int tiempo = 0;    
    
    public ServiciosGrafo(){
        this.tiempoDescubrimiento = new Hashtable<Integer, Integer>();
        this.tiempoFinalizacion = new Hashtable<Integer, Integer>();
        this.visitados = new Hashtable<Integer, Boolean>();
        this.fila = new LinkedList<Integer>();
        this.tiempo = 0;
    }
    
    public LinkedList<Integer> recorridoDFS(GrafoDirigido<T> grafo) {				
        LinkedList<Integer> resultado = new LinkedList<Integer>();
        this.tiempoDescubrimiento.clear();
        this.tiempoFinalizacion.clear();
        this.visitados.clear();
        this.fila.clear();
        this.tiempo = 0;
        
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        while(itVertices.hasNext()){
            int verticeId = itVertices.next();		
            colores.put(verticeId,"blanco");
        }
        
        itVertices = grafo.obtenerVertices();
        while(itVertices.hasNext()){	 
            int verticeId = itVertices.next();    
            if(colores.get(verticeId).equalsIgnoreCase("blanco")){
                resultado.addAll(visitarVertice(grafo, verticeId));
            }
        }
        return resultado;
    }

	private LinkedList<Integer> visitarVertice(GrafoDirigido<T> grafo, Integer verticeId){
		LinkedList<Integer> resultado = new LinkedList<Integer>();
		colores.put(verticeId,"amarillo");
		resultado.add(verticeId);
		this.tiempo++;
		this.tiempoDescubrimiento.put(verticeId, this.tiempo);
		Iterator<Integer> itAdyacentes = grafo.obtenerAdyacentes(verticeId);
		while (itAdyacentes.hasNext()){
			int verticeAdyacente = itAdyacentes.next();
			if(colores.get(verticeAdyacente).equalsIgnoreCase("blanco")){
				resultado.addAll(visitarVertice(grafo, verticeAdyacente));			
			}
		}
		colores.put(verticeId,"negro");
		this.tiempo++;
		tiempoFinalizacion.put(verticeId, this.tiempo);
		return resultado;
	}
    
    
    public LinkedList<Integer> recorridoBFS(GrafoDirigido<T> grafo){
        LinkedList<Integer> resultado = new LinkedList<Integer>();
        this.fila.clear();
        this.visitados.clear();

        Iterator<Integer> itVertices = grafo.obtenerVertices();		
        while(itVertices.hasNext()){							
            int verticeId = itVertices.next();				
            this.visitados.put(verticeId, false);
        }
        itVertices = grafo.obtenerVertices();
        while(itVertices.hasNext()){
            Integer verticeId = itVertices.next();            
            if(!this.visitados.get(verticeId)){
                resultado.addAll(recorridoBFS(grafo, verticeId));
            }
        }
        return resultado;
    }
    
	private LinkedList<Integer> recorridoBFS(Grafo<T> grafo, Integer vertice){
        LinkedList<Integer> resultado = new LinkedList<Integer>();
		resultado.add(vertice);
		this.visitados.put(vertice, true);
		this.fila.add(vertice);
		while(!this.fila.isEmpty()){
			Integer verticeFila = fila.remove();
			Iterator<Integer> itAdyacentes = grafo.obtenerAdyacentes(verticeFila);
			while(itAdyacentes.hasNext()){
				Integer vAdyacente = itAdyacentes.next();
				if(!this.visitados.get(vAdyacente)){
					visitados.put(vAdyacente, true);
					fila.add(vAdyacente);
					resultado.add(vAdyacente);
				}
			}
		}
		return resultado;
	}

	public LinkedList<Integer> obtenerRecorridoMasLargo(GrafoDirigido<T> grafo, Integer verticeOrigen, Integer verticeDestino){
		if(!grafo.contieneVertice(verticeOrigen) || !grafo.contieneVertice(verticeDestino)){
			return new LinkedList<Integer>();
		}
		return recorridoMasLargo(grafo, verticeOrigen, verticeDestino);
	}

	private LinkedList<Integer> recorridoMasLargo(GrafoDirigido<T> grafo, Integer verticeOrigen, Integer verticeDestino){
		LinkedList<Integer> res = new LinkedList<Integer>();  
		LinkedList<Integer> resParcial = new LinkedList<Integer>();
		if(verticeOrigen.equals(verticeDestino)){
			res.add(verticeOrigen);
			return res;
		}
		Iterator<Integer> arcos = grafo.obtenerAdyacentes(verticeOrigen);
		while(arcos.hasNext()){
			Integer verticeAdyacente = arcos.next();
			resParcial = recorridoMasLargo(grafo, verticeAdyacente, verticeDestino);
			if (resParcial.size() > res.size()){
				res = new LinkedList<Integer>(resParcial);
			}
		}
		if(res.size() > 0){
			res.add(0, verticeOrigen);
		}
		return res;
	}

    public Set<Integer> verticesHastaDestino(GrafoDirigido<T> grafo, Integer verticeDestino){
        Set<Integer> resultado = new HashSet<Integer>();
        //Si no contiene el vertice destino, devuelvo lista vacía
        if(!grafo.contieneVertice(verticeDestino)){
            return resultado;
        }

        // Si contiene el vertice destino, limpio las estructuras de datos y luego        
        // itero los vertices del grafo y los inicializo como no visitados
        this.visitados.clear();
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        while(itVertices.hasNext()){
            Integer verticeGrafo = itVertices.next();
            this.visitados.put(verticeGrafo, false);
        }
    
        // itero los vertices del grafo
        itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext()){
            Integer vertice = itVertices.next();
            // para cada vértice, si no es visitado, llamo a la función caminoHastaDestino
            if(!this.visitados.get(vertice)){
                resultado.addAll(caminoHastaDestino(grafo, vertice, verticeDestino));
            }
        }

        return resultado;
    }

    private Set<Integer> caminoHastaDestino(GrafoDirigido<T> grafo, Integer verticeOrigen, Integer verticeDestino){
        Set<Integer> resultado = new HashSet<Integer>();
        Set<Integer> resParcial = new HashSet<Integer>();
        //Marco como visitado el vertice origen
        visitados.put(verticeOrigen, true);
        // itero los vertices  adyacentes 
        Iterator<Integer> itAdyacentes = grafo.obtenerAdyacentes(verticeOrigen); 
        while (itAdyacentes.hasNext()){
            Integer verticeAdyacente = itAdyacentes.next();
            // para cada adyacente, si no es visitado, agrego a resultado el camino hasta el destino (si es que existe, si no devuelve lista vacía )
            if(verticeAdyacente.equals(verticeDestino)){
                resParcial.add(verticeOrigen);
            }
            resParcial.addAll(caminoHastaDestino(grafo, verticeAdyacente, verticeDestino));
            }
        // si el resultado parcial no es vacío, agrego el vertice origen al resultado
        if(!resParcial.isEmpty()){
            resParcial.add(verticeOrigen);
            resultado.addAll(resParcial);
        }
        return resultado;
    }

}
