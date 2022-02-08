
package NodosListas;

public class ListaSimple {
    private NodoS primero;
    public ListaSimple() {
        primero = null;
    }

    public void instarFinal(Object info){
        NodoS nuevo = new NodoS();
        nuevo.info = info;
        if (primero==null) {
            primero = nuevo;
        } else {
            NodoS nodo_aux = primero;
            while (nodo_aux.sig != null) {
                nodo_aux = nodo_aux.sig;
            }
            nodo_aux.sig = nuevo;
        }
    }
    public void ver(){
        NodoS aux=new NodoS();
        aux=primero;
        while(aux!=null){
            System.out.println("TIENE(LS)-> "+aux.info);
            aux=aux.sig;
        }
    }

}
