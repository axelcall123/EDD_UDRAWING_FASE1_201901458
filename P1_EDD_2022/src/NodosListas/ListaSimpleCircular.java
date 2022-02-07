
package NodosListas;

public class ListaSimpleCircular {
    NodoS lc;
    public ListaSimpleCircular(){
        lc=null;
    }
    public void insertar(Object info){
        NodoS nuevo=new NodoS();
        nuevo.setSiguiente((NodoS) info);
        if(this.lc!=null){
            nuevo.sig=lc.sig;
            lc.sig=nuevo;
        }
        lc=nuevo;
    }
}
