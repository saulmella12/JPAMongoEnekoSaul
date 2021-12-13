package Repository;

import Model.Issue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class IssueRepository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    public List<Issue> selectAll(){
        EntityManager manager = entityManagerFactory.createEntityManager();

        System.out.println("Listando todos los Issue");
        List<Issue> Issues = (List<Issue>) manager.createQuery("from Issue").getResultList();
        Issues.forEach(System.out::println);
        return Issues;
    }

    public Issue insert(Issue d){
        EntityManager manager = entityManagerFactory.createEntityManager();

        System.out.println("Insertando Issue");
        manager.getTransaction().begin();
        manager.persist(d);
        manager.getTransaction().commit();
        return d;
    }

    public Issue update(Issue d){
        EntityManager manager = entityManagerFactory.createEntityManager();

        System.out.println("actualizando Issue");
        manager.getTransaction().begin();
        manager.merge(d);
        manager.getTransaction().commit();
        return d;
    }

    public Issue delete(Issue d){
        EntityManager manager = entityManagerFactory.createEntityManager();

        System.out.println("borrando Issue");
        manager.getTransaction().begin();
        manager.remove(d.getId());
        manager.getTransaction().commit();
        return d;
    }
}
