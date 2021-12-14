package Mapper;

import DTO.RepositorioDTO;
import Model.Repositorio;

public class RepositorioMapper {
    public RepositorioDTO toDTO(Repositorio r){
        RepositorioDTO dto = new RepositorioDTO();
        dto.setId(r.getId());
        dto.setNombre(r.getNombre());
        dto.setIssues(r.getIssues());
        dto.setFecha(r.getFecha());
        dto.setCommits(r.getCommits());
        dto.setProyecto(r.getProyecto());
        return dto;
    }

    public Repositorio toModel(RepositorioDTO r){
        Repositorio repositorio = new Repositorio();
        repositorio.setId(r.getId());
        repositorio.setNombre(r.getNombre());
        repositorio.setIssues(r.getIssues());
        repositorio.setFecha(r.getFecha());
        repositorio.setCommits(r.getCommits());
        repositorio.setProyecto(r.getProyecto());
        return repositorio;
    }
}
