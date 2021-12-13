package Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Departamento")
public class Departamento {

    private long id;
    private List<Proyecto> proyectos;
    private String nombre;
    private Programador jefe;
    private double presupuesto;
    private List<Proyecto> finalizados;

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    @Column
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @ManyToOne
    public Programador getJefe() {
        return jefe;
    }

    public void setJefe(Programador jefe) {
        this.jefe = jefe;
    }

    @Column
    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public void setFinalizados(List<Proyecto> finalizados) {
        this.finalizados = finalizados;
    }

    @OneToMany
    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    @OneToMany
    public List<Proyecto> getFinalizados() {
        return finalizados;
    }

    public Departamento(){}

    public Departamento(long id, String nombre, Programador jefe, double presupuesto) {
        this.id = id;
        this.nombre = nombre;
        this.jefe = jefe;
        this.presupuesto = presupuesto;
    }
}
