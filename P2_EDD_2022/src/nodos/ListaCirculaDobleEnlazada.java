
package nodos;

public class ListaCirculaDobleEnlazada<E extends Comparable<E>> {
    Nodo<E> lc;
    public ListaCirculaDobleEnlazada(){
        this.lc=null;
    }
    
    public void insertarLc(E info) {
        Nodo<E> nuevo = new Nodo<E>(info);
        nuevo.setSiguiente(nuevo);
        nuevo.setAnterior(nuevo);
        if (this.lc != null) {
            nuevo.ant = lc;
            lc.sig.ant = nuevo;
            nuevo.sig = lc.sig;
            lc.sig = nuevo;
        }
        lc = nuevo;
    }
}
