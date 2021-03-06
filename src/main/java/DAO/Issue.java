package DAO;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="Issue")
@NamedQuery(name = "Issue.findAll", query = "Select i from Issue i")
public class Issue {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) private long id;
    @Column private String titulo;
    @Column private String texto;
    @Column private String fecha;
    @ElementCollection private List<Long> programadores;
    @ElementCollection private List<Long> commits;
    @Column private long idProyecto;
    @Column private long idRepositorio;
    @Column private boolean terminado;

    public Issue(String titulo, String texto, String fecha, List<Long> programadores, List<Long> commits, long idProyecto, long idRepositorio, boolean terminado) {
        this.titulo = titulo;
        this.texto = texto;
        this.fecha = fecha;
        this.programadores = programadores;
        this.commits = commits;
        this.idProyecto = idProyecto;
        this.idRepositorio = idRepositorio;
        this.terminado = terminado;
    }
}
