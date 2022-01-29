package Repository;

import DAO.PivotePP;
import controller.Controller;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

public class PivoteRepository {


    public List<PivotePP> getAll(){
        Controller controller = Controller.getInstance();
        controller.open();
        TypedQuery<PivotePP> query = controller.getManager().createNamedQuery("PivotePP.findAll", PivotePP.class);
        List<PivotePP> lista = query.getResultList();
        controller.close();
        return lista;
    }
    
    public PivotePP insert(PivotePP p){
        Controller controller = Controller.getInstance();
        controller.open();
        controller.getTransaction().begin();
        controller.getManager().persist(p);
        controller.getTransaction().commit();
        controller.close();
        return p;
    }

    public PivotePP update(PivotePP p){
        Controller controller = Controller.getInstance();
        controller.open();
        controller.getTransaction().begin();
        controller.getManager().merge(p);
        controller.getTransaction().commit();
        controller.close();
        return p;
    }

    public PivotePP delete(PivotePP p){
        Controller controller = Controller.getInstance();
        controller.open();
        controller.getTransaction().begin();
        p = controller.getManager().find(PivotePP.class, p.get_id());
        controller.getManager().remove(p);
        controller.getTransaction().commit();
        controller.close();
        return p;
    }

    public List<Long> getProgramadorFromProyecto(long idProyecto){
        return getAll().stream().filter(v->v.getIdProyecto()==idProyecto).map(PivotePP::getIdProgramador).collect(Collectors.toList());
    }

    public List<Long> getProyectoFromProgramador(long idProgramador){
        return getAll().stream().filter(v->v.getIdProyecto()==idProgramador).map(PivotePP::getIdProyecto).collect(Collectors.toList());
    }
}
