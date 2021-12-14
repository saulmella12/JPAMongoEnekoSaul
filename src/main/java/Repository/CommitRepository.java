package Repository;

import Model.Commits;

import javax.persistence.*;
import java.util.List;

public class CommitRepository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("practica");
    EntityManager manager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    /**
     * Creation of the method that search all the commits in the database
     * @return null and print the commit list
     */
    public List<Commits> selectAll() {
        System.out.println("Listado de todos los Commits: ");
        List<Commits> commits = (List<Commits>) manager.createQuery("FROM Commits ").getResultList();
        return commits;
    }

    /**
     * Creation of the method that insert the commit into the database
     * @param c
     * @return commit
     */
    public Commits insert(Commits c) {
            manager.getTransaction().begin();
            manager.persist(c);
            manager.getTransaction().commit();
            return c;
    }

    /**
     * Creation of the method that update the commit of the database
     * @param c
     * @return commit
     */
    public Commits update(Commits c){
            manager.getTransaction().begin();
            manager.merge(c);
            manager.getTransaction().commit();
            System.out.println("Elemento Actualizado: "+c.toString());
            return c;
    }

    /**
     * Creation of the method that delete the commit of the database
     * @param c
     * @return commit
     */
    public Commits delete(Commits c){
            manager.getTransaction().begin();
            c = manager.find(Commits.class, c.getId());
            manager.remove(c);
            manager.getTransaction().commit();
            System.out.println("Elemento Borrado: "+ c.toString());
            return c;
    }
}
