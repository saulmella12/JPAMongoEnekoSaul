package repository;
import DAO.Commits;
import DAO.Proyecto;
import Repository.ProyectoRepository;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CommitRepository tests")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProyectoRepositoryTest {
    private Proyecto proyectoPrueba = new Proyecto(true,1L,"nombrePrueba",20.0,"2222-22-22","2222-22-22", List.of("java","python"),1L);
    private ProyectoRepository pr= new ProyectoRepository();

    @Test
    @Order(1)
    public void insertProyecto(){
        Proyecto ans = pr.insert(proyectoPrueba);
        Assertions.assertEquals(proyectoPrueba,ans);
    }

    @Test
    @Order(2)
    public void selectAll(){
        List<Proyecto> ans = pr.selectAll();
        Assertions.assertAll(
                () -> assertFalse(ans.isEmpty()),
                () -> assertTrue(ans.get(0)!=null)
        );
    }
    @Test
    @Order(3)
    public void updateProyecto(){
        proyectoPrueba.setNombre("nombre actualizado");
        Proyecto ans = pr.update(proyectoPrueba);
        Assertions.assertAll(
                () -> assertTrue(ans!=null),
                () -> assertEquals(proyectoPrueba.getNombre(),ans.getNombre())
        );
    }
    @Test
    @Order(4)
    public void deleteProyecto(){
        Proyecto ans = pr.delete(proyectoPrueba);
        Assertions.assertEquals(proyectoPrueba,ans);
    }
}
