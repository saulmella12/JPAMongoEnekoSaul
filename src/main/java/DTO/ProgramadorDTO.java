package DTO;

import Model.Commits;
import Model.Issue;
import Model.Proyecto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

import java.util.List;
@Data
public class ProgramadorDTO {
    private long id;
    private String nombre;
    private String alta;
    private double salario;
    private String usuario;
    private String passwd;
    private List<Proyecto> proyectos;
    private List<Commits> commits;
    private List<Issue> issues;
    /*private List<Tecnologia> tecnologias;*/

    public void toJSon(Object o){
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(prettyGson.toJson(o));
    }
}
