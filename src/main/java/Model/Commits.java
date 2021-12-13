package Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Commits")
public class Commits {
    private long id;
    private String titulo;
    private String texto;
    private String fecha;
    private Programador creador;
    private Issue base;

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Column
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Column
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @ManyToOne
    public Programador getCreador() {
        return creador;
    }

    public void setCreador(Programador creador) {
        this.creador = creador;
    }

    @ManyToOne
    public Issue getBase() {
        return base;
    }

    public void setBase(Issue base) {
        this.base = base;
    }

    public Commits(){}

    public Commits(long id, String titulo, String texto, String fecha, Programador creador, Issue base) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.fecha = fecha;
        this.creador = creador;
        this.base = base;
    }
}
