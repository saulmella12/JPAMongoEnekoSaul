package DAO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name="Departamento")
@NamedQuery(name = "Departamento.findAll", query = "Select d from Departamento d")
@Data
public class Departamento {

    @Id private long _id = ObjectId.getCurrentCounter();
    @ElementCollection private List<Long> enCurso;
    @Column private String nombre;
    @Column private long idJefe;
    @Column private double presupuesto;
    @ElementCollection private List<Long> finalizados;
    @ElementCollection private List<Long> jefes;

    public Departamento(List<Long> enCurso, String nombre, long idJefe, double presupuesto, List<Long> finalizados, List<Long> jefes) {
        this.enCurso = enCurso;
        this.nombre = nombre;
        this.idJefe = idJefe;
        this.presupuesto = presupuesto;
        this.finalizados = finalizados;
        this.jefes = jefes;
    }
}
