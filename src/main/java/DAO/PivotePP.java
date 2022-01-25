package DAO;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@Data
@NamedQuery(name = "PivotePP.findAll", query = "Select p from PivotePP p")
public class PivotePP {
    @Id private Long id;
    @Column private long idProgramador;
    @Column private long idProyecto;
}