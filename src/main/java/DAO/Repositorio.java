package DAO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="Repositorio")
@NamedQuery(name = "Repositorio.findAll", query = "Select r from Repositorio r")
public class Repositorio {
    @Id private long _id = ObjectId.getCurrentCounter();
    @Column private String nombre;
    @Column private long idProyecto;
    @Column private String fecha;
    @ElementCollection private List<Long> commits;
    @ElementCollection private List<Long> issues;

    public Repositorio(String nombre, long idProyecto, String fecha, List<Long> commits, List<Long> issues) {
        this.nombre = nombre;
        this.idProyecto = idProyecto;
        this.fecha = fecha;
        this.commits = commits;
        this.issues = issues;
    }
}
