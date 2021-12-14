package Mapper;

import DTO.CommitDTO;
import Model.Commits;
import Model.Issue;
import Model.Programador;
import Repository.IssueRepository;

public class CommitMapper {

    public CommitDTO toDTO(Commits c){
        CommitDTO dto = new CommitDTO();
        dto.setFecha(c.getFecha());
        dto.setId(c.getId());
        dto.setBase(c.getBase());
        dto.setCreador(c.getCreador());
        dto.setTexto(c.getTexto());
        dto.setTitulo(c.getTitulo());
        return dto;
    }

    public Commits toModel(CommitDTO c){
        Commits commit = new Commits();
        commit.setFecha(c.getFecha());
        commit.setId(c.getId());
        commit.setBase(c.getBase());
        commit.setCreador(c.getCreador());
        commit.setTexto(c.getTexto());
        commit.setTitulo(c.getTitulo());

        if(validateCommit(commit.getCreador(),commit.getBase())) {
            return commit;
        }
        return null;
    }

    private boolean validateCommit(Programador p, Issue i){
        IssueRepository ir = new IssueRepository();

        return ir.selectById(i.getId()).getProgramadores().contains(p);
    }
}
