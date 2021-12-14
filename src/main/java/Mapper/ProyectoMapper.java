package Mapper;

import DTO.ProyectoDTO;
import Model.Proyecto;

public class ProyectoMapper {
    public ProyectoDTO toDTO(Proyecto c){
        ProyectoDTO dto = new ProyectoDTO();
        dto.setId(c.getId());
        dto.setTermiando(c.isTermiando());
        dto.setJefe(c.getJefe());
        dto.setNombre(c.getNombre());
        dto.setPresupuesto(c.getPresupuesto());
        dto.setFechaFin(c.getFechaFin());
        dto.setFechaInicio(c.getFechaInicio());
        return dto;
    }

    public Proyecto toModel(ProyectoDTO c){
        Proyecto proyecto = new Proyecto();
        proyecto.setId(c.getId());
        proyecto.setTermiando(c.isTermiando());
        proyecto.setJefe(c.getJefe());
        proyecto.setNombre(c.getNombre());
        proyecto.setPresupuesto(c.getPresupuesto());
        proyecto.setFechaFin(c.getFechaFin());
        proyecto.setFechaInicio(c.getFechaInicio());
        return proyecto;
    }
}
