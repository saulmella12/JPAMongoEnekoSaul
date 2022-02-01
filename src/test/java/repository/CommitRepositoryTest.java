package repository;

import DAO.Commits;
import Repository.CommitRepository;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CommitRepository tests")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CommitRepositoryTest {

    private Commits commitPrueba = new Commits(1L,"tituloPrueba","textoPrueba","fechaPrueba",1L,1L,1L,1L);
    private CommitRepository cr = new CommitRepository();

    @Test
    @Order(1)
    public void insertCommit(){
        Commits ans = cr.insert(commitPrueba);
        Assertions.assertEquals(commitPrueba,ans);
    }

    @Test
    @Order(2)
    public void selectAll(){
        List<Commits> ans = cr.selectAll();
        Assertions.assertAll(
                () -> assertFalse(ans.isEmpty()),
                () -> assertTrue(ans.get(0)!=null)
        );
    }

    @Test
    @Order(3)
    public void updateCommit(){
        commitPrueba.setTexto("testo mejorado y precioso");
        Commits ans = cr.update(commitPrueba);
        Assertions.assertAll(
                () -> assertTrue(ans!=null),
                () -> assertEquals(commitPrueba,ans)
        );
    }

    @Test
    @Order(4)
    public void selectById(){
        Commits ans = cr.selectCommitById(commitPrueba.getId()).get();
        Assertions.assertEquals(commitPrueba,ans);
    }

    @Test
    @Order(5)
    public void deleteCommit(){
        Commits ans = cr.delete(commitPrueba);
        Assertions.assertEquals(commitPrueba,ans);
    }
}
