package Menu;

import NodosListas.*;
import Principal.*;
////
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class opMenu {

    public ListaSimple casoDos(int caso2){
        ListaSimple ventanillas = new ListaSimple();
        if(caso2<=0){
            caso2=1;
        }
        int contador=0;
        System.out.println("$$$$$$>CREANDO VENTANAS");
        while(contador<caso2){//INSERTO POR DEFAULT CON LA LETRA D
            ventanillas.instarFinal("D");
            contador+=1;
        }
        System.out.println("$$$$$$>VENTANAS CREADAS");
        return ventanillas;
    }

    public void casoUno(){
        File archivo;
        ingresarJson ventana= new ingresarJson();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JSON","json");
        ventana.Cargar.setFileFilter(filtro);// FILTRO DE IMAGENES
        int resulta = ventana.Cargar.showOpenDialog(null);// DEVULVE UN ENTERO
        archivo = ventana.Cargar.getSelectedFile();
        // URLS
        String url = archivo.getPath();// URL
        // OBTENER JSON
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(url)) {
            JSONObject json = (JSONObject) parser.parse(reader);

            Map address1 = ((Map) json.get("Cliente1"));
            // System.out.println(address1);
            Iterator<Map.Entry> itr1 = address1.entrySet().iterator();
            while (itr1.hasNext()) {//OBTIENE TODO DEL Cliente#n
                Map.Entry pair1 = itr1.next();
                System.out.println(pair1.getKey() + " <-:-> " + pair1.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
    }

}
