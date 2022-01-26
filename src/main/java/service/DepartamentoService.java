package service;

import DTO.DepartamentoDTO;
import Mapper.DepartamentoMapper;
import Repository.DepartamentoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DepartamentoService {
    DepartamentoMapper mapper = new DepartamentoMapper();
    DepartamentoRepository repository = new DepartamentoRepository();

    public List<DepartamentoDTO> getAllDepartamentos(){
        return repository.selectAll().stream().map(v->mapper.toDTO(v)).collect(Collectors.toList());
    }

    public DepartamentoDTO getDepartamentoById(long id){
        return (DepartamentoDTO) repository.selectDepartamentoById(id).stream().map(v->mapper.toDTO(v));
    }
}
