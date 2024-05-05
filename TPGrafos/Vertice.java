package TPGrafos;

import java.util.LinkedList;

public class Vertice<T> {
    
    private int verticeId;
    String color;
    Integer tiempoDescubrimiento;
    Integer tiempoFinalizacion;
    private LinkedList<Arco<T>> arcos;
    
    public Vertice(int verticeId) {
        this.verticeId = verticeId;
        this.arcos = new LinkedList<Arco<T>>();
        this.color = "blanco";
        this.tiempoDescubrimiento = null;
        this.tiempoFinalizacion = null;
    }
    
    public int getVerticeId() {
        return verticeId;
    }
    
    public void setVerticeId(int verticeId) {
        this.verticeId = verticeId;
    }
    
        public String getColor() {
            return this.color;
        }
    
        public void setColor(String color) {
            this.color = color;
        }
    
        public Integer getTiempoDescubrimiento() {
            return this.tiempoDescubrimiento;
        }
    
        public void setTiempoDescubrimiento(Integer tiempoDescubrimiento) {
            this.tiempoDescubrimiento = tiempoDescubrimiento;
        }
    
        public Integer getTiempoFinalizacion() {
            return this.tiempoFinalizacion;
        }
    
        public void setTiempoFinalizacion(Integer tiempoFinalizacion) {
            this.tiempoFinalizacion = tiempoFinalizacion;
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
}
