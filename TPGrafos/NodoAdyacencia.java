package TPGrafos;

public class NodoAdyacencia<T> extends Nodo {

    private Arco<T> arco;

    public NodoAdyacencia(Arco<T> arco){
        super();
        this.arco = null;
    }

    public Arco<T> getArco() {
        return arco;
    }

    public void setArco(Arco<T> arco) {
        this.arco = arco;
    }
    
}
