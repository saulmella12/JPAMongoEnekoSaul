package Mapper;

import DAO.PivotePP;
import DAO.Programador;
import DTO.ProgramadorDTO;
import DTO.ProyectoDTO;
import DAO.Proyecto;
import Repository.PivoteRepository;
import Repository.ProgramadorRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProyectoMapper {

    private ProgramadorRepository pr = new ProgramadorRepository();
    private ProgramadorMapper pm = new ProgramadorMapper();
    private PivoteRepository pivr = new PivoteRepository();

    public ProyectoDTO toDTO(Proyecto c)  {

        ProyectoDTO dto = new ProyectoDTO();
        dto.setId(c.getId());
        dto.setTermiando(c.isTermiando());
        dto.setJefe(pm.toDTO(pr.selectProgramadorById(c.getIdJefe()).get()));
        dto.setNombre(c.getNombre());
        dto.setPresupuesto(c.getPresupuesto());
        dto.setFechaInicio(c.getFechaInicio());
        dto.setFechaFin(c.getFechaFin());
        dto.setTecnologias(c.getTecnologias());
        dto.setProgramadores(getProgramadores(c.getId()));

        return dto;
    }

    public Proyecto toDAO(ProyectoDTO c){
        Proyecto proyecto = new Proyecto();
        proyecto.setId(c.getId());
        proyecto.setTermiando(c.isTermiando());
        proyecto.setIdJefe(c.getJefe().getId());
        proyecto.setNombre(c.getNombre());
        proyecto.setPresupuesto(c.getPresupuesto());
        proyecto.setFechaInicio(c.getFechaInicio());
        proyecto.setFechaFin(c.getFechaFin());
        proyecto.setTecnologias(c.getTecnologias());
        insertIntoPivote(c.getProgramadores().stream().map(this::getProgramadorId).collect(Collectors.toList()), c.getId());

        return proyecto;
    }

    private List<ProgramadorDTO> getProgramadores(long id){
        return pivr.getProgramadorFromProyecto(id).stream().map(this::getProgramador).collect(Collectors.toList());
    }

    private ProgramadorDTO getProgramador(long id){
        Programador p = pr.selectProgramadorById(id).get();
        ProgramadorDTO dto = pm.toDTO(p);

        return dto;
    }

    private void insertIntoPivote(List<Long> programadores,long proyecto){
        programadores.forEach(v->pivr.insert(new PivotePP(1L,v,proyecto)));
    }

    private long getProgramadorId(ProgramadorDTO p){
        return p.getId();
    }
}
