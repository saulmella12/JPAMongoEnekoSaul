package Mapper;

import DTO.IssueDTO;
import DTO.ProgramadorDTO;
import Model.Issue;
import Model.Programador;
import Repository.DepartamentoRepository;
import Repository.ProyectoRepository;

import java.util.stream.Collectors;

public class ProgramadorMapper {
    public ProgramadorDTO toDTO(Programador p){
        ProgramadorDTO dto = new ProgramadorDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setSalario(p.getSalario());
        dto.setCommits(p.getCommits());
        dto.setAlta(p.getAlta());
        dto.setIssues(p.getIssues());
        dto.setPasswd(p.getPasswd());
        dto.setProyectos(p.getProyectos());
        dto.setUsuario(p.getUsuario());
        return dto;
    }

    public Programador toModel(ProgramadorDTO p){
        Programador programador = new Programador();

        programador.setId(p.getId());
        programador.setNombre(p.getNombre());
        programador.setSalario(p.getSalario());
        programador.setCommits(p.getCommits());
        programador.setAlta(p.getAlta());
        programador.setIssues(p.getIssues());
        programador.setPasswd(p.getPasswd());
        programador.setProyectos(p.getProyectos());
        programador.setUsuario(p.getUsuario());

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
