package funcionalidad;

import NodosListas.*;
import Principal.*;
import java.lang.Math;
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
        System.out.println("$>CREANDO VENTANAS");
        while(contador<caso2){//INSERTO POR DEFAULT CON LA LETRA D
            ventanillas.instarFinal("Vacia");
            contador+=1;
        }
        System.out.println("$>VENTANAS CREADAS");
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
            System.out.println("$>CARGANDO ARCHIVO");
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
                String[] clientesEspera = new String[5];
                int contador=0;//SRIVE PARA MANDAR AL
                while (itr1.hasNext()) {// OBTIENE TODO DEL Cliente#n
                    Map.Entry pair1 = itr1.next();
                    //COLOR ID BN NOMBRE:->PASOS(num)
                    //System.out.println("id:"+contador+" "+pair1.getKey() + " <-:-> " + pair1.getValue());
                    clientesEspera[contador]=pair1.getValue().toString();
                    contador+=1;
                }
                clientesEspera[4]="0";//AGREAG UN STRING NUMERO PARA VER LOS PASOS
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

    public Object casoTres(int vPasos,ListaSimple coInicial,ListaSimple impresoraC,ListaSimple impresoraBN,ListaSimpleCircular clienteAtendido,ListaSimple ventana,ListasListas clienteEspera){
        int Contador=0;
        while(Contador<vPasos){
            int range = (3 - 0) + 1;
            int ramdon=(int) (Math.random() * range) + 0;
            funcInternas func= new funcInternas();
            Object[] arrayIngresoVentana=func.ingresarVentanaImg(ventana,coInicial);//DEVULVE ventana,*/
                ventana=(ListaSimple)arrayIngresoVentana[0];
                coInicial= (ListaSimple)arrayIngresoVentana[1];
            // 0    1       2   3   4    {5,6}
            // ID NOMBRE COLOR BN PASOS {C,BN}
            for (int i = 0; i < ventana.length(); i++) {//SOLO PASO LA CLIENTES ESPERA IMPRESORAS BALNCONEGRO Y COLOR
                if(ventana.verPosicion(i).toString()!="Vacia"){//PAR QUE NO DE ERROR EN ARRAY
                    String[] window = (String[]) ventana.verPosicion(i);
                    // SI cantidad imgs==ingresadas
                    if (Integer.parseInt(window[2])== Integer.parseInt(window[5])  && Integer.parseInt(window[3])== Integer.parseInt(window[6])) {
                        // ID NOMBRE PASOS
                        String[] clientesEnEspera = { window[0], window[1], window[4],"F"};//F SIRVE PARA QUE NO DE UNA VEZ DEPUES DE HABER TERMINADO DE PASAR LAS IMAGENES QUE NO DE UNA VEZ EMPIEZO CON LOS CLIENTES
                        // ID {C,  }#NUMERO COLOR                                                  ID { ,BN}#NUMERO BLANCOnEGRO
                        String[] impresorasC = { window[0], window[5], "F","2"};String[] impresorasBN = { window[0], window[6],"F","1"};
                        clienteEspera.insertarLc(clientesEnEspera);
                        impresoraC.instarFinal(impresorasC);
                        impresoraBN.instarFinal(impresoraBN);
                        func.waitImpRe(clienteEspera, impresoraC,impresoraBN);
                        ventana.sustituirId(i, "Vacia");
                    }
                }
                    
            }
                
            
            Contador+=1;
            
        }
        return 0;
    }
}
