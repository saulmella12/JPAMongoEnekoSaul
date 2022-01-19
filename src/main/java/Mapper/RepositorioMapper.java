package Mapper;

import DTO.RepositorioDTO;
import DAO.Repositorio;
import Repository.ProyectoRepository;

public class RepositorioMapper {
    public RepositorioDTO toDTO(Repositorio r){
        RepositorioDTO dto = new RepositorioDTO();
        ProyectoRepository pr = new ProyectoRepository();
        dto.setId(r.getId());
        dto.setNombre(r.getNombre());
        dto.setIdProyecto(pr.selectProyectoById(r.getIdProyecto()));
        dto.setFecha(r.getFecha());
        dto.setCommits(r.getCommits());
        dto.setIssues(r.getIssues());
        return dto;
    }

    public Repositorio toDAO(RepositorioDTO r){
        Repositorio repositorio = new Repositorio();
        ProyectoRepository pr = new ProyectoRepository();
        repositorio.setId(r.getId());
        repositorio.setNombre(r.getNombre());
        repositorio.setIdProyecto(r.getIdProyecto().getId());
        repositorio.setFecha(r.getFecha());
        repositorio.setCommits(r.getCommits());
        repositorio.setIssues(r.getIssues());
        return repositorio;
    }
}
