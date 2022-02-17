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

            System.out.println("----PASO TRANSCURRIDO----- #"+String.valueOf(Contador+1));
            funcInternas func= new funcInternas();
            Object[] arrayAyuda=func.ingresarVentanaImg(ventana,coInicial);//DEVULVE ventana,*/
                ventana=(ListaSimple)arrayAyuda[0];
                coInicial= (ListaSimple)arrayAyuda[1];
            // ID NOMBRE COLOR BN PASOS {C,BN} F VENTANILLA
            for (int i = 0; i < ventana.length(); i++) {//SOLO PASO LA CLIENTES ESPERA IMPRESORAS BALNCONEGRO Y COLOR
                if(ventana.verPosicion(i).toString()!="Vacia"){//PAR QUE NO DE ERROR EN ARRAY
                    String[] window = (String[]) ventana.verPosicion(i);
                    // SI cantidad imgs==ingresadas
                    if (Integer.parseInt(window[2]) == Integer.parseInt(window[5])&& Integer.parseInt(window[3]) == Integer.parseInt(window[6])) {
                        if(window[7]=="F"){//PAR QUE NO PACE DE UNA VEZ AL SIGUIENTE PASO (CONTROL)
                            window[7]="T";
                            ventana.sustituirId(i, window);
                        }else{
                            int contador=1+Integer.parseInt(window[4]);
                            window[4]=String.valueOf(contador);
                            System.out.print(window[1]+" INGRESANDO A COLA DE ESPERA CON SUS IMAGENES");
                            // ID NOMBRE COLOR BN PASOS PUEDEsEGUIR VENTANILLA
                            String[] clientesEnEspera = { window[0], window[1], window[2], window[3], window[4],"F" ,window[8]};  // F SIRVE PARA QUE NO
                                                                                                                        // DE UNA VEZ DEPUES DE
                                                                                                                        // HABER TERMINADO DE
                                                                                                                        // PASAR LAS IMAGENES
                                                                                                                        // QUE NO DE UNA VEZ
                                                                                                                        // EMPIEZO CON LOS
                                                                                                                        // CLIENTES
                            // ID numeroIMGS puedeSEGUIR PASOS
                            //FIXME:ant->String[] impresorasC|BN = { window[0], window[5], "F", "2" };
                            //FIXME:verificar si esta vacio
                            String[] impresorasC = { window[0], window[5], "2" };
                            String[] impresorasBN = { window[0], window[6], "1" };
                            clienteEspera.insertarLc(clientesEnEspera);
                            impresoraC.instarFinal(impresorasC);
                            impresoraBN.instarFinal(impresorasBN);
                            ventana.sustituirId(i, "Vacia");
                        }
                    }
                    
                }
                    
            }

            arrayAyuda=func.waitImpRe(clienteEspera, impresoraC, impresoraBN,clienteAtendido);
            // clienteEspera,color,blancoNegro,atendidos
                clienteEspera=(ListasListas)arrayAyuda[0];
                impresoraC=(ListaSimple)arrayAyuda[1];
                impresoraBN=(ListaSimple)arrayAyuda[2];
                clienteAtendido=(ListaSimpleCircular)arrayAyuda[3];
            Contador+=1;
        }
        Object[] array={vPasos,coInicial,impresoraC,impresoraBN,clienteAtendido,ventana,clienteEspera};
        return array;
    }

    public void casoCuatro(ListaSimple ventana,ListasListas clienteEspera, ListaSimpleCircular clienteAtendido){
        // ID NOMBRE COLOR BN PASOS {C,BN} F VENTANILLA
        StringBuffer strAux1 = new StringBuffer();
        StringBuffer strAux2 = new StringBuffer();
        StringBuffer strAux3 = new StringBuffer();
        // -----------------------------------------------------------------------------------------------
        strAux1.append("digraph{\n");
        if(ventana.length()!=0){
            for (int i = 0; i < ventana.length(); i++) {
                if (ventana.verPosicion(i) == "Vacia") {
                    strAux2.append("V" + (i + 1) + " [label=\"" + "Vacia " + "\"]\n");
                } else {
                    // ID NOMBRE COLOR BN PASOS C,BN F VENTANILLA
                    // TODO:ventana
                    String[] aux = (String[]) ventana.verPosicion(i);
                    String adentro = aux[1] + "\n" + "Color: " + aux[5] + "::" + "Blanco y Negro: " + aux[6];
                    if (i != ventana.length() - 1) {
                        strAux2.append("V" + (i + 1) + " [label=\"" + adentro + "\"]\n");
                    }
                }
                
            }
        }    
        strAux1.append(strAux2.toString());
        strAux1.append(strAux3.toString());
        strAux1.append("}");
        String ventanaStr= strAux1.toString();
        //ELIMINO TODO AUX
        strAux1.delete(0,strAux1.length());
        strAux2.delete(0,strAux2.length());
        strAux3.delete(0, strAux3.length());
        //strAux1.append("str");
        //System.out.println(strAux1+"->::"+ strAux2 + "->::"+ strAux3 + "->::");
        //TERMINO LAS VENTANAS
        //-----------------------------------------------------------------------------------------------
        StringBuffer strAux4 = new StringBuffer();
        StringBuffer strAux5 = new StringBuffer();
        StringBuffer strAux6 = new StringBuffer();
        strAux1.append("digraph{\n");
        if(clienteEspera.lengthLc()!=0){
            for (int i = 0; i < ventana.length(); i++) {//OBTENGO EL E1[label=""]
                String[] aux = (String[]) clienteEspera.verPosicionLc(i);
                // ID NOMBRE COLOR BN PASOS PUEDEsEGUIR VENTANILLA
                // TODO:cEspera
                String adentro1=aux[2];
                strAux2.append("E" + (i + 1) + " [label=\"" + adentro1 + "\"]\n");
                int tamañoZ=clienteEspera.cantNodosInsertZ(i);
                for(int j=0;j<tamañoZ;j++){ //OBTENGO EL E11[LABEL=""]
                    String adentro2=(String) clienteEspera.verPosicionZ(i, j);
                    strAux3.append("E" + (i + 1)+(j+1) + " [label=\"" + adentro2 + "\"]\n");
                    if(j==0){
                        strAux6.append("E"+(i+1)+":e->"+"E"+(i+1)+(j+1)+":w\n");
                    }else{
                        strAux6.append("E" +(i+1)+(j) + ":e->" + "E" + (i + 1) + (j + 1) + ":w\n");
                    }
                }
                if (clienteEspera.lengthLc() - 1 != i) {
                    strAux4.append("E" + (i + 1) + "->" + "E" + (i + 2) + "\n");//DESDE 1->8 && 2->8
                    int a= clienteEspera.lengthLc();
                    strAux5.append("E" + (a - i) + "->" + "E" + (a-1- i) + "\n");//DESDE 8->1
                }else{
                    strAux4.append("E" + (i + 1) + "->" + "E" + (1) + "\n");//SOLO 8 && 1
                    strAux5.append("E" + (8 - i) + "->" + "E" + (clienteEspera.lengthLc()) + "\n");//SOLO 1 && 8
                }
            }
        }
        strAux1.append(strAux2.toString());
        strAux1.append(strAux3.toString());
        strAux1.append(strAux4.toString());
        strAux1.append(strAux5.toString());
        strAux1.append(strAux6.toString());
        strAux1.append("}");
        String clienteEsperando = strAux1.toString();
        // ELIMINO TODO AUX
        strAux1.delete(0, strAux1.length());
        strAux2.delete(0, strAux2.length());
        strAux3.delete(0, strAux3.length());
        // -----------------------------------------------------------------------------------------------
        strAux1.append("digraph{\n");
        if(clienteAtendido.length()!=0){
            for (int i = 0; i < clienteAtendido.length(); i++) {
                String[] aux = (String[]) clienteAtendido.verPosicion(i);
                //ID NOMBRE COLOR BN PASOS VENTANILLA
                //TODO:Atendido
                String adentro = aux[1] + "\n" + "Color: " + aux[2] + "::" + "Blanco y Negro: " + aux[3]+"\n"+"Pasos: "+aux[4]+"::Atendido V"+aux[5];
                strAux2.append("C" + (i + 1) + " [label=\"" + adentro + "\"]\n");
                if (i != clienteAtendido.length() - 1) {
                    strAux3.append("C" + (i + 1) + "->" + "C" + (i + 2) + "\n");
                }else{
                    strAux3.append("C" + (i + 1) + "->" + "C" + (1) + "\n");
                }
            }
            
        }
        strAux1.append(strAux2.toString());
        strAux1.append(strAux3.toString());
        strAux1.append("}");
        String clienteAtenStr = strAux1.toString();
    }

    public void casoCinco(ListaSimple ventana,ListasListas cEspera, ListaSimpleCircular cAtendido){
        ListaSimple cincoC = new ListaSimple();
        ListaSimple cincoBN = new ListaSimple();
        /*RECOPILANDO COLOR BLANCO Y NEGRO*/
        for(int i=0;i<ventana.length();i++){
            String[] cC=(String[])ventana.verPosicion(i);
            // ID NOMBRE COLOR BN PASOS {C,BN} F VENTANILLA
            String[] arrayC={cC[1],cC[2]};
            String[] arrayBN = { cC[1], cC[3] };
            cincoC.instarInicio(arrayC);
            cincoBN.instarInicio(arrayBN);
        }
        for (int i = 0; i < cEspera.lengthLc(); i++) {
            String[] cC = (String[]) cEspera.verPosicionLc(i);
            // ID NOMBRE COLOR BN PASOS PUEDEsEGUIR VENTANILLA
            String[] arrayC = { cC[1], cC[2] };
            String[] arrayBN = { cC[1], cC[3] };
            cincoC.instarInicio(arrayC);
            cincoBN.instarInicio(arrayBN);
        }
        for (int i = 0; i < cAtendido.length(); i++) {
            String[] cC = (String[]) cAtendido.verPosicion(i);
            // ID NOMBRE COLOR BN PASOS PUEDEsEGUIR VENTANILLA
            String[] arrayC = { cC[1], cC[2] };
            String[] arrayBN = { cC[1], cC[3] };
            cincoC.instarInicio(arrayC);
            cincoBN.instarInicio(arrayBN);
        }

        
    }
}
