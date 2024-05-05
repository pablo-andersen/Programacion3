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

    public LinkedList<Arco<T>> getArcos() {    
        return new LinkedList<>(arcos);
    }

    public boolean addArco(Arco<T> unArco){
        if (arcos.contains(unArco)){
            return false;
        }
        arcos.add(unArco);                 
        return true;
    }

    public LinkedList<Integer> obtenerAdyacentes(){
		LinkedList<Integer> lista = new LinkedList<Integer>();
		for(Arco<T> arco : arcos) {
			lista.add(arco.getVerticeDestino());
		}
		return lista;
	}

    public boolean removeArco(Integer verticeDestino){      
        for(Arco<T> arco : arcos){
            if(arco.getVerticeDestino() == verticeDestino){
                return arcos.remove(arco);
            }
        }
        return false;
    }

    public boolean existeArco(int verticeId){
        return false;
    }
}
