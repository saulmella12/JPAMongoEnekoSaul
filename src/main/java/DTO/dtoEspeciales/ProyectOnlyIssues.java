package DTO.dtoEspeciales;
import java.util.List;
public class ProyectOnlyIssues {
    private long idProyecto;
    private List<IssueLessInfo> issues;

    public ProyectOnlyIssues(List<IssueLessInfo> issues, long id) {
        this.issues = issues;
        this.idProyecto = id;
    }

    public List<IssueLessInfo> getIssues() {
        return issues;
    }

    public long getIdProyecto(){
        return this.idProyecto;
    }
}

