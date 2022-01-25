package Mapper;

import DAO.Commits;
import DAO.Issue;
import DAO.Proyecto;
import DTO.*;
import DAO.Programador;
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

    public ProgramadorDTO toDTO(Programador p) throws Exception {
        ProgramadorDTO dto = new ProgramadorDTO();

        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setAlta(p.getAlta());
        dto.setSalario(p.getSalario());
        dto.setUsuario(p.getUsuario());
        dto.setPasswd(p.getPasswd());
        dto.setDepartamento(dm.toDTO(dr.selectDepartamentoById(p.getIdDepartamento())));
        dto.setProyectos(p.getProyectos().stream().map(this::getProyecto).collect(Collectors.toList()));
        dto.setCommits(p.getCommits().stream().map(this::getCommit).collect(Collectors.toList()));
        dto.setIssues(p.getIssues().stream().map(this::getIssue).collect(Collectors.toList()));
        dto.setTecnologias(p.getTecnologias());

        return dto;
    }

    public Programador toDAO(ProgramadorDTO p){
        Programador programador = new Programador();

        programador.setId(p.getId());
        programador.setNombre(p.getNombre());
        programador.setAlta(p.getAlta());
        programador.setSalario(p.getSalario());
        programador.setPasswd(p.getPasswd());
        programador.setUsuario(p.getUsuario());
        programador.setIdDepartamento(p.getDepartamento().getId());
        programador.setProyectos(p.getProyectos().stream().map(this::getProyectoId).collect(Collectors.toList()));
        programador.setCommits(p.getCommits().stream().map(this::getCommitId).collect(Collectors.toList()));
        programador.setIssues(p.getIssues().stream().map(this::getIssueId).collect(Collectors.toList()));
        programador.setTecnologias(p.getTecnologias());

        return programador;
    }

    private ProyectoDTO getProyecto(long id){

        ProyectoDTO dto = null;
        try{
            Proyecto proje = pr.selectProyectoById(id);
            dto = pm.toDTO(proje);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    private CommitDTO getCommit(long id) {

        CommitDTO dto = null;
        try{
            Commits c = cr.selectCommitById(id);
            dto = cm.toDTO(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    private IssueDTO getIssue(long id) {
        IssueDTO dto = null;
        try{
            Issue sorun = ir.selectIssueById(id);
            dto = im.toDTO(sorun);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    private long getProyectoId(ProyectoDTO p){
        return p.getId();
    }

    private long getCommitId(CommitDTO c){ return c.getId(); }

    private long getIssueId(IssueDTO i){
        return i.getId();
    }
}
