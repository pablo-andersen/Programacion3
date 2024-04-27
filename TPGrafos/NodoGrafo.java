package TPGrafos;

public class NodoGrafo extends Nodo{

    private NodoAdyacencia Adyacencias;

    public NodoGrafo() {
        super();
        this.Adyacencias = null;
    }

    public NodoGrafo(Integer vertice) {
        super(vertice);
        this.Adyacencias = null;
    }   

    public boolean esAdyacente(Integer unVertice){
        return false;   
    }

    public void agregarAdyacencia(Integer vertice){
      
    }

}
