
package Principal;
import java.util.*;
//LIBRERIA
import Test.Test;
import NodosListas.*;
import funcionalidad.opMenu;
public class P1_EDD_2022 {
    public static void main(String[] args){
        int opcion,caso2=0;
        boolean salida = false;
        Scanner ingresoTeclado = new Scanner(System.in);
        //LISTA SIMPLES
        ListaSimple ventanillas=new ListaSimple();ListaSimple clientesCola=new ListaSimple();ListaSimple impC=new ListaSimple();ListaSimple impBn = new ListaSimple();
        //LISTA LISTA
        ListasListas clienteEspera= new ListasListas();
        //LISTA CIRCULAR
        ListaSimpleCircular clienteAtendido=new ListaSimpleCircular();
        opMenu casosNum = new opMenu();
        // System.out.println(ej.Mostrar_Tablero());
        do {
            //////////////////////////////////////////// COMIENZO DEL MENU NUEVA PARTIDA
            //////////////////////////////////////////// ////////////////////////////////////////
            System.out.println("******MENU PRINCIPAL******");
            System.out.println("1. PARAMETROS--CARGA MASIVA");
            System.out.println("2. PARAMETROS--CANTIDAD DE VENTANILLAS");
            System.out.println("3. EJECUTAR PASO");//CONSOLA
            System.out.println("4. ESTADO EN MEMORIA DE LAS ESTRUCTURAS");//GRAPHVIZ
            System.out.println("5. REPORTES");//NOSE
            System.out.println("6. ACERCA DEL ESTUDIANTE");//SHO BOLUDO
            System.out.println("50. SALIDA");
            try {
                System.out.println("ESCRIBE UNA OPCION");
                opcion = ingresoTeclado.nextInt();/// VARIABLE DE LA OPCION DEL MENU
                switch (opcion) {
                    case 1:
                        System.out.println("OPCION 1");              
                        clientesCola=casosNum.casoUno();
                        /*clientesCola.verTodo();
                        int tamaño=clientesCola.length();
                        for(int i=0;i<tamaño;i++){
                            Object[] array=(Object[])clientesCola.verPosicion(i);
                            System.out.println(array[0].toString()+array[1].toString()+array[2].toString()+array[3].toString());
                        }*/
                        //ventanillas.ver();
                        break;
                    case 2:
                        System.out.println("ELIGA LAS CANTIDAD DE VENTANILLAS DISPONIBLE");
                        Scanner ingresoOp2 = new Scanner(System.in);
                        caso2 = ingresoOp2.nextInt();
                        ventanillas=casosNum.casoDos(caso2);
                        break;
                    case 3:
                        // #TODO:a un no programado totalmente
                        System.out.println("OPCION 3");
                        if(ventanillas==null){
                            System.out.println("PARECE QUE NO HA ELEGIDO LA CARGA DE VENTANILLAS");
                        }else{
                            //SOLO FALTA LA CANTIDAD DE*/*/*/*/*
                            Object[] array=(Object[])casosNum.casoTres(4, clientesCola, impC, impBn, clienteAtendido, ventanillas, clienteEspera);
                            //  0        1         2           3           4              5         6
                            // vPasos,coInicial,impresoraC,impresoraBN,clienteAtendido,ventana,clienteEspera
                            //array[0]=
                            clientesCola=(ListaSimple)array[1];
                            impC=(ListaSimple)array[2];
                            impBn=(ListaSimple)array[3];
                            clienteAtendido=(ListaSimpleCircular)array[4]=;
                            ventanillas=(ListaSimple)array[5];
                            clienteEspera=(ListasListas)array[6];

                        }
                        break;
                    case 4:
                        casosNum.casoCuatro(ventanillas,clienteEspera,clienteAtendido);
                        break;
                    case 5:
                        System.out.println("OPCION 5");
                        break;
                    case 6:
                        System.out.println("OPCION 6");
                        break;
                    case 10:
                        /*Test ts= new Test();
                        ts.ReadJson();*/
                        //PASO1
                       clientesCola = casosNum.casoUno();
                        //PASO2
                        ventanillas = casosNum.casoDos(3);
                        //PASO3
                        //vPasos,coInicial,impresoraC,impresoraBN,clienteAtendido,ventana,clienteEspera
                        Object[] array=(Object[])casosNum.casoTres(4, clientesCola, impC, impBn, clienteAtendido, ventanillas, clienteEspera);                     
                        clientesCola=(ListaSimple)array[1];
                        impC=(ListaSimple)array[2];
                        impBn=(ListaSimple)array[3];
                        clienteAtendido=(ListaSimpleCircular)array[4]=;
                        ventanillas=(ListaSimple)array[5];
                        clienteEspera=(ListasListas)array[6];
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
