package TPGrafos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
	
	NodoGrafo primerNodo;
	int cantidadVertices;
	int cantidadArcos;

	public GrafoDirigido() {
		primerNodo = null;
		this.cantidadVertices = 0;
		this.cantidadArcos = 0;
	}

	@Override
	public void agregarVertice(int verticeId) {
		if(this.primerNodo == null){
			this.primerNodo = new NodoGrafo(verticeId);
			this.cantidadVertices++;
		}
		else{
			if(agregarVertice(verticeId, this.primerNodo)){
				this.cantidadVertices++;
			}
		}		
	}

	@Override
	public void borrarVertice(int verticeId) {
		// TODO Auto-generated method stub
		this.cantidadVertices--;
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		// TODO Auto-generated method stub
		this.cantidadArcos++;
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		this.cantidadArcos--;
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int unVertice, int otroVertice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cantidadVertices() {
		return this.cantidadVertices;				//complejidad O(1)
	}

	@Override
	public int cantidadArcos() {
		return this.cantidadArcos;					//complejidad O(1)
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean agregarVertice(int verticeId, Nodo nodo){
		if(nodo.getVertice() != verticeId){
			if(nodo.getNext() != null){
				agregarVertice(verticeId, nodo.getNext());
			}
			else{
				nodo.setNext(new NodoGrafo(verticeId));
				return true;
			}
		}
		return false;
	}
}
