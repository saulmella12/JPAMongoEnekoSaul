package DAO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="Programador")
@NamedQuery(name = "Programador.findAll", query = "Select p from Programador p")
public class Programador {
    @Id private long _id = ObjectId.getCurrentCounter();
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Programador programador = (Programador) o;

        if (_id != programador._id) return false;
        return nombre != null ? nombre.equals(programador.nombre) : programador.nombre == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (_id ^ (_id >>> 32));
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Programador{" +
                "_id=" + _id +
                ", nombre='" + nombre + '\'' +
                ", alta='" + alta + '\'' +
                ", salario=" + salario +
                ", usuario='" + usuario + '\'' +
                ", passwd='" + passwd + '\'' +
                ", idDepartamento=" + idDepartamento +
                ", commits=" + commits +
                ", issues=" + issues +
                ", tecnologias=" + tecnologias +
                '}';
    }
}
