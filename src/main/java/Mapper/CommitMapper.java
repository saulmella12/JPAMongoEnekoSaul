package Mapper;

import DTO.CommitDTO;
import DAO.Commits;
import DAO.Issue;
import DAO.Programador;
import Repository.*;

public class CommitMapper {

    private RepositorioRepository rr = new RepositorioRepository();
    private IssueRepository ir = new IssueRepository();
    private ProyectoRepository pr =new ProyectoRepository();
    private ProgramadorRepository ppr = new ProgramadorRepository();
    private IssueMapper im = new IssueMapper();
    private ProyectoMapper pm = new ProyectoMapper();
    private ProgramadorMapper ppm = new ProgramadorMapper();

    public CommitDTO toDTO(Commits c) throws Exception {
        CommitDTO dto = new CommitDTO();
        dto.setId(c.getId());
        dto.setTitulo(c.getTitulo());
        dto.setTexto(c.getTexto());
        dto.setFecha(c.getFecha());
        dto.setRepositorio(rr.selectRepositorioById(c.getIdRepositorio()));
        dto.setIssue(im.toDTO(ir.selectIssueById(c.getIdIssue())));
        dto.setProyecto(pm.toDTO(pr.selectProyectoById(c.getIdProyecto())));
        dto.setCreador(ppm.toDTO(ppr.selectProgramadorById(c.getIdCreador())));

        return dto;
    }

    public Commits toDAO(CommitDTO c){
        Commits commit = new Commits();
        commit.setId(c.getId());
        commit.setTitulo(c.getTitulo());
        commit.setTexto(c.getTexto());
        commit.setFecha(c.getFecha());
        commit.setIdRepositorio(c.getRepositorio().getId());
        commit.setIdProyecto(c.getProyecto().getId());
        commit.setIdCreador(c.getCreador().getId());

        return commit;
    }
}
