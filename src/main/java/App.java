import Model.*;
import Repository.*;

public class App {
    public static void main(String[] args) {

        CommitRepository cr = new CommitRepository();
        DepartamentoRepository dr = new DepartamentoRepository();
        IssueRepository ir = new IssueRepository();
        ProgramadorRepository pr = new ProgramadorRepository();
        ProyectoRepository prr = new ProyectoRepository();
        RepositorioRepository rr = new RepositorioRepository();

        Issue i = new Issue(1L, "titulo", "texto","2222-22-22",true);
        Programador p = new Programador(1L, "nombre", "2222-22-22",20.0,"usuario","passwd");
        Programador p2 = new Programador(2L, "nombre2", "2222-22-22",120.0,"usuario","passwd");
        Commits c = new Commits(1L, "commit1", "hola","2222-22-22", p, i);
        Departamento d = new Departamento(1L,"titulo",p2,2334.9);
        Proyecto pro = new Proyecto(1L, true, p2, "nombre", 1258.7,"2222-22-22","2222-22-22");
        Repositorio r = new Repositorio(1L,"repositorio1", "2222-22-22",pro);

        ir.insert(i);
        ir.selectAll();
        System.out.println(pr.insert(p));
        System.out.println(pr.insert(p2));
        System.out.println(pr.selectAll().size());
        cr.insert(c);
        cr.selectAll();
        dr.insert(d);
        dr.selectAll();
        prr.insert(pro);
        prr.selectAll();
        rr.insert(r);
        rr.selectAll();

    }
}
