import DAO.*;
import Repository.*;
import service.CommitService;
import service.ProgramadorService;

import java.util.List;

public class App {
    public static void main(String[] args) {

        CommitRepository cr = new CommitRepository();
        Commits c1 = new Commits(1L,"superPrueba","texto","2222-22-22",1,1,1,1);
        Commits c2 = new Commits(2L,"superPrueba2","texto2","2222-22-22",2,2,2,2);
        Commits c3 = new Commits(3L,"superPrueba3","texto3","2222-22-22",3,3,3,3);
        Commits c4 = new Commits(4L,"superPrueba4","texto4","2222-22-22",4,4,4,4);
        cr.insert(c1);
        cr.insert(c2);
        cr.insert(c3);
        cr.insert(c4);

        DepartamentoRepository dr = new DepartamentoRepository();
        Departamento d1 = new Departamento(1L,List.of(1L),"nombre",1L,200.0,List.of(1L),List.of(1L));
        Departamento d2 = new Departamento(2L,List.of(2L),"nombre2",2L,300.0,List.of(2L),List.of(2L));
        Departamento d3 = new Departamento(3L,List.of(3L),"nombre3",3L,400.0,List.of(3L),List.of(3L));
        Departamento d4 = new Departamento(4L,List.of(4L),"nombre4",4L,500.0,List.of(4L),List.of(4L));
        dr.insert(d1);
        dr.insert(d2);
        dr.insert(d3);
        dr.insert(d4);

        IssueRepository ir = new IssueRepository();
        Issue i1 = new Issue(1L,"titulo","texto","2222-22-22",List.of(1L),List.of(1L),1L,1L,true);
        Issue i2 = new Issue(2L,"titulo2","texto2","2222-22-22",List.of(2L),List.of(2L),2L,2L,true);
        Issue i3 = new Issue(3L,"titulo3","texto3","2222-22-22",List.of(3L),List.of(3L),3L,3L,false);
        Issue i4 = new Issue(4L,"titulo4","texto4","2222-22-22",List.of(4L),List.of(4L),4L,4L,false);
        ir.insert(i1);
        ir.insert(i2);
        ir.insert(i3);
        ir.insert(i4);

        PivoteRepository ppr = new PivoteRepository();
        PivotePP pp1 = new PivotePP(1l,1l);
        PivotePP pp2 = new PivotePP(2l,2l);
        PivotePP pp3 = new PivotePP(3l,3l);
        PivotePP pp4 = new PivotePP(4l,4l);
        ppr.insert(pp1);
        ppr.insert(pp2);
        ppr.insert(pp3);
        ppr.insert(pp4);

        ProgramadorRepository pr = new ProgramadorRepository();
        Programador p1 = new Programador(1L,"prueba","2222-22-22",2367,"prueba","1234",1L, List.of(1L),List.of(1L),List.of("java","python"));
        Programador p2 = new Programador(2L,"prueba2","2222-22-22",239,"prueba2","fgfd",2L, List.of(2L),List.of(2L),List.of("java","python"));
        Programador p3 = new Programador(3L,"prueba3","2222-22-22",233424,"prueba3","123234",3L, List.of(3L),List.of(3L),List.of("java","python"));
        Programador p4 = new Programador(4L,"prueba4","2222-22-22",263,"prueba4","12fbv34",4L, List.of(4L),List.of(4L),List.of("java","python"));
        pr.insert(p1);
        pr.insert(p2);
        pr.insert(p3);
        pr.insert(p4);

        ProyectoRepository pyr = new ProyectoRepository();
        Proyecto py1 = new Proyecto(1L,true,1L,"nombre",200.0,"2222-22-22","2222-22-22",List.of("Java","c#"),1L);
        Proyecto py2 = new Proyecto(2L,false,2L,"nombre2",300.0,"2222-22-22","2222-22-22",List.of("Java","c#"),2L);
        Proyecto py3 = new Proyecto(3L,true,3L,"nombre3",400.0,"2222-22-22","2222-22-22",List.of("Java","c#"),3L);
        Proyecto py4 = new Proyecto(4L,false,4L,"nombre4",500.0,"2222-22-22","2222-22-22",List.of("Java","c#"),4L);
        pyr.insert(py1);
        pyr.insert(py2);
        pyr.insert(py3);
        pyr.insert(py4);

        RepositorioRepository rr = new RepositorioRepository();
        Repositorio r1 = new Repositorio(1L,"nombre",1L,"2222-22-22",List.of(1L),List.of(1L));
        Repositorio r2 = new Repositorio(2L,"nombre2",2L,"2222-22-22",List.of(2L),List.of(2L));
        Repositorio r3 = new Repositorio(3L,"nombre3",3L,"2222-22-22",List.of(3L),List.of(3L));
        Repositorio r4 = new Repositorio(4L,"nombre4",4L,"2222-22-22",List.of(4L),List.of(4L));
    }
}
