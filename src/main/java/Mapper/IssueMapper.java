package Mapper;

import DTO.IssueDTO;
import Model.Issue;

public class IssueMapper {public IssueDTO toDTO(Issue c){
    IssueDTO dto = new IssueDTO();
    dto.setId(c.getId());
    dto.setTitulo(c.getTitulo());
    dto.setTexto(c.getTexto());
    dto.setFecha(c.getFecha());
    dto.setProgramadores(c.getProgramadores());
    dto.setCommits(c.getCommits());
    dto.setTermiando(c.isTermiando());
    dto.setProyecto(c.getProyecto());
    return dto;
}

    public Issue toModel(IssueDTO c){
        Issue issue = new Issue();
        issue.setId(c.getId());
        issue.setTitulo(c.getTitulo());
        issue.setTexto(c.getTexto());
        issue.setFecha(c.getFecha());
        issue.setProgramadores(c.getProgramadores());
        issue.setCommits(c.getCommits());
        issue.setTermiando(c.isTermiando());
        issue.setProyecto(c.getProyecto());
        return issue;
    }
}
