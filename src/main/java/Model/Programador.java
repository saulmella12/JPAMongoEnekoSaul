package Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Programador")
public class Programador {
    private long id;
    private String nombre;
    private String alta;
    private double salario;
    private String usuario;
    private String passwd;
    private List<Proyecto> proyectos;
    private List<Commits> commits;
    private List<Issue> issues;
    /*private List<Tecnologia> tecnologias;*/

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
    public String getAlta() {
        return alta;
    }

    public void setAlta(String alta) {
        this.alta = alta;
    }

    @Column
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Column
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Column
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public void setCommits(List<Commits> commits) {
        this.commits = commits;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    /*public void setTecnologias(List<Tecnologia> tecnologias) {
        this.tecnologias = tecnologias;
    }*/

    @OneToMany
    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    @OneToMany
    public List<Commits> getCommits() {
        return commits;
    }

    @OneToMany
    public List<Issue> getIssues() {
        return issues;
    }

    public Programador(){}

    public Programador(long id, String nombre, String alta, double salario, String usuario, String passwd) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
        this.salario = salario;
        this.usuario = usuario;
        this.passwd = passwd;
    }
}
