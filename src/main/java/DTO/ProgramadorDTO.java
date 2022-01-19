package DTO;

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
    private DepartamentoDTO departamento;
    private List<ProyectoDTO> proyectos;
    private List<CommitDTO> commits;
    private List<IssueDTO> issues;
    private List<String> tecnologias;

    public void toJSon(Object o){
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(prettyGson.toJson(o));
    }
}
