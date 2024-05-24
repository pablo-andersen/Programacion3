package tpe;

import java.util.LinkedList;

public class Procesador {
    private String id;
    private String codigo;
    private boolean refrigerado;
    private Integer anio;
    Integer tiempoEjecucion;
    LinkedList<Tarea> tareasAsignadas;


    public Procesador(String id, String codigo, boolean refrigerado, Integer anio) {
        this.id = id;
        this.codigo = codigo;
        this.refrigerado = refrigerado;
        this.anio = anio;
        this.tiempoEjecucion = 0;
        this.tareasAsignadas = new LinkedList<Tarea>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isRefrigerado() {
        return refrigerado;
    }

    public void setRefrigerado(boolean refrigerado) {
        this.refrigerado = refrigerado;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }
    public boolean ultimaTareaCritica(){
        return tareasAsignadas.getLast().isCritica();
    }

    public void asignarTarea(Tarea tarea){
        tareasAsignadas.add(tarea);
        tiempoEjecucion += tarea.getTiempo();
    }

    public Integer getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    // public Tarea removeLastTarea(){
    //     Tarea eliminada = tareasAsignadas.removeLast();
    //     tiempoEjecucion -= eliminada.getTiempo();
    //     return eliminada;
    // }

    public void removeLastTarea(){
        Tarea eliminada = tareasAsignadas.removeLast();
        tiempoEjecucion -= eliminada.getTiempo();
    }
}
