package TP1;

import java.util.Iterator;

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T>{
	
	private Node<T> first;
    private int size;
	
	public MySimpleLinkedList() {
		this.first = null;
        this.size = 0;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
        this.size++;
	}
	
	public T extractFront() {	
        T output = null;
        if(this.first != null){
            output = this.first.getInfo();
            this.first = this.first.getNext();	
            this.size--;
        }

        return output;
	}

	public boolean isEmpty() {		
		return this.first == null;
	}
	
	public T get(int index) {
		Integer count = 0;
        Node<T> actual = this.first;
        while (count != index && count < this.size()){
            count++;
            actual = actual.getNext();
        }
        if(count == index){
            return actual.getInfo();
        }
        else {
		    return null;
        }
	}
	
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {		
        Node<T> actual = this.first;
        Integer count = 0;
        String StringifiedList = "|";
        while (count < this.size()){
            StringifiedList += " " + actual.getInfo().toString() + " |";
            actual = actual.getNext();
            count++;
        }
		return StringifiedList;
	}

    public int indexOf(T info){
        Integer index = 0;
        Node<T> actual = this.first;
        while (index < this.size()){ 
            if(actual.getInfo().equals(info)){
                return index;
            }
            else {
                actual = actual.getNext();
                index++;
            }
        }
        return -1;
    }

    public Node<T> getFirst(){
        return this.first;
    }

    @Override
    public Iterator<T> iterator() {              
        return new MyIterator<T>(this.first);
    }
    
    public void insertarOrdenado (T info){
        Node<T> nuevo = new Node<T>(info, null);
        if (this.first == null || (this.first.getInfo()).compareTo(info) > 0){
            nuevo.setNext(this.first);
            this.first = nuevo;
            this.size++;
        }
        else {
            Node<T> actual = this.first;
            Node<T> anterior = null;
            while (actual != null && (actual.getInfo()).compareTo(info) < 0){
                anterior = actual;
                actual = actual.getNext();
            }
            if (anterior == null){
                nuevo.setNext(this.first);
                this.first = nuevo;
                this.size++;
            }
            else {
                nuevo.setNext(actual);
                anterior.setNext(nuevo);
                this.size++;
            }
        }
    }	
}