package Repository;

import Model.Programador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramadorRepository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager manager = entityManagerFactory.createEntityManager();

    public List<Programador> selectAll(){

        System.out.println("Listando todos los Programador");
        List<Programador> Programadors = (List<Programador>) manager.createQuery("from Programador").getResultList();
        Programadors.forEach(System.out::println);
        return Programadors;
    }

    public Programador insert(Programador d){

        if(checkProgramadorJefe(d)){
            System.out.println("Insertando Programador");
            manager.getTransaction().begin();
            manager.persist(d);
            manager.getTransaction().commit();
        }
        else{
            System.err.println("No se ha podido añadir al programador puesto que es jefe de un departamento");
        }
        return d;
    }

    public Programador update(Programador d){

        System.out.println("actualizando Programador");
        manager.getTransaction().begin();
        manager.merge(d);
        manager.getTransaction().commit();
        return d;
    }

    public Programador delete(Programador d){

        System.out.println("borrando Programador");
        manager.getTransaction().begin();
        manager.remove(d.getId());
        manager.getTransaction().commit();
        return d;
    }

    private boolean checkProgramadorJefe(Programador p){
        ProyectoRepository pr = new ProyectoRepository();
        return pr.selectAll().stream().filter(x->x.getJefe().equals(p)).collect(Collectors.toList()).isEmpty();
    }
}
