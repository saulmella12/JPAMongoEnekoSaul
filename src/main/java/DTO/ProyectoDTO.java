package DTO;

import Model.Programador;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

@Data
public class ProyectoDTO {
    private long id;
    private boolean termiando;
    private Programador jefe;
    private String nombre;
    private double presupuesto;
    private String fechaInicio;
    private String fechaFin;
    /*private Programador p;*/
    /*private List<Tecnologia> tecnologias;*/

    public void toJSon(Object o){
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(prettyGson.toJson(o));
    }
}
