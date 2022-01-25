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

    public RepositorioDTO toDTO(Repositorio r) throws Exception {
        RepositorioDTO dto = new RepositorioDTO();

        dto.setId(r.getId());
        dto.setNombre(r.getNombre());
        dto.setIdProyecto(pm.toDTO(pr.selectProyectoById(r.getIdProyecto())));
        dto.setFecha(r.getFecha());
        dto.setCommits(r.getCommits().stream().map(this::getCommit).collect(Collectors.toList()));
        dto.setIssues(r.getIssues().stream().map(this::getIssue).collect(Collectors.toList()));
        return dto;
    }

    public Repositorio toDAO(RepositorioDTO r){
        Repositorio repositorio = new Repositorio();

        repositorio.setId(r.getId());
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

        CommitDTO dto = null;
        try{
            Commits c = cr.selectCommitById(id);
            dto =  cm.toDTO(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    private IssueDTO getIssue(long id){
        IssueDTO dto = null;
        try{
            Issue i = ir.selectIssueById(id);
            dto =  im.toDTO(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }
}
