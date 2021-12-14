package Mapper;

import DTO.DepartamentoDTO;
import Model.Departamento;

public class DepartamentoMapper {
    public DepartamentoDTO toDTO(Departamento c){
        DepartamentoDTO dto = new DepartamentoDTO();
        dto.setId(c.getId());
        dto.setNombre(c.getNombre());
        dto.setPresupuesto(c.getPresupuesto());
        dto.setJefe(c.getJefe());
        dto.setFinalizados(c.getFinalizados());
        dto.setProyectos(c.getProyectos());
        return dto;
    }

    public Departamento toModel(DepartamentoDTO c){
        Departamento departamento = new Departamento();
        departamento.setId(c.getId());
        departamento.setNombre(c.getNombre());
        departamento.setPresupuesto(c.getPresupuesto());
        departamento.setJefe(c.getJefe());
        departamento.setFinalizados(c.getFinalizados());
        departamento.setProyectos(c.getProyectos());
        return departamento;
    }
}
