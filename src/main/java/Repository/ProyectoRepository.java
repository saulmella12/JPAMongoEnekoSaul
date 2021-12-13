package Repository;

import Model.Proyecto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProyectoRepository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    public List<Proyecto> selectAll(){
        EntityManager manager = entityManagerFactory.createEntityManager();

        System.out.println("Listando todos los Proyecto");
        List<Proyecto> Proyectos = (List<Proyecto>) manager.createQuery("from Proyecto").getResultList();
        Proyectos.forEach(System.out::println);
        return Proyectos;
    }

    public Proyecto insert(Proyecto d){
        EntityManager manager = entityManagerFactory.createEntityManager();

        System.out.println("Insertando Proyecto");
        manager.getTransaction().begin();
        manager.persist(d);
        manager.getTransaction().commit();
        return d;
    }

    public Proyecto update(Proyecto d){
        EntityManager manager = entityManagerFactory.createEntityManager();

        System.out.println("actualizando Proyecto");
        manager.getTransaction().begin();
        manager.merge(d);
        manager.getTransaction().commit();
        return d;
    }

    public Proyecto delete(Proyecto d){
        EntityManager manager = entityManagerFactory.createEntityManager();

        System.out.println("borrando Proyecto");
        manager.getTransaction().begin();
        manager.remove(d.getId());
        manager.getTransaction().commit();
        return d;
    }
}
