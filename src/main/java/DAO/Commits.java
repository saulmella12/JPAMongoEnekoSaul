package DAO;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="Commits")
@NamedQuery(name = "Commits.findAll", query = "Select c from Commits c")
public class Commits {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) private long id;
    @Column private String titulo;
    @Column private String texto;
    @Column private String fecha;
    @Column private long idRepositorio;
    @Column private long idIssue;
    @Column private long idProyecto;
    @Column private long idCreador;

    public Commits(String titulo, String texto, String fecha, long idRepositorio, long idIssue, long idProyecto, long idCreador) {
        this.titulo = titulo;
        this.texto = texto;
        this.fecha = fecha;
        this.idRepositorio = idRepositorio;
        this.idIssue = idIssue;
        this.idProyecto = idProyecto;
        this.idCreador = idCreador;
    }
}
