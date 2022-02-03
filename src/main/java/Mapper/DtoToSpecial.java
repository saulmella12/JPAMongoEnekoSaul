package Mapper;

import DTO.DepartamentoDTO;
import DTO.IssueDTO;
import DTO.ProgramadorDTO;
import DTO.ProyectoDTO;
import DTO.dtoEspeciales.DepartamentoAllInfo;
import DTO.dtoEspeciales.ProgramadorLessInfo;
import DTO.dtoEspeciales.ProyectOnlyIssues;
import DTO.dtoEspeciales.ProyectoAllInfo;

import java.util.List;
import java.util.stream.Collectors;

public class DtoToSpecial {

    private static DtoToSpecial especial = null;
    private DtoToSpecial(){}

    public static DtoToSpecial getInstance(){
        if(especial==null){
            especial = new DtoToSpecial();
        }
        return especial;
    }

    public ProyectoAllInfo allInfo(ProyectoDTO p){
        return new ProyectoAllInfo(p.getId(),p.isTermiando(),toPLI(p.getJefe()),p.getNombre(),p.getPresupuesto(),p.getFechaInicio(),p.getFechaFin(),p.getTecnologias()
                ,p.getProgramadores().stream().map(this::toPLI).collect(Collectors.toList()));
    }

    private ProgramadorLessInfo toPLI(ProgramadorDTO p){
        return new ProgramadorLessInfo(p.getId(),p.getNombre(),p.getAlta(),p.getSalario(),p.getTecnologias());
    }

    public DepartamentoAllInfo toDAI(DepartamentoDTO d){
        return new DepartamentoAllInfo(d.getId(),d.getNombre(),toPLI(d.getJefe()),d.getPresupuesto(),
                d.getEnCurso().stream().map(this::allInfo).collect(Collectors.toList()),
                d.getFinalizados().stream().map(this::allInfo).collect(Collectors.toList()),
                d.getJefes());
    }
    public IssueLessInfo toILI(IssueDTO issue){
        return new IssueLessInfo(issue.getId(),issue.getTitulo(),issue.getTexto(),issue.getFecha(),issue.isTerminado());
    }

    public ProyectOnlyIssues toPOI(IssueDTO issue, long idProyecto){
        return new ProyectOnlyIssues(List.of(toILI(issue)),idProyecto);
    }
}
