package DAO;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Departamento")
@NamedQuery(name = "Departamento.findAll", query = "Select d from Departamento d")
@Data
public class Departamento {

    @Id private long id;
    @ElementCollection private List<Long> enCurso;
    @Column private String nombre;
    @Column private long idJefe;
    @Column private double presupuesto;
    @ElementCollection private List<Long> finalizados;
    @ElementCollection private List<Long> jefes;
}
