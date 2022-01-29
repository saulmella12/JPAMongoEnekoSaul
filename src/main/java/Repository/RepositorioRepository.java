package Repository;

import DAO.Repositorio;
import controller.Controller;
import javax.persistence.*;
import java.util.List;
import java.util.Optional;

public class RepositorioRepository {

    /**
     * Creation of the method that search all the repositories of the database
     * @return repositories and print the repository list
     */
    public List<Repositorio> selectAll() {
        Controller controller = Controller.getInstance();
        controller.open();
        TypedQuery<Repositorio> query = controller.getManager().createNamedQuery("Repositorio.findAll", Repositorio.class);
        List<Repositorio> lista = query.getResultList();
        controller.close();
        return lista;
    }

    /**
     * Creation of the method that insert a repository into the database
     * @param c
     * @return repository
     */
    public Repositorio insert(Repositorio c) {
        Controller controller = Controller.getInstance();
        controller.getTransaction().begin();
        controller.getManager().persist(c);
        controller.getTransaction().commit();
        controller.close();
        return c;
    }

    /**
     * Creation of the method that update a repository of the database
     * @param c
     * @return repository
     */
    public Repositorio update(Repositorio c){
        Controller controller = Controller.getInstance();
        controller.open();
        controller.getTransaction().begin();
        controller.getManager().merge(c);
        controller.getTransaction().commit();
        controller.close();
        System.out.println("Elemento Actualizado: "+c.toString());
        return c;
    }

    /**
     * Creation of the method that delete a repository of the database
     * @param c
     * @return repository
     */
    public Repositorio delete(Repositorio c) {
        Controller controller = Controller.getInstance();
        controller.open();
        controller.getManager().getTransaction().begin();
        c = controller.getManager().merge(c);
        controller.getManager().remove(c);
        controller.close();
        return c;
    }

    public Optional<Repositorio> selectRepositorioById(long idRepositorio) {
        Controller controller = Controller.getInstance();
        controller.open();
        controller.getTransaction().begin();
        Optional<Repositorio> p = Optional.of(controller.getManager().find(Repositorio.class,idRepositorio));
        controller.close();
        return p;
    }
}
