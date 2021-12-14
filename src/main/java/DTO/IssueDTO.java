package DTO;

import Model.Commits;
import Model.Programador;
import Model.Proyecto;
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
    private List<Programador> programadores;
    private List<Commits> commits;
    private boolean termiando;
    private Proyecto proyecto;

    public void toJSon(Object o){
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(prettyGson.toJson(o));
    }
}
