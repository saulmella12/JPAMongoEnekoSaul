package Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Proyecto")
public class Proyecto {
    private long id;
    private boolean termiando;
    private Programador jefe;
    private String nombre;
    private double presupuesto;
    private String fechaInicio;
    private String fechaFin;
    /*private Programador p;*/
    /*private List<Tecnologia> tecnologias;*/

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public boolean isTermiando() {
        return termiando;
    }

    public void setTermiando(boolean termiando) {
        this.termiando = termiando;
    }

    @ManyToOne
    public Programador getJefe() {
        return jefe;
    }

    public void setJefe(Programador jefe) {
        this.jefe = jefe;
    }

    @Column
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column
    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Column
    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Column
    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }


    /*public Programador getProgramador(){
        return this.p;
    }*/


    /*public void setTecnologias(List<Tecnologia> tecnologias) {
        this.tecnologias = tecnologias;
    }*/

    public Proyecto(){}

    public Proyecto(long id, boolean termiando, Programador jefe, String nombre, double presupuesto, String fechaInicio, String fechaFin) {
        this.id = id;
        this.termiando = termiando;
        this.jefe = jefe;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
}
