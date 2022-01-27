package repository;
import DAO.Commits;
import DAO.Departamento;
import DAO.PivotePP;
import Repository.PivoteRepository;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CommitRepository tests")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PivoteRepositoryTest {
    private PivotePP pivote = new PivotePP(1L,1L);
    private PivoteRepository pr = new PivoteRepository();

    @Test
    @Order(1)
    public void insertPivote(){
        PivotePP ans = pr.insert(pivote);
        Assertions.assertEquals(pivote,ans);
    }

    @Test
    @Order(2)
    public void selectAll(){
        List<PivotePP> ans = pr.getAll();
        Assertions.assertAll(
                () -> assertFalse(ans.isEmpty()),
                () -> assertTrue(ans.get(0)!=null)
        );
    }
    @Test
    @Order(3)
    public void updatePivote(){
        pivote.setIdProgramador(1L);
        PivotePP ans = pr.update(pivote);
        Assertions.assertAll(
                ()-> assertTrue(ans!=null),
                ()-> assertEquals(pivote.getIdProgramador(),ans.getIdProgramador())
        );
    }
    @Test
    @Order(4)
    public void deleteCommit(){
        PivotePP ans = pr.delete(pivote);
        Assertions.assertEquals(pivote,ans);
    }
}
