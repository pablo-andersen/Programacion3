package TPGrafos;

import java.util.Iterator;

public class Nodo {

	private Integer vertice;
	private Nodo next;

	public Nodo() {
		this.vertice = null;
		this.next = null;
	}

	public Nodo(Integer vertice) {
		this.setVertice(vertice);
		this.setNext(null);
	}
	
	public Nodo getNext() {
		return this.next;
	}

	public void setNext(Nodo next) {
		this.next = next;
	}

	public int getVertice() {
		return this.vertice;
	}

	public void setVertice(Integer vertice) {
		this.vertice = vertice;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'iterator'");
	}

}