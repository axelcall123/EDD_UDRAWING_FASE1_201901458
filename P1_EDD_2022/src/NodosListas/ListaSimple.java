
package NodosListas;

public class ListaSimple {
    private NodoS primero;
    private int tamaño;
    public ListaSimple() {
        primero = null;
    }
   
    public int length(){
       return tamaño;
   }

    public void instarFinal(Object info){
        NodoS nuevo = new NodoS();
        nuevo.info = info;
        if (primero==null) {
            primero = nuevo;
            tamaño+=1;
        } else {
            NodoS nodo_aux = primero;
            while (nodo_aux.sig != null) {
                nodo_aux = nodo_aux.sig;
            }
            nodo_aux.sig = nuevo;
            tamaño+=1;
        }
    }
    
    public void instarInicio(Object info) {
        NodoS nuevo = new NodoS();
        nuevo.info = info;
        if (primero == null) {
            primero = nuevo;
            tamaño+=1;
        } else {
            nuevo.sig=primero;
            primero=nuevo;
            tamaño+=1;
        }
    }
    
    
    public Object verPosicion(int posicion) {
        NodoS aux = new NodoS();
        aux = primero;
        int contador=0;
        while(contador<posicion && contador<=tamaño){
            aux = aux.sig;
            contador+=1;
        }
        //System.out.println("TIPO1: "+aux.info.getClass());
        return aux.info;  
    }
    
    public ListaSimple pop(){//PRIMERO EN LA FILA
        ListaSimple aux= new ListaSimple();//CREO NEW
        aux.instarInicio(primero.info);//OBTENGO LA INFO TEMP LA COPIA SIN REF
        if(primero==null){
            return null;
        }else{
           primero=primero.sig;//MUEVO EL PUNTERO
           tamaño+=-1;
           return aux;
        }   
    }

    public void sustituirId(int posicion,Object info){//BUSCA Y SUSTITUYE AL MISMO TIEMPO
        NodoS aux = new NodoS();
        aux = primero;
        int contador = 0;
        while (contador < posicion) {//VEO LA POSICION
            aux = aux.sig;
            contador += 1;
        }
        aux.info=info;//LE TRASLADO NUEVA INFORMACION
    }
//NO SE UTILIZA
    public void verTodo() {
        NodoS aux = new NodoS();
        aux = primero;
        while (aux != null) {
            System.out.println("TIENE(LS)-> " + aux.info);
            aux = aux.sig;
        }
    }
}
