package DAO;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="Proyecto")
public class Proyecto {
    @Id private long id;
    @Column private boolean termiando;
    @Column private long idJefe;
    @Column private String nombre;
    @Column private double presupuesto;
    @Column private String fechaInicio;
    @Column private String fechaFin;
    @ElementCollection private List<String> tecnologias;
}
