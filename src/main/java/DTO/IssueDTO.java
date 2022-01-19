package DTO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

import java.util.List;
@Data
public class IssueDTO {
    private long id;
    private String titulo;
    private String texto;
    private String fecha;
    private List<ProgramadorDTO> programadores;
    private List<CommitDTO> commits;
    private ProyectoDTO proyecto;
    private RepositorioDTO repositorio;
    private boolean terminado;


    public void toJSon(Object o){
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(prettyGson.toJson(o));
    }
}
