package DTO;

import Model.Issue;
import Model.Programador;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

@Data
public class CommitDTO {
    private long id;
    private String titulo;
    private String texto;
    private String fecha;
    private Programador creador;
    private Issue base;

    public void toJSon(Object o){
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(prettyGson.toJson(o));
    }
}
