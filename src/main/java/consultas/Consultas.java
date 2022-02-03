package consultas;

import DTO.IssueDTO;
import DTO.dtoEspeciales.DepartamentoAllInfo;
import DTO.dtoEspeciales.ProyectOnlyIssues;
import Mapper.DtoToSpecial;
import service.*;

import java.util.List;
import java.util.stream.Collectors;

public class Consultas {

    CommitService cs = new CommitService();
    DepartamentoService ds = new DepartamentoService();
    IssueService is = new IssueService();
    ProgramadorService ps = new ProgramadorService();
    ProyectoService pys= new ProyectoService();
    RepositorioService rs = new RepositorioService();



    public String departamentoWithProjectAndWorkers(long idDepartamento){
        List<DepartamentoAllInfo> departamentos = ds.getAllDepartamentos().stream().map(v-> DtoToSpecial.getInstance().toDAI(v)).collect(Collectors.toList());
        return JSONCreator.getInstance().toJSon(departamentos);
    }

    public String unfinishedIssuesByDepartment(){
        return "a";
    }
    public String notFinishedProyectIssues(){
        IssueService service = new IssueService();
        List<IssueDTO> issues = service.getAllIssues().stream().filter(v->!v.isTerminado()).collect(Collectors.toList());
        List<ProyectOnlyIssues> proyects = issues.stream().map(v->DtoToSpecial.getInstance().toPOI(v,v.getId())).collect(Collectors.toList());
        return JSONCreator.getInstance().toJSon(proyects);
    }
    public String programmersOrderedByCommits(){
        return "a";
    }

    public String programmersProductivity(){
        return "a";
    }

    public String mostExpensiveProjects(){
        return "a";
    }

    public String projectsAllInfo(){
        return "a";
    }

}