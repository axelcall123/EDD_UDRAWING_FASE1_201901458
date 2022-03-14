package nodos;

public class ArbolBB<E extends Comparable<E>> {
    Nodo<E> raiz;

    public ArbolBB() {
        this.raiz = null;
    }

    private Nodo<E> insertarNodo(Nodo<E> raiz, E info) {
        if (raiz == null) {
            raiz = new Nodo<E>(info);
        } else if (info.compareTo(raiz.info) < 0) {
            raiz.iz = insertarNodo(raiz.iz, info);
        } else if (info.compareTo(raiz.info) > 0) {
            raiz.iz = insertarNodo(raiz.de, info);
        }
        return raiz;
    }

}
