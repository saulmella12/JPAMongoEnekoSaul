package DAO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="Proyecto")
@NamedQuery(name = "Proyecto.findAll", query = "Select py from Proyecto py")
public class Proyecto {
    @Id private long _id = ObjectId.getCurrentCounter();
    @Column private boolean termiando;
    @Column private long idJefe;
    @Column private String nombre;
    @Column private double presupuesto;
    @Column private String fechaInicio;
    @Column private String fechaFin;
    @ElementCollection private List<String> tecnologias;
    @Column private long departamento;

    public Proyecto(boolean termiando, long idJefe, String nombre, double presupuesto, String fechaInicio, String fechaFin, List<String> tecnologias, long departamento) {
        this.termiando = termiando;
        this.idJefe = idJefe;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tecnologias = tecnologias;
        this.departamento = departamento;
    }
}
