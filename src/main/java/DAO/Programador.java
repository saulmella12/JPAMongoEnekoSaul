package DAO;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="Programador")
@NamedQuery(name = "Programador.findAll", query = "Select p from Programador p")
public class Programador {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) private long id;
    @Column private String nombre;
    @Column private String alta;
    @Column private double salario;
    @Column private String usuario;
    @Column private String passwd;
    @Column private Long idDepartamento;
    @ElementCollection private List<Long> commits;
    @ElementCollection private List<Long> issues;
    @ElementCollection private List<String> tecnologias;

    public Programador(String nombre, String alta, double salario, String usuario, String passwd, Long idDepartamento, List<Long> commits, List<Long> issues, List<String> tecnologias) {
        this.nombre = nombre;
        this.alta = alta;
        this.salario = salario;
        this.usuario = usuario;
        this.passwd = passwd;
        this.idDepartamento = idDepartamento;
        this.commits = commits;
        this.issues = issues;
        this.tecnologias = tecnologias;
    }
}
