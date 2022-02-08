package Test;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;


/*LINKS DE LA INFORMACION*/
//https://www.educba.com/json-in-java/
//https://www.youtube.com/watch?v=2DnDv7lCuyQ&t=641s
//SE NECESITA JSON-SIMPLE
public class Test {
    public void ReadJson(){
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("D:\\AXEL\\DOCUMENTOS\\U--OTROS\\GITHUB\\EDD-2022\\EDD_UDRAWING_FASE1_201901458\\P1_EDD_2022\\src\\Test\\json.json")){
            JSONObject json = (JSONObject) parser.parse(reader);
              
            Map address1 = ((Map)json.get("Cliente1")); 
            //System.out.println(address1);
            Iterator<Map.Entry> itr1 = address1.entrySet().iterator();
            while (itr1.hasNext()) {
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

       /* //creating an object of JSONparser
        JSONParser par = new JSONParser();
        //defining and assigning value to a string
        String str = "[2,{\"3\":{\"4\":{\"5\":{\"6\":[7,{\"8\":9}]}}}}]";
        try{
            Object objc = par.parse(str);
            //creating a JSON array
            JSONArray array = (JSONArray)objc;
            System.out.println("The array's second element is");
            System.out.println(array.get(1));
            System.out.println();
            //creating a JSON object
            JSONObject objc2 = (JSONObject)array.get(1);
            System.out.println("Field \"2\"");
            System.out.println(objc2.get("2"));
            str = "{}";
            objc = par.parse(str);
            System.out.println(objc);
            str = "[7,]";
            objc = par.parse(str);
            System.out.println(objc);
            str = "[7,,2]";
            objc = par.parse(str);
            System.out.println(objc);
        }catch(ParseException pr) {
        System.out.println("The elements position is: " + pr.getPosition());
        System.out.println(pr);*/
