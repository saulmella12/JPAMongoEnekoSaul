package DTO.dtoEspeciales;

import java.util.List;

public class ProgramadorLessInfo {
    private long id;
    private String nombre;
    private String alta;
    private double salario;
    private List<String> tecnologias;

    public ProgramadorLessInfo(long id, String nombre, String alta, double salario, List<String> tecnologias) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
        this.salario = salario;
        this.tecnologias = tecnologias;
    }
}
