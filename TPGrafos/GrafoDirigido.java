package TPGrafos;

import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
	
	// Vertice<T> primerNodo;  Esto no va!!!
	HashMap<Integer, Vertice<T>> vertices = new HashMap<Integer, Vertice<T>>();

	int cantidadVertices;																// Se justifica tener este atributo? No se puede obtener la cantidad de vertices con método size() sin empeorar la complejidad??	
	int cantidadArcos;

	public GrafoDirigido() {		
		this.vertices = new HashMap<Integer, Vertice<T>>();
		this.cantidadVertices = 0;
		this.cantidadArcos = 0;
	}

	@Override
	public void agregarVertice(int unVertice) {
		if(!contieneVertice(unVertice)){												//Verifico que el vertice no exista
			Vertice<T> nuevoVertice = new Vertice<T>(unVertice);						//Instancio un nuevo vertice
			this.vertices.put(unVertice, nuevoVertice);									//Agrego el vertice al hashMap
			this.cantidadVertices++;													//Incremento en uno la cantidad de vertices
		}
	}

	@Override
	public void borrarVertice(int unVertice) {
		if(contieneVertice(unVertice)){													//Verifico que el vertice exista
			this.cantidadArcos -= vertices.get(unVertice).getArcos().size();			//Decremento cantidadArcos en la cantidad de arcos que tiene el vertice
			this.vertices.remove(unVertice);											//Elimino el vertice del hashMap (junto con sus arcos asociados)
			this.cantidadVertices--;													//Decremento en uno la cantidad de vertices
			for (Integer verticeId : vertices.keySet()) {								//Recorro todos los vertices del hashMap
				if(existeArco(verticeId, unVertice)){									//Si existe un arco que tenga como vertice destino al vertice que quiero borrar
					borrarArco(verticeId, unVertice);									//Lo borro
					this.cantidadArcos--;												//Decremento en uno la cantidad de arcos
				}
			}
		}																				//Si el vertice no existe no hago nada
	}

	@Override
	public void agregarArco(int unVertice, int otroVertice, T etiqueta) {
		if(contieneVertice(unVertice) && contieneVertice(otroVertice)){					//Vertifico que ambos vertices existan
			if (!existeArco(unVertice, otroVertice)) {									//Vertifico que no exista el arco que quiero agregar
				Arco<T> arco = new Arco<T>(unVertice, otroVertice, etiqueta);			//Creo el arco que voy a insertar
				vertices.get(unVertice).addArco(arco);									//Agrego el arco a la lista de arcos del vertice origen
				this.cantidadArcos++;													//Incremento en uno la cantidad de arcos
			}			
		}
	}

	@Override
	public void borrarArco(int unVertice, int otroVertice) {							//Asumo que para borrar un arco primero se realiza la verificación de que exista
		vertices.get(unVertice).removeArco(obtenerArco(unVertice, otroVertice));		//Elimino el arco de la lista de arcos del vertice origen
		this.cantidadArcos--;
	}

	@Override
	public boolean contieneVertice(int unVertice) {
		return vertices.containsKey(unVertice);											// Verifico si el verticeId pasado por parametro esta en el hashMap de vertices
	}

	@Override
	public boolean existeArco(int unVertice, int otroVertice) {
		return obtenerArco(unVertice, otroVertice) != null;								//si el arco que obtengo no es null, entonces existe
	}

	@Override
	public Arco<T> obtenerArco(int unVertice, int otroVertice) {
		if(contieneVertice(unVertice)){													//verifico que el vertice origen exista			
			Iterator<Arco<T>> itArcos = vertices.get(unVertice).getArcos().iterator();	//obtengo un iterador de los arcos del vertice origen
			while(itArcos.hasNext()){													//mientras haya arcos para recorrer
				Arco<T> arco = itArcos.next();											//obtengo el arco
				if(arco.getVerticeDestino() == otroVertice){							//si el vertice destino del arco es igual al vertice destino pasado por parametro
					return arco;														//devuelvo el arco
				}
			}
		}		
		return null;																	//si no se cumple la condicion anterior devuelvo null
	}

	@Override
	public int cantidadVertices() {
		return this.cantidadVertices;													//complejidad O(1)
	}

	@Override
	public int cantidadArcos() {
	return this.cantidadArcos;															//complejidad O(1)
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int unVertice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int unVertice) {
		// TODO Auto-generated method stub
		return null;
	}

}
