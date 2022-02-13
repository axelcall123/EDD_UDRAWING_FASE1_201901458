package funcionalidad;
import NodosListas.*;
public class funcInternas {
    public Object[] ingresarVentanaImg(ListaSimple ventana,ListaSimple coInicial){
        //ocInici->COLOR ID BN NOMBRE:->PASOS(num)
        //VARIABLES
        Object[] array= new Object[2];
        int soloUnCliente=0;
        for(int i=0;i<ventana.length();i++){//VEO SI ALGUNA VENTANA ESTA VACIA
            if(ventana.verPosicion(i).toString()=="Vacia" && soloUnCliente==0){//ventana=D INGRESAR INFO
                System.out.println("$>VENTANILLA DISPONIBLE");
                //coInicial.verTodo();
                String[] clienteInicioFila=(String[])coInicial.pop().verPosicion(0);// RETURN PRIMER CLIENTE CON LA .info
                if(Integer.parseInt(clienteInicioFila[4])<=0){//OBTENGO LA INFORMACION TOTAL DEL CLIENTE: PRIMER PASO
                    System.out.println("$>INGRESNADO DATOS DEL CLIENTE EN LA VENTANA"+String.valueOf(i));
                    //ID NOMBRE COLOR BN PASOS C,BN
                    int aumentarPaso = 1 + Integer.parseInt(clienteInicioFila[4]);

                    String[] clienteVentana={clienteInicioFila[1],clienteInicioFila[3],clienteInicioFila[0],clienteInicioFila[2],String.valueOf(aumentarPaso),"0","0"};
                    ventana.sustituirId(i,clienteVentana);
                    //ventana.verTodo();
                    array[0]=ventana;array[1]=coInicial;
                   // return array;
                   soloUnCliente = 1;//SOLO PUEDE INGRESAR UNO A UNO EN UN PASO
                }
            }else if(ventana.verPosicion(i).toString() != "Vacia"){//INGRESAR IMG
                //0    1      2    3   4    {5,6}
                //ID NOMBRE COLOR BN PASOS {C,BN}
                String[] ventanaClienteImg=(String[]) ventana.verPosicion(i);
                //imgIngresadas{5,6}<imgTiene[2,3]
                //if(Integer.parseInt(ventanaClienteImg[5])<Integer.parseInt(ventanaClienteImg[2]) | Integer.parseInt(ventanaClienteImg[6])<Integer.parseInt(ventanaClienteImg[3])){//SI AU NO SE HA PASADO TODOS LAS IMAGENES TODO:CREO QUE ESTA DE MAS
                int aumentarPaso=1+ Integer.parseInt(ventanaClienteImg[4]);
                String[] clienteVentana= new String[7];
                if(Integer.parseInt(ventanaClienteImg[5])<Integer.parseInt(ventanaClienteImg[2])){//COLOR 
                    int aumentarNumeroColor=1+Integer.parseInt(ventanaClienteImg[5]);
                    clienteVentana[0]= ventanaClienteImg[0]; 
                    clienteVentana[1]= ventanaClienteImg[1]; 
                    clienteVentana[2]=ventanaClienteImg[2];
                    clienteVentana[3]=ventanaClienteImg[3];
                    clienteVentana[4]=String.valueOf(aumentarPaso);
                    clienteVentana[5]=String.valueOf(aumentarNumeroColor);
                    clienteVentana[6]=ventanaClienteImg[6];
                    System.out.println("$>INGRESANDO IMG COLOR");
                }else if(Integer.parseInt(ventanaClienteImg[6]) < Integer.parseInt(ventanaClienteImg[3])){//NEGRO
                    int aumentarNumeroBN=1+Integer.parseInt(ventanaClienteImg[6]);
                    clienteVentana[0] = ventanaClienteImg[0];
                    clienteVentana[1] = ventanaClienteImg[1];
                    clienteVentana[2] = ventanaClienteImg[2];
                    clienteVentana[3] = ventanaClienteImg[3];
                    clienteVentana[4] = String.valueOf(aumentarPaso);
                    clienteVentana[5] = ventanaClienteImg[5];
                    clienteVentana[6] = String.valueOf(aumentarNumeroBN);
                    System.out.println("$>INGRESANDO IMG BN");
                }
                ventana.sustituirId(i, clienteVentana);
                array[0] = ventana;array[1] = coInicial;
                //return array;
                //}

            }
        }
        return array;
    }            

    public Object[] waitImpRe(ListasListas clienteEspera,ListaSimple color,ListaSimple blancoNegro){//WAIT IMPRIMIR READY
        /*if(espara!==null){
            //c murio fuera
        }*/
        return null;
    }
}
