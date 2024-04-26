package TPGrafos;

public class Nodo  {

	private Integer vertice;
	private Nodo next;

	public Nodo() {
		this.vertice = null;
		this.next = null;
	}
	
	public Nodo(Integer vertice, Nodo next) {
		this.setVertice(vertice);
		this.setNext(next);
	}
	
	public Nodo getNext() {
		return next;
	}

	public void setNext(Nodo next) {
		this.next = next;
	}

	public Integer getVertice() {
		return vertice;
	}

	public void setVertice(Integer vertice) {
		this.vertice = vertice;
	}

}