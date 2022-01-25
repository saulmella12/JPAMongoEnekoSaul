package Mapper;

import DTO.ProyectoDTO;
import DAO.Proyecto;
import Repository.ProgramadorRepository;

public class ProyectoMapper {

    private ProgramadorRepository pr = new ProgramadorRepository();
    private ProgramadorMapper pm = new ProgramadorMapper();

    public ProyectoDTO toDTO(Proyecto c) throws Exception {

        ProyectoDTO dto = new ProyectoDTO();
        dto.setId(c.getId());
        dto.setTermiando(c.isTermiando());
        dto.setJefe(pm.toDTO(pr.selectProgramadorById(c.getIdJefe())));
        dto.setNombre(c.getNombre());
        dto.setPresupuesto(c.getPresupuesto());
        dto.setFechaInicio(c.getFechaInicio());
        dto.setFechaFin(c.getFechaFin());
        dto.setTecnologias(c.getTecnologias());

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

        return proyecto;
    }
}
