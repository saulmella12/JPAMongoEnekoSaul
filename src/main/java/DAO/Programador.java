package DAO;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="Programador")
@NamedQuery(name = "Programador.findAll", query = "Select p from Programador p")
public class Programador {
    @Id private long id;
    @Column private String nombre;
    @Column private String alta;
    @Column private double salario;
    @Column private String usuario;
    @Column private String passwd;
    @Column private Long idDepartamento;
    @ElementCollection private List<Long> commits;
    @ElementCollection private List<Long> issues;
    @ElementCollection private List<String> tecnologias;
}
