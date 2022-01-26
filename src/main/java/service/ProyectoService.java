package service;

import DTO.ProyectoDTO;
import Mapper.ProyectoMapper;
import Repository.ProyectoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProyectoService {
    ProyectoMapper mapper = new ProyectoMapper();
    ProyectoRepository repository = new ProyectoRepository();

    public List<ProyectoDTO> getAllProyectos(){
        return repository.selectAll().stream().map(v->mapper.toDTO(v)).collect(Collectors.toList());
    }

    public ProyectoDTO getProyectoById(long id){
        return (ProyectoDTO) repository.selectProyectoById(id).stream().map(v->mapper.toDTO(v));
    }
}
