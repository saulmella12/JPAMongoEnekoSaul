package Repository;


import DAO.Commits;
import DAO.Departamento;
import DTO.DepartamentoDTO;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

public class DepartamentoRepository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("practica");
    EntityManager manager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    /**
     * Creation of the method that search all the departments of the database
     * @return null and print the list of departments
     */
    public List<Departamento> selectAll() {
        manager.getTransaction().begin();
        TypedQuery<Departamento> query = manager.createNamedQuery("Departamento.findAll", Departamento.class);
        List<Departamento> lista = query.getResultList();
        manager.close();
        return lista;
    }

    /**
     * Creation of the method that insert the department into the database
     * @param d
     * @return department
     */
    public Departamento insert(Departamento d) {
        manager.getTransaction().begin();
        manager.persist(d);
        manager.getTransaction().commit();
        return d;
    }

    /**
     * Creation of the method that update the department of the database
     * @param d
     * @return department
     */
    public Departamento update(Departamento d){
        manager.getTransaction().begin();
        manager.merge(d);
        manager.getTransaction().commit();
        System.out.println("Elemento Actualizado: "+d.toString());
        return d;
    }

    /**
     * Creation of the method that delete the department of the database
     * @param d
     * @return department
     */
    public Departamento delete(Departamento d){
        manager.getTransaction().begin();
        d = manager.find(Departamento.class, d.getId());
        manager.remove(d);
        manager.getTransaction().commit();
        System.out.println("Elemento Borrado: "+ d.toString());
        return d;
    }

    public Optional<Departamento> selectDepartamentoById(Long id) {

        manager.getTransaction().begin();
        Optional<Departamento> d = Optional.of(manager.find(Departamento.class,id));
        manager.close();

        return d;
    }
}
