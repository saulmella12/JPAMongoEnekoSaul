package DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@NamedQuery(name = "PivotePP.findAll", query = "Select p from PivotePP p")
public class PivotePP {
    @GeneratedValue @Id private Long id;
    @Column private long idProgramador;
    @Column private long idProyecto;

    public PivotePP(long idProgramador, long idProyecto) {
        this.idProgramador = idProgramador;
        this.idProyecto = idProyecto;
    }
}