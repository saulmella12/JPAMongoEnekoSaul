package Mapper;

import DAO.Proyecto;
import DTO.DepartamentoDTO;
import DAO.Departamento;
import DTO.ProyectoDTO;
import Repository.ProgramadorRepository;
import Repository.ProyectoRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DepartamentoMapper {

    private ProyectoRepository pr = new ProyectoRepository();
    private ProgramadorRepository ppr = new ProgramadorRepository();
    private ProyectoMapper pm = new ProyectoMapper();
    private ProgramadorMapper ppm = new ProgramadorMapper();

    public DepartamentoDTO toDTO(Departamento c) throws Exception {
        DepartamentoDTO dto = new DepartamentoDTO();
        dto.setId(c.getId());
        dto.setEnCurso(pr.selectSegunEstado(dto.getId(),true).stream().map(this::proyectoDAOtoDTO).collect(Collectors.toList()));
        dto.setNombre(c.getNombre());
        dto.setJefe(ppm.toDTO(ppr.selectProgramadorById(c.getIdJefe())));
        dto.setPresupuesto(c.getPresupuesto());
        dto.setFinalizados(pr.selectSegunEstado(dto.getId(),false).stream().map(this::proyectoDAOtoDTO).collect(Collectors.toList()));
        dto.setJefes(c.getJefes());
        return dto;
    }

    public Departamento toDAO(DepartamentoDTO c){
        Departamento departamento = new Departamento();
        List<Long> enCurso = c.getEnCurso().stream().map(this::getIds).collect(Collectors.toList());
        List<Long> finalizados = c.getFinalizados().stream().map(this::getIds).collect(Collectors.toList());

        departamento.setId(c.getId());
        departamento.setEnCurso(enCurso);
        departamento.setNombre(c.getNombre());
        departamento.setIdJefe(c.getJefe().getId());
        departamento.setPresupuesto(c.getPresupuesto());
        departamento.setFinalizados(finalizados);
        departamento.setJefes(c.getJefes());

        return departamento;
    }

    private long getIds(ProyectoDTO p){
        return p.getId();
    }

    private ProyectoDTO proyectoDAOtoDTO(Proyecto p){
        ProyectoDTO dto = null;
        try {
            dto =  pm.toDTO(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }
}
