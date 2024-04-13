package TP1;

public class NodeDouble<T>  {

	private T info;
	private NodeDouble<T> next;
	private NodeDouble<T> previous;

	public NodeDouble() {
		this.info = null;
		this.previous = null;
		this.next = null;
	}
	
	public NodeDouble(T info, NodeDouble<T> next, NodeDouble<T> previous) {
		this.setInfo(info);
		this.setNext(next);
		this.setPrevious(previous);
	}
	
	public T getInfo() {
		return this.info;
	}
	
	public NodeDouble<T> getNext() {
		return this.next;
	}

	public NodeDouble<T> getPrevious() {
		return this.previous;
	}

	public void setNext(NodeDouble<T> next) {
		this.next = next;
	}

	public void setPrevious(NodeDouble<T> previous) {
		this.previous = previous;
	}	


	public void setInfo(T info) {
		this.info = info;
	}

}