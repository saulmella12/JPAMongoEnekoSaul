package DTO.dtoEspeciales;

import java.util.List;

public class ProyectoAllInfo {
    private long id;
    private boolean termiando;
    private ProgramadorLessInfo jefe;
    private String nombre;
    private double presupuesto;
    private String fechaInicio;
    private String fechaFin;
    private List<String> tecnologias;
    private List<ProgramadorLessInfo> programadores;

    public ProyectoAllInfo(long id, boolean termiando, ProgramadorLessInfo jefe, String nombre, double presupuesto, String fechaInicio, String fechaFin, List<String> tecnologias, List<ProgramadorLessInfo> programadores) {
        this.id = id;
        this.termiando = termiando;
        this.jefe = jefe;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tecnologias = tecnologias;
        this.programadores = programadores;
    }
}
