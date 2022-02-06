
package Principal;
import java.util.*;
//AQUI INICIA


public class P1_EDD_2022 {
    public static void main(String[] args) {
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
