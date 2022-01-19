package DAO;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="Issue")
public class Issue {
    @Id private long id;
    @Column private String titulo;
    @Column private String texto;
    @Column private String fecha;
    @ElementCollection private List<Long> programadores;
    @ElementCollection private List<Long> commits;
    @Column private long idProyecto;
    @Column private long idRepositorio;
    @Column private boolean terminado;



}
