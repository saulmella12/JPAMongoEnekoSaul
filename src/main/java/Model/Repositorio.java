package Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Repositorio")
public class Repositorio {
    private long id;
    private String nombre;
    private String fecha;
    private Proyecto proyecto;
    private List<Commits> commits;
    private List<Issue> issues;

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @ManyToOne
    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public void setCommits(List<Commits> commits) {
        this.commits = commits;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    @OneToMany
    public List<Commits> getCommits() {
        return commits;
    }

    @OneToMany
    public List<Issue> getIssues() {
        return issues;
    }

    public Repositorio(){}

    public Repositorio(long id, String nombre, String fecha, Proyecto proyecto) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.proyecto = proyecto;
    }
}
