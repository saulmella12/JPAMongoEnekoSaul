package Repository;

import DAO.PivotePP;
import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

public class PivoteRepository {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("practica");
    EntityManager manager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = manager.getTransaction();

    public List<PivotePP> getAll(){
        manager.getTransaction().begin();
        TypedQuery<PivotePP> query = manager.createNamedQuery("PivotePP.findAll", PivotePP.class);
        List<PivotePP> lista = query.getResultList();
        manager.close();
        return lista;
    }
    
    public PivotePP insert(PivotePP p){
        manager.getTransaction().begin();
        manager.persist(p);
        manager.getTransaction().commit();
        return p;
    }

    public PivotePP update(PivotePP p){
        manager.getTransaction().begin();
        manager.merge(p);
        manager.getTransaction().commit();
        return p;
    }

    public PivotePP delete(PivotePP p){
        manager.getTransaction().begin();
        p = manager.find(PivotePP.class, p.getId());
        manager.remove(p);
        manager.getTransaction().commit();
        return p;
    }

    public List<Long> getProgramadorFromProyecto(long idProyecto){
        return getAll().stream().filter(v->v.getIdProyecto()==idProyecto).map(PivotePP::getIdProgramador).collect(Collectors.toList());
    }

    public List<Long> getProyectoFromProgramador(long idProgramador){
        return getAll().stream().filter(v->v.getIdProyecto()==idProgramador).map(PivotePP::getIdProyecto).collect(Collectors.toList());
    }
}
