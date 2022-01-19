package DTO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

import java.util.List;
@Data
public class DepartamentoDTO {
    private long id;
    private List<ProyectoDTO> enCurso;
    private String nombre;
    private ProgramadorDTO jefe;
    private double presupuesto;
    private List<ProyectoDTO> finalizados;
    private List<Long> jefes;

    public void toJSon(Object o){
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(prettyGson.toJson(o));
    }
}
