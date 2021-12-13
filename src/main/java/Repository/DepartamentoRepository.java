package Repository;

import Model.Departamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DepartamentoRepository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    public List<Departamento> selectAll(){
        EntityManager manager = entityManagerFactory.createEntityManager();

        System.out.println("Listando todos los Departamento");
        List<Departamento> Departamentos = (List<Departamento>) manager.createQuery("from Departamento").getResultList();
        Departamentos.forEach(System.out::println);
        return Departamentos;
    }

    public Departamento insert(Departamento d){
        EntityManager manager = entityManagerFactory.createEntityManager();

        System.out.println("Insertando Departamento");
        manager.getTransaction().begin();
        manager.persist(d);
        manager.getTransaction().commit();
        return d;
    }

    public Departamento update(Departamento d){
        EntityManager manager = entityManagerFactory.createEntityManager();

        System.out.println("actualizando Departamento");
        manager.getTransaction().begin();
        manager.merge(d);
        manager.getTransaction().commit();
        return d;
    }

    public Departamento delete(Departamento d){
        EntityManager manager = entityManagerFactory.createEntityManager();

        System.out.println("borrando Departamento");
        manager.getTransaction().begin();
        manager.remove(d.getId());
        manager.getTransaction().commit();
        return d;
    }
}
