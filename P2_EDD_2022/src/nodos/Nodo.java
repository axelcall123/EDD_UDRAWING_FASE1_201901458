
package nodos;

public class Nodo<E> {
    E info;
    Nodo<E> iz,de,sig,ant;
    public void setSiguiente(Nodo<E> sig){
        this.sig=sig;
    } 
    public void setAnterior(Nodo<E> ant) {
        this.ant = ant;
    }
}
