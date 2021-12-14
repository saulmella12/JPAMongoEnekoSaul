package Repository;

import Model.Programador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramadorRepository {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("practica");
    EntityManager manager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    /**
     * Creation of the method that search all the programmers of the database
     * @return programmers and print the programmer list
     */
    public List<Programador> selectAll() {
        System.out.println("Listado de todos los Programadors: ");
        List<Programador> programadors = (List<Programador>) manager.createQuery("FROM Programador ").getResultList();
        return programadors;
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


}
