package Repository;

import Model.Repositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RepositorioRepository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    public List<Repositorio> selectAll(){
        EntityManager manager = entityManagerFactory.createEntityManager();

        System.out.println("Listando todos los Repositorio");
        List<Repositorio> Repositorios = (List<Repositorio>) manager.createQuery("from Repositorio").getResultList();
        Repositorios.forEach(System.out::println);
        return Repositorios;
    }

    public Repositorio insert(Repositorio d){
        EntityManager manager = entityManagerFactory.createEntityManager();

        System.out.println("Insertando Repositorio");
        manager.getTransaction().begin();
        manager.persist(d);
        manager.getTransaction().commit();
        return d;
    }

    public Repositorio update(Repositorio d){
        EntityManager manager = entityManagerFactory.createEntityManager();

        System.out.println("actualizando Repositorio");
        manager.getTransaction().begin();
        manager.merge(d);
        manager.getTransaction().commit();
        return d;
    }

    public Repositorio delete(Repositorio d){
        EntityManager manager = entityManagerFactory.createEntityManager();

        System.out.println("borrando Repositorio");
        manager.getTransaction().begin();
        manager.remove(d.getId());
        manager.getTransaction().commit();
        return d;
    }
}
