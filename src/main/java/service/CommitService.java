package service;

import DAO.Commits;
import DTO.CommitDTO;
import Mapper.CommitMapper;
import Repository.CommitRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CommitService {
    CommitMapper mapper = new CommitMapper();
    CommitRepository repository = new CommitRepository();

    public List<CommitDTO> getAllCommits() {
        return repository.selectAll().stream().map(v->mapper.toDTO(v)).collect(Collectors.toList());
    }

    public CommitDTO getCommitById(long id){
        return (CommitDTO) repository.selectCommitById(id).stream().map(v->mapper.toDTO(v));
    }

    public CommitDTO postCommit(CommitDTO commitDTO){
        Commits c = repository.insert(mapper.toDAO(commitDTO));
        return mapper.toDTO(c);
    }

    public CommitDTO updateCommit(CommitDTO commitDTO){
        Commits c = repository.update(mapper.toDAO(commitDTO));
        return mapper.toDTO(c);
    }

    public CommitDTO deleteCommit(CommitDTO commitDTO){
        Commits c = repository.delete(mapper.toDAO(commitDTO));
        return mapper.toDTO(c);
    }
}
