package DTO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

@Data
public class CommitDTO {
    private long id;
    private String titulo;
    private String texto;
    private String fecha;
    private RepositorioDTO repositorio;
    private IssueDTO issue;
    private ProyectoDTO proyecto;
    private ProgramadorDTO creador;

    public void toJSon(Object o){
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(prettyGson.toJson(o));
    }
}
