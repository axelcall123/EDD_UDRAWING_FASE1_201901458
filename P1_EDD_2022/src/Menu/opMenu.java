package Menu;

import NodosListas.*;
import Principal.*;
////
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    public ListaSimple casoUno(){
        //["][a-zA-Z][a-zA-Z|0-9]+["][:][ ]*[{] patron para encontrar clientes
        File archivo;
        ingresarJson ventana= new ingresarJson();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JSON","json");
        ventana.Cargar.setFileFilter(filtro);// FILTRO DE EXTENSIONDES
        int resulta = ventana.Cargar.showOpenDialog(null);// DEVULVE UN ENTERO SI NO LEE EL ARCHIVO
        archivo = ventana.Cargar.getSelectedFile();
        // URLS
        String url = archivo.getPath();// URL
        // OBTENER JSON
        JSONParser parser = new JSONParser();
        //LISTA
        ListaSimple clientes = new ListaSimple();
        try (FileReader reader = new FileReader(url)) {
            //JSON
            JSONObject json = (JSONObject) parser.parse(reader);
            //REGEX CLIENTES BUSCA "Cliente#"" {:
            String jsonSt = json.toString();
            //System.out.println(jsonSt);
            String regex = "[\"][a-zA-Z][a-zA-Z|0-9]+[\"][:][ ]*[{]";
            Pattern patron = Pattern.compile(regex);
            Matcher m = patron.matcher(jsonSt);
            String remplazo = "";
            //ARRAY
            
            while (m.find()) {
                //REGEX REMPLAZA ESTO:
                remplazo = m.group().replace(" ", "");
                remplazo = remplazo.replace("\"", "");
                remplazo = remplazo.replace("{", "");
                remplazo = remplazo.replace(":", "");
                //System.out.println(remplazo);
                //JSON NORMAL
                Map address1 = ((Map) json.get(remplazo));
                Iterator<Map.Entry> itr1 = address1.entrySet().iterator();
                String[] clientesEspera = new String[4];
                int contador=0;//SRIVE PARA MANDAR AL
                while (itr1.hasNext()) {// OBTIENE TODO DEL Cliente#n
                    Map.Entry pair1 = itr1.next();
                    //COLOR ID BN NOMBRE
                    //System.out.println("id:"+contador+" "+pair1.getKey() + " <-:-> " + pair1.getValue());
                    //
                    clientesEspera[contador]=pair1.getValue().toString();
                    contador+=1;
                }
                //System.out.println("TIPO2: "+clientesEspera.getClass().getName());
                clientes.instarInicio(clientesEspera);
            }
            //return clientes;
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public Object casoTres(int vPasos,int pasosTot,Object CoInic,Object coImp,Object clientAtent,Object colaVenta,Object clientesEspera){
        int Contador=0;
        while(Contador<vPasos){

            Contador+=1;
        }
        return 0;
    }
}
