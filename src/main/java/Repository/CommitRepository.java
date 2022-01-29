package Repository;

import DAO.Commits;
import DTO.CommitDTO;
import DTO.RepositorioDTO;
import controller.Controller;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

public class CommitRepository {
    /**
     * Creation of the method that search all the commits in the database
     * @return null and print the commit list
     */
    public List<Commits> selectAll() {
        Controller controller = Controller.getInstance();
        controller.open();
        TypedQuery<Commits> query = controller.getManager().createNamedQuery("Commits.findAll", Commits.class);
        List<Commits> lista = query.getResultList();
        controller.close();
        return lista;
    }

    /**
     * Creation of the method that insert the commit into the database
     * @param c
     * @return commit
     */
    public Commits insert(Commits c) {
        Controller controller = Controller.getInstance();
        controller.open();
        controller.getTransaction().begin();
        controller.getManager().persist(c);
        controller.getTransaction().commit();
        controller.getTransaction().rollback();
        controller.close();
        return c;
    }

    /**
     * Creation of the method that update the commit of the database
     * @param c
     * @return commit
     */
    public Commits update(Commits c){
        Controller controller = Controller.getInstance();
        controller.open();
        controller.getTransaction().begin();
        Commits ans = controller.getManager().merge(c);
        controller.getTransaction().commit();
        controller.getTransaction().rollback();
        controller.close();
        System.out.println("Elemento Actualizado: "+c.toString());
        return ans;
    }

    /**
     * Creation of the method that delete the commit of the database
     * @param c
     * @return commit
     */
    public Commits delete(Commits c){
        Controller controller = Controller.getInstance();
        controller.open();
        controller.getTransaction().begin();
        Commits ans = controller.getManager().find(Commits.class, c.get_id());
        controller.getManager().remove(ans);
        controller.getTransaction().commit();
        controller.getTransaction().rollback();
        controller.close();
        System.out.println("Elemento Borrado: "+ c.toString());
        return ans;
    }

    public Optional<Commits> selectCommitById(Long id) {
        Controller controller = Controller.getInstance();
        controller.open();
        controller.getTransaction().begin();
        Optional<Commits> c = Optional.of(controller.getManager().find(Commits.class,id));
        controller.getTransaction().rollback();
        controller.close();
        
        return c;
    }
}
