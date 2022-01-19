package Mapper;

import DTO.ProyectoDTO;
import DAO.Proyecto;

public class ProyectoMapper {
    public ProyectoDTO toDTO(Proyecto c){
        ProyectoDTO dto = new ProyectoDTO();
        dto.setId(c.getId());
        dto.setTermiando(c.isTermiando());
        dto.setJefe(c.getJefe());
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
        proyecto.setIdJefe(c.getJefe());
        proyecto.setNombre(c.getNombre());
        proyecto.setPresupuesto(c.getPresupuesto());
        proyecto.setFechaInicio(c.getFechaInicio());
        proyecto.setFechaFin(c.getFechaFin());
        proyecto.setTecnologias(c.getTecnologias());

        return proyecto;
    }
}
