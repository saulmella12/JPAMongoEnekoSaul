package service;

import DAO.Commits;
import DAO.Repositorio;
import DTO.RepositorioDTO;
import Mapper.RepositorioMapper;
import Repository.RepositorioRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioService {
    RepositorioMapper mapper = new RepositorioMapper();
    RepositorioRepository repository = new RepositorioRepository();

    public List<RepositorioDTO> getAllRepositorios(){
        return repository.selectAll().stream().map(v->mapper.toDTO(v)).collect(Collectors.toList());
    }

    public RepositorioDTO getRepositorioById(long id){
        return (RepositorioDTO) repository.selectRepositorioById(id).stream().map(v->mapper.toDTO(v));
    }

    public RepositorioDTO postRepositorio(RepositorioDTO repositorioDTO){
        Repositorio r = repository.insert(mapper.toDAO(repositorioDTO));
        return mapper.toDTO(r);
    }

    public RepositorioDTO updateRepositorio(RepositorioDTO repositorioDTO){
        Repositorio r = repository.update(mapper.toDAO(repositorioDTO));
        return mapper.toDTO(r);
    }

    public RepositorioDTO deleteRepositorio(RepositorioDTO repositorioDTO){
        Repositorio c = repository.delete(mapper.toDAO(repositorioDTO));
        return mapper.toDTO(c);
    }
}
