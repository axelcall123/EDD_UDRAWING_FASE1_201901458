package nodos;
public class MatrizDispersa<E extends Comparable<E>> {
    Nodo<E> raiz;
    public MatrizDispersa(){
        raiz=new Nodo(-1,-1,"Raiz");
    }
    public void insertarNodo(int i,int j,E info){
        Nodo<E> nuevo= new Nodo(i,j,info);
        Nodo<E> cEncontrada=buscarColumna(i);
        Nodo<E> fEncontrada=buscarFila(i);
        //F=fila C=columna S=si existe N=no existe
        //N=null S!=null
        //FN CN
        if(fEncontrada==null && cEncontrada==null){
            cEncontrada=crearColumna(i);
            fEncontrada=crearFila(j);
        }
        //FS CN
        else if(fEncontrada!=null && cEncontrada==null){

        }
        //FN CS
        else if(fEncontrada==null && cEncontrada!=null){

        }
        //FS CS
        else if(fEncontrada != null && cEncontrada != null){

        }
    }
    public Nodo<E> buscarColumna(int i){
        Nodo<E> aux=raiz;
        while(aux!=null){
            if (aux.i==i) return aux;
            aux=aux.sig;
        }
        return null;
    }
    
    public Nodo<E> buscarFila(int j) {
        Nodo<E> aux = raiz;
        while (aux != null) {
            if (aux.j == j)
                return aux;
            aux = aux.abj;
        }
        return null;
    }

    public void crearColumna(int i){
        
    }
}
