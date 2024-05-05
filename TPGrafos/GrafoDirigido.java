package TPGrafos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {
	
	HashMap<Integer, Vertice<T>> vertices;
	int cantidadVertices;																
	int cantidadArcos;

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

}
