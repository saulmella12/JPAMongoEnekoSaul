package Mapper;

import DTO.CommitDTO;
import DTO.IssueDTO;
import DAO.Issue;
import DTO.ProgramadorDTO;
import Repository.CommitRepository;
import Repository.ProgramadorRepository;
import Repository.ProyectoRepository;
import Repository.RepositorioRepository;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IssueMapper {

    private ProgramadorRepository pr = new ProgramadorRepository();
    private CommitRepository cr = new CommitRepository();
    private ProyectoRepository ppr = new ProyectoRepository();
    private RepositorioRepository rr = new RepositorioRepository();
    private ProyectoMapper pm = new ProyectoMapper();
    private CommitMapper cm = new CommitMapper();
    private ProgramadorMapper ppm = new ProgramadorMapper();

    public IssueDTO toDTO(Issue c) throws Exception {
        IssueDTO dto = new IssueDTO();

        dto.setId(c.getId());
        dto.setTitulo(c.getTitulo());
        dto.setTexto(c.getTexto());
        dto.setFecha(c.getFecha());
        dto.setProgramadores(getProgramadorList(c.getProgramadores()));
        dto.setCommits(getCommits(c.getCommits()));
        dto.setProyecto(pm.toDTO(ppr.selectProyectoById(c.getIdProyecto())));
        dto.setRepositorio(rr.selectRepositorioById(c.getIdRepositorio()));
        dto.setTerminado(c.isTerminado());

        return dto;
    }

    public Issue toDAO(IssueDTO c){
        Issue issue = new Issue();
        List<Long> programadores = c.getProgramadores().stream().map(v->getId(v,"p")).collect(Collectors.toList());
        List<Long> commits = c.getCommits().stream().map(v->getId(v,"c")).collect(Collectors.toList());

        issue.setId(c.getId());
        issue.setTitulo(c.getTitulo());
        issue.setTexto(c.getTexto());
        issue.setFecha(c.getFecha());
        issue.setProgramadores(programadores);
        issue.setCommits(commits);
        issue.setIdProyecto(c.getProyecto().getId());
        issue.setIdRepositorio(c.getRepositorio().getId());
        issue.setTerminado(c.isTerminado());

        return issue;
    }

    private List<ProgramadorDTO> getProgramadorList(List<Long> programadoresId){
        List<ProgramadorDTO> programadores = new ArrayList<>();
        programadoresId.forEach(v-> {
            try {
                programadores.add(ppm.toDTO(pr.selectProgramadorById(v)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return programadores;
    }

    private List<CommitDTO> getCommits(List<Long> commitsId){
        List<CommitDTO> commits = new ArrayList<>();
        commitsId.forEach(v-> {
            try {
                commits.add(cm.toDTO(cr.selectCommitById(v)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return commits;
    }

    private long getId(Object o,String tipo){
        if(tipo.equals("p"))
            return ((ProgramadorDTO)o).getId();
        else
            return ((CommitDTO)o).getId();
    }
}
