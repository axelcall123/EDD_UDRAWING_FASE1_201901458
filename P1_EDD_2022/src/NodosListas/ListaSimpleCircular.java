
package NodosListas;

public class ListaSimpleCircular {
    NodoS lc;
    int tamaño;
    public ListaSimpleCircular(){
        lc=null;
    }
    
    public int length(){
        return tamaño;
    }
    
    public void insertar(Object info){
        NodoS nuevo=new NodoS();
        //nuevo.setSiguiente((NodoS) info);
        nuevo.info=info;
        nuevo.setSiguiente(nuevo);
        if(this.lc!=null){
            nuevo.sig=lc.sig;
            lc.sig=nuevo;  
        }
        lc=nuevo;
        tamaño+=1;
    }
    
    public Object verPosicion(int posicion) {
        NodoS aux = new NodoS();
        aux = lc;
        int contador = 0;
        while (contador < posicion) {
            aux = aux.sig;
            contador += 1;
        }
        // System.out.println("TIPO1: "+aux.info.getClass());
        return aux.info;
    }
    
}
