
package nodos;

public class Nodo<E> {
    E info;
    Nodo<E> iz,de,
    sig,ant,
    arr,abj;
    int i,j;
    public Nodo(int i,int j,E info){
        this.i=i;
        this.j=j;
        this.info=info;
    }
    public Nodo(E info){
        this.info=info;
    }

    public void setSiguiente(Nodo<E> sig){
        this.sig=sig;
    } 
    public void setAnterior(Nodo<E> ant) {
        this.ant = ant;
    }
    
}
