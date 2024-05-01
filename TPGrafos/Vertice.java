package TPGrafos;

import java.util.LinkedList;



public class Vertice<T> {
    
    private int verticeId;
    private LinkedList<Arco<T>> arcos;

    public Vertice(int verticeId) {
        this.verticeId = verticeId;
        this.arcos = new LinkedList<Arco<T>>();
    }

    public int getVerticeId() {
        return verticeId;
    }

    public void setVerticeId(int verticeId) {
        this.verticeId = verticeId;
    }

    public LinkedList<Arco<T>> getArcos() {     // devuelvo una lista nueva para no romper el encapsulamiento
        return new LinkedList<>(arcos);
    }

    public void addArco(Arco<T> unArco){      // duda, se pasa un arco como parámetro o los vérticas y la etiqueta?
        arcos.add(unArco);                     //decidí realizar las verficaciones en la clase GrafoDirigido y directamente llamar a este método con el arco que se agrega a la lista
    }

    public void removeArco(Arco<T> unArco){   // duda, se pasa un arco como parámetro o los vérticas y el arco? Se debe implementar el equals en la clase Arco y preguntar si arcos.contains(arco) para eliminarlo?
        arcos.remove(unArco);                  //decidí realizar las verficaciones en la clase GrafoDirigido y directamente llamar a este método con el arco que se elimina de la lista
    }

    public boolean existeArco(int verticeId){
        
        return null;
    }
    
    

}
