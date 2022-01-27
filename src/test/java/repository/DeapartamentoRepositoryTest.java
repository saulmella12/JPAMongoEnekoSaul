package repository;
import DAO.Commits;
import DAO.Departamento;
import Repository.DepartamentoRepository;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CommitRepository tests")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DeapartamentoRepositoryTest {
    private Departamento departamentoPrueba = new Departamento(List.of(1L,1L),"nombrePrueba",1L,2000.0,List.of(1L,1L),List.of(1L,1L));
    private DepartamentoRepository dr = new DepartamentoRepository();

    @Test
    @Order(1)
    public void insertDepartamento(){
        Departamento ans = dr.insert(departamentoPrueba);
        Assertions.assertEquals(departamentoPrueba,ans);
    }

    @Test
    @Order(2)
    public void selectAll(){
        List<Departamento> ans = dr.selectAll();
        Assertions.assertAll(
                () -> assertFalse(ans.isEmpty()),
                () -> assertTrue(ans.get(0)!=null)
        );
    }

    @Test
    @Order(3)
    public void updateDepartamento(){
        departamentoPrueba.setNombre("nombre actualizado");
        Departamento ans = dr.update(departamentoPrueba);
        Assertions.assertAll(
                ()-> assertTrue(ans!=null),
                ()-> assertEquals(departamentoPrueba.getNombre(),ans.getNombre())
        );
    }
}
