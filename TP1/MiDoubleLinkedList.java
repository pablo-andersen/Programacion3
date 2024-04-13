package TP1;

import java.util.Iterator;
import java.util.prefs.NodeChangeEvent;

public class MiDoubleLinkedList<T extends Comparable<T>> implements Iterable<T> {

    private NodeDouble<T> first;
    private NodeDouble<T> last;
    private int size;

    public MiDoubleLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    public void insertFront(T info) {
        NodeDouble<T> nuevo = new NodeDouble<T>(info, null, null);
        if(this.first == null){
            this.first = nuevo;
            this.last = nuevo;
        }
        else{
            nuevo.setNext(this.first);
            this.first.setPrevious(nuevo);
            this.first = nuevo;
        }   
        this.size++;
    }

    public T extractFront() {
        T output = null;
        if(this.first != null){
            output = this.first.getInfo();
            if(this.size == 1) {
                this.last = null;
            }
            this.first = this.first.getNext();
            this.first.setPrevious(null);
            this.size--;
        }
        return output;
    }

    public boolean isEmpty () {
        return this.first == null && this.last == null && this.size == 0;
    }
    
    public T get (int index){
        Integer count = 0;
        NodeDouble<T> actual = this.first;
        while(count != index && count < this.size()){
            count++;
            actual = actual.getNext();
        }
        if(count == index){
            return actual.getInfo();
        }
        else{
            return null;
        }
    }

    public int size(){
        return this.size;
    }

    @Override
    public String toString(){
        NodeDouble<T> actual = this.first;
        Integer count = 0;
        String StringifiedList = "|";
        while(count < this.size()){
            StringifiedList += " " + actual.getInfo() + " |";
            actual = actual.getNext();
            count++;
        }
        return StringifiedList;
    }


    public int indexOf(T info){
        Integer index = 0;
        NodeDouble<T> actual = this.first;
        while(index < this.size()){
            if(actual.getInfo().equals(info)){
                return index;
            }
            else{
                actual = actual.getNext();
                index++;
            }
        }
        return -1;
    }

    public NodeDouble<T> getFirst(){
        return this.first;
    }

    public void insertarOrdenado(T info) {
        NodeDouble<T> nuevo = new NodeDouble<T>(info, null, null);        
        if(this.first == null){
            this.first = nuevo;
            this.last = nuevo;
        }
        else{
            NodeDouble<T> actual = this.first;
            NodeDouble<T> anterior = new NodeDouble<>();
            while(actual != null && actual.getInfo().compareTo(info) < 0){
                actual = actual.getNext();
            }

            if(actual == null) {
                anterior = this.last;
                this.last = nuevo;
                nuevo.setPrevious(anterior);
                anterior.setNext(nuevo);
            }
            else {
                anterior = actual.getPrevious();
                nuevo.setNext(actual);
                nuevo.setPrevious(anterior);
                actual.setPrevious(nuevo);
                if(anterior == null){
                    this.first = nuevo;
                }
                else{
                    anterior.setNext(nuevo);
                }            
            }        
        }
        this.size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyDoubleIterator<>(this.first);
    }
    
}
