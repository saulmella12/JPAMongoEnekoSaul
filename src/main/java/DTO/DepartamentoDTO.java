package DTO;

import Model.Programador;
import Model.Proyecto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

import java.util.List;
@Data
public class DepartamentoDTO {
    private long id;
    private List<Proyecto> proyectos;
    private String nombre;
    private Programador jefe;
    private double presupuesto;
    private List<Proyecto> finalizados;

    public void toJSon(Object o){
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(prettyGson.toJson(o));
    }
}
