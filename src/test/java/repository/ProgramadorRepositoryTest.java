package repository;
import DAO.Commits;
import DAO.Programador;
import Repository.ProgramadorRepository;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CommitRepository tests")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProgramadorRepositoryTest {
    private Programador p = new Programador(1L,"prueba","2222-22-22",23,"prueba","1234",1L, List.of(1L,2L),List.of(1L,2L),List.of("java","python"));
    private ProgramadorRepository pr = new ProgramadorRepository();

    @Test
    @Order(1)
    public void insertProgramador(){
        Programador ans = pr.insert(p);
        Assertions.assertEquals(p,ans);
    }

    @Test
    @Order(2)
    public void selectAll(){
        List<Programador> ans = pr.selectAll();
        Assertions.assertAll(
                () -> assertFalse(ans.isEmpty()),
                () -> assertNotNull(ans.get(0))
        );
    }

    @Test
    @Order(3)
    public void updateProgramador(){
        p.setNombre("Federico");
        Programador ans = pr.update(p);
        Assertions.assertEquals(p,ans);
    }

    @Test
    @Order(4)
    public void deleteProgramador(){
        Programador ans = pr.delete(p);
        Assertions.assertEquals(p,ans);
    }
}
