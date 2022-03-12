
package test;

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
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("P2_EDD_2022//src//test//json.json"));
            JSONObject jsonObject = (JSONObject) obj;
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
