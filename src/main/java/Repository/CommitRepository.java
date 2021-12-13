package Repository;

import Model.Commits;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CommitRepository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    public List<Commits> selectAll(){
        EntityManager manager = entityManagerFactory.createEntityManager();

        System.out.println("Listando todos los Commit");
        List<Commits> commits = (List<Commits>) manager.createQuery("from Commits").getResultList();
        commits.forEach(System.out::println);
        return commits;
    }

    public Commits insert(Commits c){
        EntityManager manager = entityManagerFactory.createEntityManager();

        System.out.println("Insertando commit");
        manager.getTransaction().begin();
        manager.persist(c);
        manager.getTransaction().commit();
        return c;
    }

    public Commits update(Commits c){
        EntityManager manager = entityManagerFactory.createEntityManager();

        System.out.println("actualizando commit");
        manager.getTransaction().begin();
        manager.merge(c);
        manager.getTransaction().commit();
        return c;
    }

    public Commits delete(Commits c){
        EntityManager manager = entityManagerFactory.createEntityManager();

        System.out.println("borrando commit");
        manager.getTransaction().begin();
        manager.remove(c.getId());
        manager.getTransaction().commit();
        return c;
    }
}
