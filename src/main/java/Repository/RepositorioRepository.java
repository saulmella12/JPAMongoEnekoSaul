package Repository;

import DAO.Repositorio;
import DTO.RepositorioDTO;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

public class RepositorioRepository {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("practica");
    EntityManager manager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    /**
     * Creation of the method that search all the repositories of the database
     * @return repositories and print the repository list
     */
    public List<Repositorio> selectAll() {
        manager.getTransaction().begin();
        TypedQuery<Repositorio> query = manager.createNamedQuery("Repositorio.findAll", Repositorio.class);
        List<Repositorio> lista = query.getResultList();
        manager.close();
        return lista;
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
    public Optional<Repositorio> delete(Repositorio c) {
        manager.getTransaction().begin();
        Optional<Repositorio> r = Optional.of(manager.find(Repositorio.class,c));
        manager.close();

        return r;
    }

    public Optional<Repositorio> selectRepositorioById(long idRepositorio) {
        manager.getTransaction().begin();
        Optional<Repositorio> p = Optional.of(manager.find(Repositorio.class,idRepositorio));
        manager.close();

        return p;
    }
}
