package TP1;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {
    
    private Node<T> cursor;

    public MyIterator(Node<T> cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean hasNext() {
        return this.cursor != null;
    }

    @Override
    public T next() {
        T info = this.cursor.getInfo();
        this.cursor = this.cursor.getNext();
        return info;
    }
    
    public T get() {
        return this.cursor.getInfo();
    }
}
