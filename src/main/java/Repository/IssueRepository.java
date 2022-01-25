package Repository;



import DAO.Commits;
import DAO.Issue;
import DTO.IssueDTO;

import javax.persistence.*;
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
        manager.getTransaction().begin();
        TypedQuery<Issue> query = manager.createNamedQuery("Issue.findAll", Issue.class);
        List<Issue> lista = query.getResultList();
        manager.close();
        return lista;
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

    public Issue selectIssueById(long idIssue) throws Exception {

        manager.getTransaction().begin();
        Issue i = manager.find(Issue.class,idIssue);
        manager.close();

        if(i==null){
            throw new Exception("issue bulunamadı");
        }
        return i;
    }
}
