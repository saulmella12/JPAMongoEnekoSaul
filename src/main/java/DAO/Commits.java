package DAO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="Commits")
@NamedQuery(name = "Commits.findAll", query = "Select c from Commits c")
public class Commits {
    @Id private long _id = ObjectId.getCurrentCounter();
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commits commit = (Commits) o;

        if (_id != commit._id) return false;
        return texto != null ? texto.equals(commit.texto) : commit.texto == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (_id ^ (_id >>> 32));
        result = 31 * result + (texto != null ? texto.hashCode() : 0);
        return result;
    }
}
