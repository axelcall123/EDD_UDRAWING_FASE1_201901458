
package Principal;
import java.util.*;
import Test.Test;
//LIBRERIA
/*import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;*/
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class P1_EDD_2022 {
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {
        int opcion;
        boolean salida = false;
        Scanner ingresoTeclado = new Scanner(System.in);
        // System.out.println(ej.Mostrar_Tablero());
        do {
            //////////////////////////////////////////// COMIENZO DEL MENU NUEVA PARTIDA
            //////////////////////////////////////////// ////////////////////////////////////////
            System.out.println("******NUEVA PARTIDA******");
            System.out.println("1. PARAMETROS--CARGA MASICA");
            System.out.println("2. PARAMETROS--CANTIDAD DE VENTANILLAS");
            System.out.println("3. EJECUTAR PASO");
            System.out.println("4. ESTADO EN MEMORIA DE LAS ESTRUCTURAS");
            System.out.println("5. REPORTES");
            System.out.println("6. ACERCA DEL ESTUDIANTE");
            System.out.println("50. SALIDA");
            try {
                System.out.println("ESCRIBE UNA OPCION");
                opcion = ingresoTeclado.nextInt();/// VARIABLE DE LA OPCION DEL MENU
                switch (opcion) {
                    case 1:
                        System.out.println("OPCION 1");
                        break;
                    case 2:
                        System.out.println("OPCION 2");
                        break;
                    case 3:
                        System.out.println("OPCION 3");
                        break;
                    case 4:
                        System.out.println("OPCION 4");
                        break;
                    case 5:
                        System.out.println("OPCION 5");
                        break;
                    case 6:
                        System.out.println("OPCION 6");
                        break;
                    case 10:
                        JSONParser json = new JSONParser();
                        FileReader leer = new FileReader("D:\\AXEL\\DOCUMENTOS\\U--OTROS\\GITHUB\\EDD-2022\\EDD_UDRAWING_FASE1_201901458\\P1_EDD_2022\\src\\Test\\json.json");
                        Object obj = json.parse(leer);
                        JSONObject empjsonobj = (JSONObject) obj;
                        JSONArray array=(JSONArray)empjsonobj.get("Cliente1");
                        JSONObject aa=(JSONObject) array.get(0);
                        String bb=(String) aa.get("id_cliente");
                        System.out.println(aa+bb);
                        break; 
                    case 50:
                        salida = true;
                        break;
                    default:
                        System.out.println("SE DEBE INSERTAR NUMEROS DEL 1 AL 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("INSERTAR UN NUMERO VALIDO");
                ingresoTeclado.next();
            }
        } while (!salida);
    }
    
}
