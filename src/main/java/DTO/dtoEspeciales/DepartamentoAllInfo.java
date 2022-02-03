package DTO.dtoEspeciales;

import java.util.List;

public class DepartamentoAllInfo {
    private long id;
    private String nombre;
    private ProgramadorLessInfo jefe;
    private double presupuesto;
    private List<ProyectoAllInfo> enCurso;
    private List<ProyectoAllInfo> finalizados;
    private List<Long> jefes;

    public DepartamentoAllInfo(long id, String nombre, ProgramadorLessInfo jefe, double presupuesto, List<ProyectoAllInfo> enCurso, List<ProyectoAllInfo> finalizados, List<Long> jefes) {
        this.id = id;
        this.nombre = nombre;
        this.jefe = jefe;
        this.presupuesto = presupuesto;
        this.enCurso = enCurso;
        this.finalizados = finalizados;
        this.jefes = jefes;
    }
}