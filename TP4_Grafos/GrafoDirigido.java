package TP4_Grafos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {
	
	HashMap<Integer, LinkedList<Arco<T>>> vertices;
	int cantidadVertices;																
	int cantidadArcos;
	int tiempo;

	public GrafoDirigido() {		
		this.vertices = new HashMap<Integer, LinkedList<Arco<T>>>();
		this.cantidadVertices = 0;
		this.cantidadArcos = 0;
	}

	@Override
	public void agregarVertice(int unVertice) {
		if(!contieneVertice(unVertice)){																				
			this.vertices.put(unVertice, new LinkedList<Arco<T>>());									
			this.cantidadVertices++;													
		}
	}

	@Override
	public void borrarVertice(int unVertice) {
		if(contieneVertice(unVertice)){													
			this.cantidadArcos -= vertices.get(unVertice).size();			
			this.vertices.remove(unVertice);											
			this.cantidadVertices--;													
			Iterator<Integer> itVertices = obtenerVertices();							
			while(itVertices.hasNext()){												
				int verticeId = itVertices.next();										
				borrarArco(verticeId, unVertice);										
			}
		}																				
	}

	@Override
	public void agregarArco(int unVertice, int otroVertice, T etiqueta) {
		if(contieneVertice(unVertice) && contieneVertice(otroVertice)){					
			Arco<T> arco = new Arco<T>(unVertice, otroVertice, etiqueta);				
			if(!vertices.get(unVertice).contains(arco)){
				vertices.get(unVertice).add(arco);
				this.cantidadArcos++;													
			}
		}
	}

	@Override																			
	public void borrarArco(int unVertice, int otroVertice) {							
		if(contieneVertice(unVertice)){	
			Iterator<Arco<T>> itArcos = obtenerArcos(unVertice);						
			while(itArcos.hasNext()){													
				Arco<T> arco = itArcos.next();											
				if(arco.getVerticeDestino() == otroVertice){							
					itArcos.remove();													
					this.cantidadArcos--;		
				}
			}
		}		
	}

	@Override
	public boolean contieneVertice(int unVertice) {
		return vertices.containsKey(unVertice);											
	}

	@Override
	public boolean existeArco(int unVertice, int otroVertice) {
		return obtenerArco(unVertice, otroVertice) != null;								
	}

	@Override
	public Arco<T> obtenerArco(int unVertice, int otroVertice) {
		if(contieneVertice(unVertice)){													
			Iterator<Arco<T>> itArcos = obtenerArcos(unVertice);						
			while(itArcos.hasNext()){													
				Arco<T> arco = itArcos.next();											
				if(arco.getVerticeDestino() == otroVertice){							
					return arco;														
				}
			}
		}		
		return null;																	
	}

	@Override
	public int cantidadVertices() {
		return this.cantidadVertices;													
	}

	@Override
	public int cantidadArcos() {
	return this.cantidadArcos;															
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return vertices.keySet().iterator();											
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int unVertice) {
		LinkedList<Integer> listaAdyacentes =  new LinkedList<Integer>();
		if(contieneVertice(unVertice)){
			Iterator<Integer> itVertices = obtenerVertices();
			while (itVertices.hasNext()) {
				int verticeId = itVertices.next();
				if(existeArco(unVertice, verticeId)){
					listaAdyacentes.add(verticeId);
				}
			}
		}
		return listaAdyacentes.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		LinkedList<Arco<T>> arcosTotales = new LinkedList<Arco<T>>(); 	
		Iterator<Integer> itVertices = obtenerVertices();
		while (itVertices.hasNext()) {									
			LinkedList<Arco<T>> arcos = vertices.get(itVertices.next());		
			arcosTotales.addAll(arcos);					
		}
		return arcosTotales.iterator();									
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int unVertice) {		
		return vertices.get(unVertice).iterator();			
	}
}
