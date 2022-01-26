package Repository;

import DAO.Commits;
import DAO.Programador;
import DTO.*;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

public class ProgramadorRepository {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("practica");
    EntityManager manager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    /**
     * Creation of the method that search all the programmers of the database
     * @return programmers and print the programmer list
     */
    public List<Programador> selectAll() {
        manager.getTransaction().begin();
        TypedQuery<Programador> query = manager.createNamedQuery("Programador.findAll", Programador.class);
        List<Programador> lista = query.getResultList();
        manager.close();
        return lista;
    }

    /**
     * Creation of the method that insert a programmer into the database
     * @param p
     * @return programmer
     */
    public Programador insert(Programador p) {
        System.out.println("Insertando Programador");
        manager.getTransaction().begin();
        manager.persist(p);
        manager.getTransaction().commit();
        return p;
    }

    /**
     * Creation of the method that update a programmer of the database
     * @param p
     * @return programmer
     */
    public Programador update(Programador p){
        manager.getTransaction().begin();
        manager.merge(p);
        manager.getTransaction().commit();
        System.out.println("Elemento Actualizado: "+p.toString());
        return p;
    }

    /**
     * Creation of the method that delete a programmer of the database
     * @param p
     * @return programmer
     */
    public Programador delete(Programador p){
        manager.getTransaction().begin();
        p = manager.find(Programador.class, p.getId());
        manager.remove(p);
        manager.getTransaction().commit();
        System.out.println("Elemento Borrado: "+ p.toString());
        return p;
    }

    public Optional<Programador> selectProgramadorById(long idCreador){

        manager.getTransaction().begin();
        Optional<Programador> p = Optional.of(manager.find(Programador.class,idCreador));
        manager.close();

        return p;
    }
}
