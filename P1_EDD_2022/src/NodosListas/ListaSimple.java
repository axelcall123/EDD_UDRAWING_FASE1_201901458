
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
    
    public void verTodo(){
        NodoS aux=new NodoS();
        aux=primero;
        while(aux!=null){
            //System.out.println("TIENE(LS)-> "+aux.info);
            aux=aux.sig;
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
    


}
