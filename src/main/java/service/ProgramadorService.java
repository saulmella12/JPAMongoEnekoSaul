package service;

import DAO.Programador;
import DTO.ProgramadorDTO;
import Mapper.ProgramadorMapper;
import Repository.ProgramadorRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProgramadorService {
    ProgramadorMapper mapper = new ProgramadorMapper();
    ProgramadorRepository repository = new ProgramadorRepository();

    public List<ProgramadorDTO> getAllProgramadores(){
        return repository.selectAll().stream().map(v->mapper.toDTO(v)).collect(Collectors.toList());
    }

    public ProgramadorDTO getProgramadorById(long id){
        return (ProgramadorDTO) repository.selectProgramadorById(id).stream().map(v->mapper.toDTO(v));
    }

    public ProgramadorDTO postProgramador(ProgramadorDTO programadorDTO){
        Programador p = repository.insert(mapper.toDAO(programadorDTO));
        return mapper.toDTO(p);
    }

    public ProgramadorDTO updateProgramador(ProgramadorDTO programadorDTO){
        Programador p = repository.update(mapper.toDAO(programadorDTO));
        return mapper.toDTO(p);
    }

    public ProgramadorDTO deleteProgramador(ProgramadorDTO programadorDTO){
        Programador p = repository.delete(mapper.toDAO(programadorDTO));
        return mapper.toDTO(p);
    }
}
