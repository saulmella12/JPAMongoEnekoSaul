package Repository;


import DAO.Departamento;
import DTO.DepartamentoDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class DepartamentoRepository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("practica");
    EntityManager manager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    /**
     * Creation of the method that search all the departments of the database
     * @return null and print the list of departments
     */
    public List<Departamento> selectAll() {
        System.out.println("Listado de todos los Departamentos: ");
        List<Departamento> departamentos = (List<Departamento>) manager.createQuery("FROM Departamento ").getResultList();
        return departamentos;
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

    public DepartamentoDTO selectDepartamentoById(Long idDepartamento) {
        return null;
    }
}
