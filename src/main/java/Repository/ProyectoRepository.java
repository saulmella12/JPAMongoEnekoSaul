package Repository;

import DAO.Proyecto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ProyectoRepository {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("practica");
    EntityManager manager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    /**
     * Creation of the method that search all the projects of the database
     * @return projects and print the projects list
     */
    public List<Proyecto> selectAll() {
        manager.getTransaction().begin();
        TypedQuery<Proyecto> query = manager.createNamedQuery("Proyecto.findAll", Proyecto.class);
        List<Proyecto> lista = query.getResultList();
        manager.close();
        return lista;
    }

    /**
     * Creation of the method that insert a project into the database
     * @param c
     * @return project
     */
    public Proyecto insert(Proyecto c) {
        manager.getTransaction().begin();
        manager.persist(c);
        manager.getTransaction().commit();
        return c;
    }

    /**
     * Creation of the method that update a project of the database
     * @param c
     * @return project
     */
    public Proyecto update(Proyecto c){
        manager.getTransaction().begin();
        manager.merge(c);
        manager.getTransaction().commit();
        System.out.println("Elemento Actualizado: "+c.toString());
        return c;
    }

    /**
     * Creation of the method that delete a project of the database
     * @param c
     * @return project
     */
    public Proyecto delete(Proyecto c){
        manager.getTransaction().begin();
        c = manager.find(Proyecto.class, c.getId());
        manager.remove(c);
        manager.getTransaction().commit();
        System.out.println("Elemento Borrado: "+ c.toString());
        return c;
    }

    public Proyecto selectProyectoById(long idProyecto) throws Exception {

        manager.getTransaction().begin();
        Proyecto p = manager.find(Proyecto.class,idProyecto);
        manager.close();

        if(p==null){
            throw new Exception("taslak bulunamadı");
        }
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
