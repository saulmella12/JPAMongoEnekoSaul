import DAO.*;
import Repository.*;
import service.CommitService;
import service.ProgramadorService;

import java.util.List;

public class App {
    public static void main(String[] args) {

       Programador p = new Programador(1L,"prueba","2222-22-22",23,"prueba","1234",1L, List.of(1L,2L),List.of(1L,2L),List.of("java","python"));
       ProgramadorRepository pr = new ProgramadorRepository();

       pr.insert(p);
       p.setNombre("manolo");
       pr.update(p);
       pr.delete(p);
    }
}
