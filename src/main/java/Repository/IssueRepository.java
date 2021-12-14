package Repository;



import Model.Issue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class IssueRepository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("practica");
    EntityManager manager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    /**
     * Creation of the method that search all the issues of the database
     * @return issues and print the issue list
     */
    public List<Issue> selectAll() {
        System.out.println("Listado de todos los Issues: ");
        List<Issue> issues = (List<Issue>) manager.createQuery("FROM Issue ").getResultList();
        return issues;
    }

    public Issue selectById(long id){
        System.out.println("issue que consuerda con la id "+id);
        return (Issue) manager.createQuery("from Issue where id="+id);
    }

    /**
     * Creation of the method that insert a issue into the database
     * @param i
     * @return issue
     */
    public Issue insert(Issue i) {
        manager.getTransaction().begin();
        manager.persist(i);
        manager.getTransaction().commit();
        return i;
    }

    /**
     * Creation of the method that update an issue of the database
     * @param i
     * @return issue
     */
    public Issue update(Issue i){
        manager.getTransaction().begin();
        manager.merge(i);
        manager.getTransaction().commit();
        System.out.println("Elemento Actualizado: "+i.toString());
        return i;
    }

    /**
     * Creation of the method that delete an issue of the database
     * @param i
     * @return issue
     */
    public Issue delete(Issue i){
        manager.getTransaction().begin();
        i = manager.find(Issue.class, i.getId());
        manager.remove(i);
        manager.getTransaction().commit();
        System.out.println("Elemento Borrado: "+ i.toString());
        return i;
    }
}
