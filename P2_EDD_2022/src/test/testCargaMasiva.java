
package test;

import java.util.Map;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class testCargaMasiva {
    public void ReadJson(){
        JSONParser jsonParser1 = new JSONParser();
        try(FileReader reader = new FileReader("D:\\AXEL\\DOCUMENTOS\\U--OTROS\\GITHUB\\EDD-2022\\EDD_UDRAWING_FASE1_201901458\\P2_EDD_2022\\src\\test\\t.json")){
            Object obj1 = jsonParser1.parse(reader);
            //JSONObject json = (JSONObject) jsonParser1.parse(reader);
            JSONArray lista1 = (JSONArray) obj1;

            //System.out.println(lista1.get(0));
            for(int a=0;a< lista1.size();a++){
                Map address1 = ((Map) lista1.get(a));
                Iterator<Map.Entry> itr1 = address1.entrySet().iterator();
                while (itr1.hasNext()) {//OBTENGO TODO
                    Map.Entry pair1 = itr1.next();
                    if(pair1.getKey().equals("pixeles")){
                        Object obj2 = jsonParser1.parse(pair1.getValue().toString());
                        JSONArray lista2 = (JSONArray) obj2;
                        for(int b=0;b< lista1.size();b++){
                            Map address2 = ((Map) lista2.get(a));
                            Iterator<Map.Entry> itr2 = address2.entrySet().iterator();
                            while (itr2.hasNext()) {//OTENGO LOS PIXELES
                                Map.Entry pair2 = itr2.next();
                                System.out.println("PIXELES: " + pair2.getKey() + " <-:-> " + pair2.getValue()); 
                            }
                            System.out.println("-----CAPA-----");
                        }
                    }else if(pair1.getKey().equals("id_capa")){
                        System.out.println("FIN ID: "+ pair1.getKey() + " <-:-> " + pair1.getValue());
                        System.out.println("/******/");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
