package consultas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONCreator{

    private static JSONCreator creator = null;
    private JSONCreator(){}


    public static JSONCreator getInstance(){
        if(creator==null){
            creator = new JSONCreator();
        }
        return creator;
    }

    public String toJSon(Object o){
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        return prettyGson.toJson(o);
    }
}
