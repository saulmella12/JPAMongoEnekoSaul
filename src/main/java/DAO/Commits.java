package DAO;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="Commits")
@NamedQuery(name = "Commits.findAll", query = "Select c from Commits c")
public class Commits {
    @Id private long id;
    @Column private String titulo;
    @Column private String texto;
    @Column private String fecha;
    @Column private long idRepositorio;
    @Column private long idIssue;
    @Column private long idProyecto;
    @Column private long idCreador;
}
