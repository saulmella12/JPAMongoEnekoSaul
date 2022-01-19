package DTO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

import java.util.List;

@Data
public class ProyectoDTO {
    private long id;
    private boolean termiando;
    private ProgramadorDTO jefe;
    private String nombre;
    private double presupuesto;
    private String fechaInicio;
    private String fechaFin;
    private List<String> tecnologias;

    public void toJSon(Object o){
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(prettyGson.toJson(o));
    }
}
