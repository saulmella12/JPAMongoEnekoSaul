package Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Issue")
public class Issue {
    private long id;
    private String titulo;
    private String texto;
    private String fecha;
    private List<Programador> programadores;
    private List<Commits> commits;
    private boolean termiando;
    private Proyecto proyecto;

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Column
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Column
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setProgramadores(List<Programador> programadores) {
        this.programadores = programadores;
    }

    public void setCommits(List<Commits> commits) {
        this.commits = commits;
    }

    @Column
    public boolean isTermiando() {
        return termiando;
    }

    public void setTermiando(boolean termiando) {
        this.termiando = termiando;
    }

    @OneToMany
    public List<Programador> getProgramadores() {
        return programadores;
    }

    @OneToMany
    public List<Commits> getCommits() {
        return commits;
    }

    @ManyToOne
    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Issue(){}

    public Issue(long id, String titulo, String texto, String fecha, boolean termiando) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.fecha = fecha;
        this.termiando = termiando;
    }
}
