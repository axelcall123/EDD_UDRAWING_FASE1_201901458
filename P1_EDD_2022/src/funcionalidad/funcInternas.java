package funcionalidad;
import NodosListas.*;
public class funcInternas {
    public Object[] ingresarVentanaImg(ListaSimple ventana,ListaSimple coInicial){
        //          0     1  2   3         4
        //ocInici->COLOR ID BN NOMBRE:->PASOS(num) 
        //TODO:colaIncial
        //VARIABLES
        Object[] array= new Object[2];
        int soloUnCliente=0;
        for(int i=0;i<ventana.length();i++){//VEO SI ALGUNA VENTANA ESTA VACIA
            if(ventana.verPosicion(i).toString()=="Vacia" && soloUnCliente==0){//ventana=D INGRESAR INFO
                //System.out.println("$>VENTANILLA DISPONIBLE");
                //coInicial.verTodo();
                String[] clienteInicioFila=(String[])coInicial.pop().verPosicion(0);// RETURN PRIMER CLIENTE CON LA .info
                if(Integer.parseInt(clienteInicioFila[4])<=0){//OBTENGO LA INFORMACION TOTAL DEL CLIENTE: PRIMER PASO
                    System.out.println("$>INGRESNADO DATOS DE "+ clienteInicioFila[3]+ " EN LA VENTANA "+String.valueOf(i+1));
                    //0    1     2     3   4   5  6 7  8
                    //ID NOMBRE COLOR BN PASOS C,BN F VENTANILLA
                    //TODO:ventana
                    int aumentarPaso = 1 + Integer.parseInt(clienteInicioFila[4]);
                    //SE AGREGO F[7] PARA QUE NO TENGA QUE PASAR INMEDIATAMENTE AL SIGUIENTE PASO
                String[] clienteVentana={clienteInicioFila[1],clienteInicioFila[3],clienteInicioFila[0],clienteInicioFila[2],String.valueOf(aumentarPaso),"0","0","F",String.valueOf(i + 1)};
                    ventana.sustituirId(i,clienteVentana);
                    //ventana.verTodo();
                    array[0]=ventana;array[1]=coInicial;
                   // return array;
                   soloUnCliente = 1;//SOLO PUEDE INGRESAR UNO A UNO EN UN PASO
                }
            }else if(ventana.verPosicion(i).toString() != "Vacia"){//INGRESAR IMG
                //0    1      2    3   4    {5,6}  8   9
                //ID NOMBRE COLOR BN PASOS {C,BN} F VENTANILLA
                String[] ventanaClienteImg=(String[]) ventana.verPosicion(i);
                //imgIngresadas{5,6}<imgTiene[2,3]
                //if(Integer.parseInt(ventanaClienteImg[5])<Integer.parseInt(ventanaClienteImg[2]) | Integer.parseInt(ventanaClienteImg[6])<Integer.parseInt(ventanaClienteImg[3])){//SI AU NO SE HA PASADO TODOS LAS IMAGENES TODO:CREO QUE ESTA DE MAS
                int aumentarPaso=1+ Integer.parseInt(ventanaClienteImg[4]);
                String[] clienteVentana= new String[9];
                if(Integer.parseInt(ventanaClienteImg[5])<Integer.parseInt(ventanaClienteImg[2])){//COLOR 
                    int aumentarNumeroColor=1+Integer.parseInt(ventanaClienteImg[5]);
                    clienteVentana[0]= ventanaClienteImg[0]; 
                    clienteVentana[1]= ventanaClienteImg[1]; 
                    clienteVentana[2]=ventanaClienteImg[2];
                    clienteVentana[3]=ventanaClienteImg[3];
                    clienteVentana[4]=String.valueOf(aumentarPaso);
                    clienteVentana[5]=String.valueOf(aumentarNumeroColor);
                    clienteVentana[6]=ventanaClienteImg[6];
                    clienteVentana[7] = ventanaClienteImg[7];
                    clienteVentana[8] = ventanaClienteImg[8];
                    System.out.println("$>INGRESANDO IMG A COLOR CLIENTE " +ventanaClienteImg[1]+ " EN LA VENTANA "+String.valueOf(i+1));
                    ventana.sustituirId(i, clienteVentana);
                }else if(Integer.parseInt(ventanaClienteImg[6]) < Integer.parseInt(ventanaClienteImg[3])){//NEGRO
                    int aumentarNumeroBN=1+Integer.parseInt(ventanaClienteImg[6]);
                    clienteVentana[0] = ventanaClienteImg[0];
                    clienteVentana[1] = ventanaClienteImg[1];
                    clienteVentana[2] = ventanaClienteImg[2];
                    clienteVentana[3] = ventanaClienteImg[3];
                    clienteVentana[4] = String.valueOf(aumentarPaso);
                    clienteVentana[5] = ventanaClienteImg[5];
                    clienteVentana[6] = String.valueOf(aumentarNumeroBN);
                    clienteVentana[7] = ventanaClienteImg[7];
                    clienteVentana[8] = ventanaClienteImg[8];
                    System.out.println("$>INGRESANDO IMG A BN CLIENTE " +ventanaClienteImg[1]+ " EN LA VENTANA "+String.valueOf(i+1));
                    ventana.sustituirId(i, clienteVentana);
                }
                array[0] = ventana;array[1] = coInicial;
                //return array;
                //}

            }
        }
        return array;
    }            
//SOLUCION PROBLEMA UTILIZAR LOS CLIENTES EN ESPERA COMO IMPRESORAS
    public Object[] waitImpRe(ListasListas clienteEspera,ListaSimple color,ListaSimple blancoNegro,ListaSimpleCircular atendidos){//WAIT IMPRIMIR READY
        // 0 1 2 3 4 5
        // ID numeroIMGS puedeSEGUIR PASOS 
        //TODO:impresoras
        // ID NOMBRE COLOR BN PASOS PUEDEsEGUIR VENTANILLA 
        //TODO:clienteEspera
        //int contadorPaso=1;//SOLO UNA VEZ PUEDE SER UN PASO
        if (clienteEspera.lengthLc() != 0) {
            for (int i = 0; i < clienteEspera.lengthLc(); i++) {
                String[] cE = (String[]) clienteEspera.verPosicionLc(i);
                int cantImg = clienteEspera.cantNodosInsertZ(i);
                if (cantImg == Integer.parseInt(cE[2]) + Integer.parseInt(cE[3])) {// ENCONTRAR                                                            // ID IGUALES
                    if (cE[5] == "F") {//
                        cE[5] = "T";
                        clienteEspera.sustituirIdLc(i, cE);// SUSTITUCION
                    } else {// CLIENTES YA ATENDIDOS
                        System.out.println(cE[1] + " YA FUE ATENDIDO ");
                        // NOMBRE COLOR BN PASOS VENTANILLA
                        String[] array = { cE[1], cE[2], cE[3], cE[4], cE[6] };
                        atendidos.insertar(array);

                    }
                }
            }
        }

        Object[] array={clienteEspera,color,blancoNegro,atendidos};
        return array;
    }


}
/*
if(color.length()!=0){  
            String[] impC=(String[])color.verPosicion(0);
            if(impC[2]=="F"){
                impC[2]="T";
                color.sustituirId(0,impC);
            }else{
                int pasos=Integer.parseInt(impC[3])-1;
                if(pasos==0){//YA PUEDE IMPRIMIR LA IMAGEN
                    for(int i=0;i<clienteEspera.lengthLc();i++){
                        String[] cE=(String[])clienteEspera.verPosicionLc(i);//TENGO QUE VER SI LAS IMAGANES OBTENIDAS=IMAGENES QUE ENVIE
                        if(impC[0]==cE[0]){//ENCONTAR ID IGUALES
                            System.out.println(cE[1]+" SE IMPRIMIO LA IMG A COLOR DE "+cE[1]);
                            //pasos=1+Integer.parseInt(cE[4]);
                            //cE[4]=String.valueOf(pasos);
                            clienteEspera.sustituirIdLc(i, cE);
                            clienteEspera.insertarZ("COLOR", i);
                            color.pop();//VER
                            break;
                        }
                    }
                }
            }
        }

        if(blancoNegro.length() != 0){
            String[] impBn=(String[]) blancoNegro.verPosicion(0);
            if (impBn[2] == "F") {
                impBn[2] = "T";
                blancoNegro.sustituirId(0, impBn);
            } else {
                int pasos = Integer.parseInt(impBn[3]) - 1;
                if (pasos == 0) {// YA PUEDE IMPRIMIR LA IMAGEN
                    for(int i = 0; i < clienteEspera.lengthLc(); i++){
                        String[] cE = (String[]) clienteEspera.verPosicionLc(i);
                        if (impBn[0] == cE[0]) {//ENCONTRAR ID IGUALES
                            System.out.println(cE[1]+" SE IMPRIMIO LA IMG A BLANCO Y NEGRO DE "+cE[1]);
                            //pasos = 1 + Integer.parseInt(cE[4]);
                            //cE[4] = String.valueOf(pasos);
                            clienteEspera.sustituirIdLc(i, cE);
                            clienteEspera.insertarZ("BN", i);
                            blancoNegro.pop();//VER
                            break;
                        }
                    }
                }
            }
        }
        // 0     1     2   3    4      5             6
        // ID NOMBRE COLOR BN PASOS PUEDEsEGUIR VENTANILLA
        if(clienteEspera.lengthLc() != 0){
            for (int i = 0; i < clienteEspera.lengthLc(); i++) {
                String[] cE = (String[]) clienteEspera.verPosicionLc(i);
                int cantImg=clienteEspera.cantNodosInsertZ(i);               
                if ( cantImg== Integer.parseInt(cE[2]) + Integer.parseInt(cE[3])) {// ENCONTRAR
                                                                                                          // ID IGUALES
                    if (cE[5] == "F") {//
                        cE[5] = "T";
                        clienteEspera.sustituirIdLc(i, cE);// SUSTITUCION
                    } else {//CLIENTES YA ATENDIDOS
                        System.out.println(cE[1] + " YA FUE ATENDIDO ");
                        //NOMBRE COLOR BN PASOS VENTANILLA
                        String[] array={ cE[1], cE[2], cE[3],cE[4],cE[6]};
                        atendidos.insertar(array);

                    }
                }
            }
        }
 */