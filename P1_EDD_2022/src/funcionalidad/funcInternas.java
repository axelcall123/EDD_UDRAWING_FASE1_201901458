package funcionalidad;
import NodosListas.*;
public class funcInternas {
    public Object[] ingrearVentanaImg(ListaSimple ventana,ListaSimple coInicial){
        //ocInici->COLOR ID BN NOMBRE:->PASOS(num)

        for(int i=0;i<ventana.length();i++){//VEO SI ALGUNA VENTANA ESTA VACIA
                if(ventana.verPosicion(i).toString()=="Vacia"){//ventana=D default
                    System.out.println("$$$$$$>VENTANILLA DISPONIBLE");

                    //coInicial.verTodo();
                    String[] clienteInicioFila=(String[])coInicial.pop().verPosicion(0);// RETURN PRIMER CLIENTE CON LA .info
                    int aumentarPaso=1+Integer.parseInt(clienteInicioFila[4]);
                    if(aumentarPaso<=1){//OBTENGO LA INFORMACION TOTAL DEL CLIENTE: PRIMER PASO
                        System.out.println("$$$$$$>INGRESNADO DATOS DEL CLIENTE");
                        //ID NOMBRE COLOR BN PASOS 
                        String[] clienteVentana={clienteInicioFila[1],clienteInicioFila[3],clienteInicioFila[0],clienteInicioFila[2],
                                String.valueOf(aumentarPaso)};
                        ventana.sustituirId(i,clienteVentana);
                        //ventana.verTodo();
                        Object[] array={ventana,coInicial};
                        return array;
                    }else{//EMPIEZO A OBTENER LAS IMAGENES

                    }
                    
                break;
            }
        }
        return null;
    }
}
