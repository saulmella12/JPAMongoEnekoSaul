package Repository;

import DAO.Repositorio;
import DTO.RepositorioDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class RepositorioRepository {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("practica");
    EntityManager manager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    /**
     * Creation of the method that search all the repositories of the database
     * @return repositories and print the repository list
     */
    public List<Repositorio> selectAll() {
        System.out.println("Listado de todos los Repositorios: ");
        List<Repositorio> repositorios = (List<Repositorio>) manager.createQuery("FROM Repositorio ").getResultList();
        return repositorios;
    }

    /**
     * Creation of the method that insert a repository into the database
     * @param c
     * @return repository
     */
    public Repositorio insert(Repositorio c) {
        manager.getTransaction().begin();
        manager.persist(c);
        manager.getTransaction().commit();
        return c;
    }

    /**
     * Creation of the method that update a repository of the database
     * @param c
     * @return repository
     */
    public Repositorio update(Repositorio c){
        manager.getTransaction().begin();
        manager.merge(c);
        manager.getTransaction().commit();
        System.out.println("Elemento Actualizado: "+c.toString());
        return c;
    }

    /**
     * Creation of the method that delete a repository of the database
     * @param c
     * @return repository
     */
    public Repositorio delete(Repositorio c){
        manager.getTransaction().begin();
        c = manager.find(Repositorio.class, c.getId());
        manager.remove(c);
        manager.getTransaction().commit();
        System.out.println("Elemento Borrado: "+ c.toString());
        return c;
    }

    public RepositorioDTO selectRepositorioById(long idRepositorio) {
    }
}
