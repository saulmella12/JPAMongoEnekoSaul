package Mapper;

import DTO.DepartamentoDTO;
import DTO.ProgramadorDTO;
import DAO.Programador;
import Repository.*;

public class ProgramadorMapper {
    public ProgramadorDTO toDTO(Programador p){
        ProgramadorDTO dto = new ProgramadorDTO();
        DepartamentoRepository dr = new DepartamentoRepository();
        ProyectoRepository pr = new ProyectoRepository();
        CommitRepository cr = new CommitRepository();
        IssueRepository ir = new IssueRepository();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setAlta(p.getAlta());
        dto.setSalario(p.getSalario());
        dto.setUsuario(p.getUsuario());
        dto.setPasswd(p.getPasswd());
        dto.setDepartamento(dr.selectDepartamentoById(p.getIdDepartamento()));
        dto.setProyectos(p.getProyectos());
        dto.setCommits(p.getCommits()));
        dto.setIssues(p.getIssues()));
        dto.setTecnologias(p.getTecnologias());
        return dto;
    }

    public Programador toDAO(ProgramadorDTO p){
        Programador programador = new Programador();
        DepartamentoRepository dr = new DepartamentoRepository();
        ProyectoRepository pr = new ProyectoRepository();
        CommitRepository cr = new CommitRepository();
        IssueRepository ir = new IssueRepository();
        programador.setId(p.getId());
        programador.setNombre(p.getNombre());
        programador.setAlta(p.getAlta());
        programador.setSalario(p.getSalario());
        programador.setPasswd(p.getPasswd());
        programador.setUsuario(p.getUsuario());
        programador.setIdDepartamento(p.getDepartamento().getId());
        programador.setProyectos(p.getProyectos());
        programador.setCommits(p.getCommits());
        programador.setIssues(p.getIssues()));
        programador.setTecnologias(p.getTecnologias());


        if(checkProgramadorJefe(programador)) {
            return programador;
        }else return null;
    }

    private boolean checkProgramadorJefe(Programador p){
        ProyectoRepository pr = new ProyectoRepository();
        DepartamentoRepository dr = new DepartamentoRepository();

        return pr.selectAll().stream().noneMatch(x -> x.getJefe().equals(p)) &&
                dr.selectAll().stream().noneMatch(x -> x.getJefe().equals(p));
    }
}
