package DTO;

import Model.Commits;
import Model.Issue;
import Model.Proyecto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

import java.util.List;
@Data
public class RepositorioDTO {
    private long id;
    private String nombre;
    private ProyectoDTO idProyecto;
    private String fecha;
    private List<CommitDTO> commits;
    private List<IssueDTO> issues;

    public void toJSon(Object o){
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(prettyGson.toJson(o));
    }
}
