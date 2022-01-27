package repository;
import DAO.Commits;
import DAO.Repositorio;
import Repository.RepositorioRepository;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CommitRepository tests")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RepositorioRepositoryTest {
    private Repositorio repo = new Repositorio("test",1L,"2222-22-22", List.of(1L,2L),List.of(1L,2L));
    private RepositorioRepository rr = new RepositorioRepository();

    @Test
    @Order(1)
    public void insertRepositorio(){
        Repositorio ans = rr.insert(repo);
        Assertions.assertEquals(repo,ans);
    }

    @Test
    @Order(2)
    public void selectAll(){
        List<Repositorio> ans = rr.selectAll();
        Assertions.assertAll(
                () -> assertFalse(ans.isEmpty()),
                () -> assertTrue(ans.get(0)!=null)
        );
    }
    @Test
    @Order(3)
    public void updateRepositorio(){
        repo.setNombre("nombre actualizado");
        Repositorio ans = rr.update(repo);
        Assertions.assertAll(
                () -> assertTrue(ans!=null),
                () -> assertEquals(repo.getNombre(),ans.getNombre())
        );
    }
    @Test
    @Order(4)
    public void deleteRepositorio(){
        Repositorio ans = rr.delete(repo);
        Assertions.assertEquals(repo,ans);
    }
}
