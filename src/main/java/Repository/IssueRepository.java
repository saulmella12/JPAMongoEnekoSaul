package Repository;

import DAO.Issue;
import controller.Controller;

import javax.persistence.*;
import java.util.List;

public class IssueRepository {
    Controller controller = Controller.getInstance();

    /**
     * Creation of the method that search all the issues of the database
     * @return issues and print the issue list
     */
    public List<Issue> selectAll() {
        controller.open();
        controller.getTransaction().begin();
        TypedQuery<Issue> query = controller.getManager().createNamedQuery("Issue.findAll", Issue.class);
        List<Issue> lista = query.getResultList();
        controller.close();
        return lista;
    }

    public Issue selectById(long id){
        controller.open();
        System.out.println("issue que consuerda con la id "+id);
        Issue ans = (Issue) controller.getManager().createQuery("from Issue where id="+id);
        controller.close();
        return ans;

    }

    /**
     * Creation of the method that insert a issue into the database
     * @param i
     * @return issue
     */
    public Issue insert(Issue i) {
        controller.open();
        controller.getManager().getTransaction().begin();
        controller.getManager().persist(i);
        controller.getTransaction().commit();
        controller.close();
        return i;
    }

    /**
     * Creation of the method that update an issue of the database
     * @param i
     * @return issue
     */
    public Issue update(Issue i){
        controller.open();
        controller.getTransaction().begin();
        controller.getManager().merge(i);
        controller.getTransaction().commit();
        System.out.println("Elemento Actualizado: "+i.toString());
        controller.close();
        return i;
    }

    /**
     * Creation of the method that delete an issue of the database
     * @param i
     * @return issue
     */
    public Issue delete(Issue i){
        controller.open();
        controller.getTransaction().begin();
        i = controller.getManager().find(Issue.class, i.get_id());
        controller.getManager().remove(i);
        controller.getTransaction().commit();
        System.out.println("Elemento Borrado: "+ i.toString());
        return i;
    }
}
