package Repository;

import DAO.Proyecto;
import controller.Controller;

import javax.persistence.*;
import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProyectoRepository {

    Controller controller = Controller.getInstance();

    /**
     * Creation of the method that search all the projects of the database
     * @return projects and print the projects list
     */
    public List<Proyecto> selectAll() {
        controller.open();
        controller.getTransaction().begin();
        TypedQuery<Proyecto> query = controller.getManager().createNamedQuery("Proyecto.findAll", Proyecto.class);
        List<Proyecto> lista = query.getResultList();
        controller.close();
        return lista;
    }

    /**
     * Creation of the method that insert a project into the database
     * @param c
     * @return project
     */
    public Proyecto insert(Proyecto c) {
        controller.open();
        controller.getTransaction().begin();
        controller.getManager().persist(c);
        controller.getTransaction().commit();
        return c;
    }

    /**
     * Creation of the method that update a project of the database
     * @param c
     * @return project
     */
    public Proyecto update(Proyecto c){
        controller.open();
        controller.getTransaction().begin();
        controller.getManager().merge(c);
        controller.getTransaction().commit();
        System.out.println("Elemento Actualizado: "+c.toString());
        return c;
    }

    /**
     * Creation of the method that delete a project of the database
     * @param c
     * @return project
     */
    public Proyecto delete(Proyecto c){
        controller.open();
        controller.getTransaction().begin();
        c = controller.getManager().find(Proyecto.class, c.get_id());
        controller.getManager().remove(c);
        controller.getTransaction().commit();
        System.out.println("Elemento Borrado: "+ c.toString());
        return c;
    }

    public Optional<Proyecto> selectProyectoById(long idProyecto) {
        controller.open();
        controller.getTransaction().begin();
        Optional<Proyecto> p = Optional.of(controller.getManager().find(Proyecto.class,idProyecto));
        controller.close();

        return p;
    }

    public List<Proyecto> selectSegunEstado(long id, boolean enCurso) {
        List<Proyecto> proyectos = new ArrayList<>();

        selectAll().forEach(v->{
            if(v.getDepartamento() == id && v.isTermiando() == !enCurso){
                proyectos.add(v);
            }
        });

        return proyectos;
    }
}
