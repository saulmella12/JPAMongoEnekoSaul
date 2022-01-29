package Mapper;

import DAO.Commits;
import DAO.Issue;
import DTO.CommitDTO;
import DTO.IssueDTO;
import DTO.RepositorioDTO;
import DAO.Repositorio;
import Repository.CommitRepository;
import Repository.IssueRepository;
import Repository.ProyectoRepository;

import java.util.stream.Collectors;

public class RepositorioMapper {

    private ProyectoRepository pr = new ProyectoRepository();
    private ProyectoMapper pm = new ProyectoMapper();
    private CommitMapper cm = new CommitMapper();
    private IssueMapper im = new IssueMapper();
    private IssueRepository ir = new IssueRepository();
    private CommitRepository cr = new CommitRepository();

    public RepositorioDTO toDTO(Repositorio r) {
        RepositorioDTO dto = new RepositorioDTO();

        dto.setId(r.get_id());
        dto.setNombre(r.getNombre());
        dto.setFecha(r.getFecha());
        dto.setCommits(r.getCommits().stream().map(this::getCommit).collect(Collectors.toList()));
        dto.setIssues(r.getIssues().stream().map(this::getIssue).collect(Collectors.toList()));
        dto.setIdProyecto(pm.toDTO(pr.selectProyectoById(r.getIdProyecto()).get()));

        return dto;
    }

    public Repositorio toDAO(RepositorioDTO r){
        Repositorio repositorio = new Repositorio();

        repositorio.set_id(r.getId());
        repositorio.setNombre(r.getNombre());
        repositorio.setIdProyecto(r.getIdProyecto().getId());
        repositorio.setFecha(r.getFecha());
        repositorio.setCommits(r.getCommits().stream().map(this::getCommitId).collect(Collectors.toList()));
        repositorio.setIssues(r.getIssues().stream().map(this::getIssueId).collect(Collectors.toList()));
        return repositorio;
    }

    private long getCommitId(CommitDTO c){
        return c.getId();
    }

    private long getIssueId(IssueDTO i){
        return i.getId();
    }

    private CommitDTO getCommit(long id){

        Commits c = cr.selectCommitById(id).get();
        CommitDTO dto =  cm.toDTO(c);

        return dto;
    }

    private IssueDTO getIssue(long id){

        Issue i = ir.selectIssueById(id).get();
        IssueDTO dto =  im.toDTO(i);
        return dto;
    }
}
