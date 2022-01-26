package service;

import DTO.IssueDTO;
import Mapper.IssueMapper;
import Repository.IssueRepository;

import java.util.List;
import java.util.stream.Collectors;

public class IssueService {
    IssueMapper mapper = new IssueMapper();
    IssueRepository repository = new IssueRepository();

    public List<IssueDTO> getAllIssues(){
        return repository.selectAll().stream().map(v->mapper.toDTO(v)).collect(Collectors.toList());
    }

    public IssueDTO getIssueById(long id){
        return (IssueDTO) repository.selectIssueById(id).stream().map(v->mapper.toDTO(v));
    }
}
