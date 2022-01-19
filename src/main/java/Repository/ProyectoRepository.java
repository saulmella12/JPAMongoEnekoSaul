package Repository;

import DAO.Proyecto;
import DTO.ProyectoDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ProyectoRepository {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("practica");
    EntityManager manager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    /**
     * Creation of the method that search all the projects of the database
     * @return projects and print the projects list
     */
    public List<Proyecto> selectAll() {
        System.out.println("Listado de todos los Proyectos: ");
        List<Proyecto> proyectos = (List<Proyecto>) manager.createQuery("FROM Proyecto ").getResultList();
        return proyectos;
    }

    /**
     * Creation of the method that insert a project into the database
     * @param c
     * @return project
     */
    public Proyecto insert(Proyecto c) {
        manager.getTransaction().begin();
        manager.persist(c);
        manager.getTransaction().commit();
        return c;
    }

    /**
     * Creation of the method that update a project of the database
     * @param c
     * @return project
     */
    public Proyecto update(Proyecto c){
        manager.getTransaction().begin();
        manager.merge(c);
        manager.getTransaction().commit();
        System.out.println("Elemento Actualizado: "+c.toString());
        return c;
    }

    /**
     * Creation of the method that delete a project of the database
     * @param c
     * @return project
     */
    public Proyecto delete(Proyecto c){
        manager.getTransaction().begin();
        c = manager.find(Proyecto.class, c.getId());
        manager.remove(c);
        manager.getTransaction().commit();
        System.out.println("Elemento Borrado: "+ c.toString());
        return c;
    }

    public ProyectoDTO selectProyectoById(long idProyecto) {
    }

    public List<ProyectoDTO> selectSegunEstado(long id, boolean enCurso) {
    }
}
