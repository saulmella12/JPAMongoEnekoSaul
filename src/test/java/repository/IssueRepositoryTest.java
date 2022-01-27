package repository;
import DAO.Commits;
import DAO.Departamento;
import DAO.Issue;
import Repository.IssueRepository;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CommitRepository tests")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IssueRepositoryTest {
    private Issue issue = new Issue("test","texto test","2222-22-22", List.of(1L,2L),List.of(1L,2L),1L,1L,false);
    private IssueRepository ir = new IssueRepository();

    @Test
    @Order(1)
    public void insertIssue(){
        Issue ans = ir.insert(issue);
        Assertions.assertEquals(issue,ans);
    }

    @Test
    @Order(2)
    public void selectAll(){
        List<Issue> ans = ir.selectAll();
        Assertions.assertAll(
                () -> assertFalse(ans.isEmpty()),
                () -> assertTrue(ans.get(0)!=null)
        );
    }

    @Test
    @Order(3)
    public void updateIssue(){
        issue.setTexto("texto actualizado");
        Issue ans = ir.update(issue);
        Assertions.assertAll(
                ()-> assertTrue(ans!=null),
                ()-> assertEquals(issue.getTexto(),ans.getTexto())
        );
    }

    @Test
    @Order(4)
    public void deleteIssue(){
        Issue ans = ir.delete(issue);
        Assertions.assertEquals(issue,ans);
    }
}
