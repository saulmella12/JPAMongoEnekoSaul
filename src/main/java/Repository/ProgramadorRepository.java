package Repository;

import DAO.Programador;
import controller.Controller;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

public class ProgramadorRepository {

    Controller controller = Controller.getInstance();
    /**
     * Creation of the method that search all the programmers of the database
     * @return programmers and print the programmer list
     */
    public List<Programador> selectAll() {
        controller.open();
        controller.getTransaction().begin();
        TypedQuery<Programador> query = controller.getManager().createNamedQuery("Programador.findAll", Programador.class);
        List<Programador> lista = query.getResultList();
        controller.close();
        return lista;
    }

    /**
     * Creation of the method that insert a programmer into the database
     * @param p
     * @return programmer
     */
    public Programador insert(Programador p) {
        System.out.println("Insertando Programador");
        controller.open();
        controller.getTransaction().begin();
        controller.getManager().persist(p);
        controller.getTransaction().commit();
        controller.close();
        return p;
    }

    /**
     * Creation of the method that update a programmer of the database
     * @param p
     * @return programmer
     */
    public Programador update(Programador p){
        controller.open();
        controller.getTransaction().begin();
        controller.getManager().merge(p);
        controller.getTransaction().commit();
        controller.close();
        System.out.println("Elemento Actualizado: "+p.toString());
        return p;
    }

    /**
     * Creation of the method that delete a programmer of the database
     * @param p
     * @return programmer
     */
    public Programador delete(Programador p){
        controller.open();
        controller.getTransaction().begin();
        p = controller.getManager().find(Programador.class, p.get_id());
        controller.getManager().remove(p);
        controller.getTransaction().commit();
        //System.out.println("Elemento Borrado: "+ p.toString());
        controller.close();
        return p;
    }

    public Optional<Programador> selectProgramadorById(long idCreador){

        controller.getTransaction().begin();
        Optional<Programador> p = Optional.of(controller.getManager().find(Programador.class,idCreador));
        controller.close();

        return p;
    }
}
