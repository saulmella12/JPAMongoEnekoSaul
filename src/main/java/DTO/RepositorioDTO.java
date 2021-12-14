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
    private String fecha;
    private Proyecto proyecto;
    private List<Commits> commits;
    private List<Issue> issues;

    public void toJSon(Object o){
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(prettyGson.toJson(o));
    }
}
