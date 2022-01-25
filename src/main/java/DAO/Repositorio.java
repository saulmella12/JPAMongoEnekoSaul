package DAO;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="Repositorio")
@NamedQuery(name = "Repositorio.findAll", query = "Select r from Repositorio r")
public class Repositorio {
    @Id private long id;
    @Column private String nombre;
    @Column private long idProyecto;
    @Column private String fecha;
    @ElementCollection private List<Long> commits;
    @ElementCollection private List<Long> issues;
}
