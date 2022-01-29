package Mapper;

import DAO.*;
import DTO.*;
import Repository.*;

import java.util.List;
import java.util.stream.Collectors;

public class ProgramadorMapper {

    private DepartamentoRepository dr = new DepartamentoRepository();
    private ProyectoRepository pr = new ProyectoRepository();
    private CommitRepository cr = new CommitRepository();
    private IssueRepository ir = new IssueRepository();
    private ProyectoMapper pm = new ProyectoMapper();
    private CommitMapper cm = new CommitMapper();
    private IssueMapper im = new IssueMapper();
    private DepartamentoMapper dm = new DepartamentoMapper();
    private PivoteRepository pivr = new PivoteRepository();

    public ProgramadorDTO toDTO(Programador p){
        ProgramadorDTO dto = new ProgramadorDTO();

        dto.setId(p.get_id());
        dto.setNombre(p.getNombre());
        dto.setAlta(p.getAlta());
        dto.setSalario(p.getSalario());
        dto.setUsuario(p.getUsuario());
        dto.setPasswd(p.getPasswd());
        dto.setDepartamento(dm.toDTO(dr.selectDepartamentoById(p.getIdDepartamento()).get()));
        dto.setProyectos(getProyectos(p.get_id()));
        dto.setCommits(p.getCommits().stream().map(this::getCommit).collect(Collectors.toList()));
        dto.setIssues(p.getIssues().stream().map(this::getIssue).collect(Collectors.toList()));
        dto.setTecnologias(p.getTecnologias());

        return dto;
    }

    public Programador toDAO(ProgramadorDTO p){
        Programador programador = new Programador();

        programador.set_id(p.getId());
        programador.setNombre(p.getNombre());
        programador.setAlta(p.getAlta());
        programador.setSalario(p.getSalario());
        programador.setPasswd(p.getPasswd());
        programador.setUsuario(p.getUsuario());
        programador.setIdDepartamento(p.getDepartamento().getId());
        programador.setCommits(p.getCommits().stream().map(this::getCommitId).collect(Collectors.toList()));
        programador.setIssues(p.getIssues().stream().map(this::getIssueId).collect(Collectors.toList()));
        programador.setTecnologias(p.getTecnologias());

        insertIntoPivote(p.getProyectos().stream().map(this::getProyectoId).collect(Collectors.toList()), p.getId());
        return programador;
    }

    private ProyectoDTO getProyecto(long id){
        Proyecto proje = pr.selectProyectoById(id).get();
        ProyectoDTO dto = pm.toDTO(proje);

        return dto;
    }

    private CommitDTO getCommit(long id) {

        Commits c = cr.selectCommitById(id).get();
        CommitDTO dto = cm.toDTO(c);

        return dto;
    }

    private IssueDTO getIssue(long id) {
        Issue sorun = ir.selectIssueById(id).get();
        IssueDTO dto = im.toDTO(sorun);
        return dto;
    }

    private List<ProyectoDTO> getProyectos(long id){
        return pivr.getProyectoFromProgramador(id).stream().map(this::getProyecto).collect(Collectors.toList());
    }

    private long getProyectoId(ProyectoDTO p){
        return p.getId();
    }

    private long getCommitId(CommitDTO c){ return c.getId(); }

    private long getIssueId(IssueDTO i){
        return i.getId();
    }

    private void insertIntoPivote(List<Long> proyectos,long programador){
        proyectos.forEach(v->pivr.insert(new PivotePP(programador,v)));
    }
}
