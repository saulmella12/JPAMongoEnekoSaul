package consultas;

import service.*;

public class Consultas {

    CommitService cs = new CommitService();
    DepartamentoService ds = new DepartamentoService();
    IssueService is = new IssueService();
    ProgramadorService ps = new ProgramadorService();
    ProyectoService pys= new ProyectoService();
    RepositorioService rs = new RepositorioService();

    private void insertData(){
            cs.postCommit(c);
            ds.postDepartamento(d);
            is.postIssue(i);
            ps.postProgramador(p);
            pys.postProyecto(py);
            rs.postRepositorio(r);
    }

}