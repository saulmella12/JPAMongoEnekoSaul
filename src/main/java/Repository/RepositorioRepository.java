package Repository;

import DAO.Commits;
import DAO.Repositorio;
import DTO.RepositorioDTO;

import javax.persistence.*;
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
    public Repositorio delete(Repositorio c) throws Exception {
        manager.getTransaction().begin();
        Repositorio r = manager.find(Repositorio.class,c);
        manager.close();

        if(r==null){
            throw new Exception("depo bulunamadı");
        }
        return r;
    }

    public RepositorioDTO selectRepositorioById(long idRepositorio) {
    }
}
