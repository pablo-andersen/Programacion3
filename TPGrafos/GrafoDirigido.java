package TPGrafos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GrafoDirigido<T> implements Grafo<T> {
	
	HashMap<Integer, Vertice<T>> vertices;
	Queue<Vertice<T>> fila;		
	int cantidadVertices;																
	int cantidadArcos;
	int tiempo;

	public GrafoDirigido() {		
		this.vertices = new HashMap<Integer, Vertice<T>>();
		this.cantidadVertices = 0;
		this.cantidadArcos = 0;
	}

	@Override
	public void agregarVertice(int unVertice) {
		if(!contieneVertice(unVertice)){												
			Vertice<T> nuevoVertice = new Vertice<T>(unVertice);						
			this.vertices.put(unVertice, nuevoVertice);									
			this.cantidadVertices++;													
		}
	}

	@Override
	public void borrarVertice(int unVertice) {
		if(contieneVertice(unVertice)){													
			this.cantidadArcos -= vertices.get(unVertice).getArcos().size();			
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
			if(vertices.get(unVertice).addArco(arco)){									
				this.cantidadArcos++;													
			}
		}
	}

	@Override																			
	public void borrarArco(int unVertice, int otroVertice) {							
		if(vertices.get(unVertice).removeArco(otroVertice)){							
			this.cantidadArcos--;		
		};		
		
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
	//   Vertice<T> v = vertices.get(unVertice);
	//   LinkedList<Integer> listaAdyacentes =  v.obtenerAdyacentes() ;
	//   return listaAdyacentes.iterator();
	// ****** SE REEMPLAZA EL CODIGO ANTERIOR POR LA FORMA CORTA DE ABAJO ******
		return vertices.get(unVertice).obtenerAdyacentes().iterator();					
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		LinkedList<Arco<T>> arcosTotales = new LinkedList<Arco<T>>(); 	
		Iterator<Integer> itVertices = obtenerVertices();
		while (itVertices.hasNext()) {									
			Vertice<T> vertice = vertices.get(itVertices.next());		
			arcosTotales.addAll(vertice.getArcos());					
		}
		return arcosTotales.iterator();									
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int unVertice) {		
		return vertices.get(unVertice).getArcos().iterator();			
	}

	public LinkedList<Integer> visitarVertice(Vertice<T> unVertice){
		LinkedList<Integer> resultado = new LinkedList<Integer>();
		unVertice.setColor("amarillo");
		resultado.add(unVertice.getVerticeId());
		this.tiempo++;
		unVertice.setTiempoDescubrimiento(this.tiempo);
		Iterator<Integer> itAdyacentes = obtenerAdyacentes(unVertice.getVerticeId());
		while (itAdyacentes.hasNext()){
			int verticeId = itAdyacentes.next();
			Vertice<T> v = vertices.get(verticeId);
			if(v.getColor().equals("blanco")){
				resultado.addAll(visitarVertice(v));			
			}
		}
		unVertice.setColor("negro");
		this.tiempo++;
		unVertice.setTiempoFinalizacion(tiempo);
		return resultado;
	}

	public LinkedList<Integer> recorridoEnProfundidad() {							//Recorrido en profundidad del grafo a partir del primer vertice devuelto por el metodo que devuelve los vertices del grafo
		LinkedList<Integer> resultado = new LinkedList<Integer>();					// este método devuelve una lista de Ids con el orden de los vértices visitados.
		Iterator<Integer> itVertices = obtenerVertices();
		while(itVertices.hasNext()){
			int verticeId = itVertices.next();		
			vertices.get(verticeId).setColor("blanco");
		}	

		this.tiempo = 0;
		
		itVertices = obtenerVertices();
		while(itVertices.hasNext()){	 
			int verticeId = itVertices.next();
			Vertice<T> v = vertices.get(verticeId);
			if(v.getColor().equals("blanco")){
				resultado.addAll(visitarVertice(v));
			}
		}
		return resultado;
	}

	public LinkedList<Integer> recorridoEnAmplitud(Vertice<T> vertice){
		LinkedList<Integer> resultado = new LinkedList<Integer>();
		resultado.add(vertice.getVerticeId());
		vertice.setColor("amarillo");
		fila.add(vertice);
		while(!fila.isEmpty()){
			Vertice<T> verticeFila = fila.remove();
			Iterator<Integer> itAdyacentes = obtenerAdyacentes(verticeFila.getVerticeId());
			while(itAdyacentes.hasNext()){
				Vertice<T> vAdyacente = vertices.get(itAdyacentes.next());
				if(vAdyacente.getColor().equals("blanco")){
					vAdyacente.setColor("amarillo");
					fila.add(vAdyacente);
					resultado.add(vAdyacente.getVerticeId());
				}
			}
		}
		return resultado;
	}
	
	public LinkedList<Integer> recorridoEnAmplitud(){
		LinkedList<Integer> resultado = new LinkedList<Integer>();
		this.fila = new LinkedList<Vertice<T>>();

		Iterator<Integer> itVertices = obtenerVertices();		
		while(itVertices.hasNext()){							
			int verticeId = itVertices.next();				
			vertices.get(verticeId).setColor("blanco");		
		}
		itVertices = obtenerVertices();
		while(itVertices.hasNext()){
			Integer verticeId = itVertices.next();
			Vertice<T> v = vertices.get(verticeId);
			if(v.getColor().equals("blanco")){
				resultado.addAll(recorridoEnAmplitud(v));
			}
		}
		return resultado;
	}
}
