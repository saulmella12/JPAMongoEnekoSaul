package DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@NamedQuery(name = "PivotePP.findAll", query = "Select p from PivotePP p")
public class PivotePP {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private ObjectId _id;
    @Column private long idProgramador;
    @Column private long idProyecto;

    public PivotePP(long idProgramador, long idProyecto) {
        this.idProgramador = idProgramador;
        this.idProyecto = idProyecto;
    }
}