package TP1;

public class Main {
    
    public static void llenarLista(MySimpleLinkedList<Integer> lista, int n){
        Integer valor;
        for (int i = 0; i < n; i++){
            valor = (int) Math.floor(Math.random()* 100);
            lista.insertFront(valor);
        }
    }

    public static void llenarListaOrdenada(MySimpleLinkedList<Integer> lista, int n){
        Integer valor;
        for (int i = 0; i < n; i++){
            valor = (int) Math.floor(Math.random()* 100);
            lista.insertarOrdenado(valor);
        }
    }

    public static MySimpleLinkedList<Integer> getElementosComunesListasDesordenadas(MySimpleLinkedList<Integer> unaLista, MySimpleLinkedList<Integer> otraLista){
        MySimpleLinkedList<Integer> listaResultante = new MySimpleLinkedList<Integer>();        
        for (Integer itemLista1: unaLista){ 
            boolean encontro = false;
            MyIterator<Integer> iteradorLista2 = new MyIterator<>(otraLista.getFirst());

            while (iteradorLista2.hasNext() && !encontro) {
                Integer itemLista2 = iteradorLista2.next();
                if(itemLista1.equals(itemLista2)){
                    encontro = true;
                    listaResultante.insertarOrdenado(itemLista1);
                }                
            }
        }
        return listaResultante;
    }

    public static MySimpleLinkedList<Integer> getElementosComunesListasOrdenadas(MySimpleLinkedList<Integer> unaLista, MySimpleLinkedList<Integer> otraLista){
        MySimpleLinkedList<Integer> listaResultante = new MySimpleLinkedList<Integer>(); 
        MyIterator<Integer> iteradorLista1 = new MyIterator<>(unaLista.getFirst());
        MyIterator<Integer> iteradorLista2 = new MyIterator<>(otraLista.getFirst());

        while(iteradorLista1.hasNext() && iteradorLista2.hasNext()){
            Integer itemLista1 = iteradorLista1.get();
            Integer itemLista2 = iteradorLista2.get();
            if (itemLista1.equals(itemLista2)){
                listaResultante.insertarOrdenado(itemLista1);
                iteradorLista1.next();
                iteradorLista2.next();
            } 
            else if(itemLista1.compareTo(itemLista2) < 0){
                iteradorLista1.next();
            }
            else {
                iteradorLista2.next();
            }
        }
        return listaResultante;        
    }
    
    public static MySimpleLinkedList<Integer> getElementosNoComunes (MySimpleLinkedList<Integer> unaLista, MySimpleLinkedList<Integer> otraLista){
        MySimpleLinkedList<Integer> listaResultante = new MySimpleLinkedList<Integer>(); 
        MyIterator<Integer> iteradorLista1 = new MyIterator<>(unaLista.getFirst());
        MyIterator<Integer> iteradorLista2 = new MyIterator<>(otraLista.getFirst());     

        while (iteradorLista1.hasNext() && iteradorLista2.hasNext()){
            Integer itemLista1 = iteradorLista1.get();
            Integer itemLista2 = iteradorLista2.get();
            if (itemLista1.equals(itemLista2)){
                iteradorLista1.next();
                iteradorLista2.next();
            }
            else if (itemLista1.compareTo(itemLista2) < 0){
                listaResultante.insertarOrdenado(itemLista1);
                iteradorLista1.next();
            }
            else {
                iteradorLista2.next();
            }
        }

        while (iteradorLista1.hasNext()){
            listaResultante.insertarOrdenado(iteradorLista1.get());
            iteradorLista1.next();
        }

        return listaResultante;
    }
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> lista1 = new MySimpleLinkedList<Integer>();
        MySimpleLinkedList<Integer> lista2 = new MySimpleLinkedList<Integer>();
        
        llenarLista(lista1, 20);
        llenarLista(lista2, 20);
        
        MySimpleLinkedList<Integer> lista3 = getElementosComunesListasDesordenadas(lista1, lista2);
        
        System.out.println("Lista 1: " + lista1);
        System.out.println("Lista 2: " + lista2);
        System.out.println("lista 3: " + lista3);
        
        
        
        MySimpleLinkedList<Integer> lista4 = new MySimpleLinkedList<Integer>();
        MySimpleLinkedList<Integer> lista5 = new MySimpleLinkedList<Integer>();

        llenarListaOrdenada(lista4, 20);
        llenarListaOrdenada(lista5, 20);

        MySimpleLinkedList<Integer> lista6 = getElementosComunesListasOrdenadas(lista4, lista5);
        
        System.out.println("Lista 4: " + lista4);
        System.out.println("Lista 5: " + lista5);
        System.out.println("Lista 6: " + lista6);

        MySimpleLinkedList<Integer> lista7 = getElementosNoComunes(lista4, lista5);
        System.out.println("Lista 4: " + lista4);
        System.out.println("Lista 5: " + lista5);
        System.out.println("Lista 7: " + lista7);

    }
}