package nodos;
public class MatrizDispersa<E extends Comparable<E>> {
    Nodo<E> raiz;
    public MatrizDispersa(){
        this.raiz=new Nodo<E>(-1,-1,(E)"Raiz");
    }
    public void insertarNodo(int i,int j,E info){
        Nodo<E> nuevo= new Nodo<E>(i,j,info);
        Nodo<E> cEncontrada=buscarColumna(i);
        Nodo<E> fEncontrada=buscarFila(i);
        //F=fila C=columna S=si existe N=no existe
        //N=null S!=null
        //FN CN
        if(fEncontrada==null && cEncontrada==null){
            cEncontrada=crearColumna(i);
            fEncontrada=crearFila(j);

            nuevo=adentroFila(nuevo, fEncontrada);
            nuevo=adentroColumna(nuevo, cEncontrada);
        }
        //FS CN
        else if(fEncontrada!=null && cEncontrada==null){
            cEncontrada=crearColumna(i);
            nuevo=adentroFila(nuevo, fEncontrada);
            nuevo=adentroColumna(nuevo, cEncontrada);
        }
        //FN CS
        else if(fEncontrada==null && cEncontrada!=null){
            fEncontrada=crearFila(j);
            nuevo = adentroFila(nuevo, fEncontrada);
            nuevo = adentroColumna(nuevo, cEncontrada);
        }
        //FS CS
        else if(fEncontrada != null && cEncontrada != null){
            nuevo = adentroFila(nuevo, fEncontrada);
            nuevo = adentroColumna(nuevo, cEncontrada);
        }
    }
    public Nodo<E> buscarColumna(int i){
        Nodo<E> aux=this.raiz;
        while(aux!=null){
            if (aux.i==i) return aux;
            aux=aux.sig;
        }
        return null;
    }
    
    public Nodo<E> buscarFila(int j) {
        Nodo<E> aux = this.raiz;
        while (aux != null) {
            if (aux.j == j)
                return aux;
            aux = aux.abj;
        }
        return null;
    }

    public Nodo<E> crearColumna(int i){
        return adentroFila(new Nodo<E>(i,-1,(E)"Col"),this.raiz);
    }
    public Nodo<E> adentroFila(Nodo<E> nuevo,Nodo<E> cFila){
        Nodo<E> aux=cFila;
        boolean mayor=false;
        while(true){
            if (aux.i>nuevo.i){
                mayor=true;
                break;
            }else if(aux.sig!=null){
                aux=aux.sig;
            }else{
                break;
            }
        }

        if(mayor){
            nuevo.sig=aux;
            nuevo.ant=aux.ant;
            aux.ant.sig=nuevo;
            aux.ant=nuevo;
        }else{
            aux.sig=nuevo;
            nuevo.ant=aux;
        }
        return nuevo;
    }

    public Nodo<E> crearFila(int j) {
        return adentroColumna(new Nodo<E>(-1, j, (E) "Row"), this.raiz);
    }
    
    public Nodo<E> adentroColumna(Nodo<E> nuevo, Nodo<E> cColumna) {
        Nodo<E> aux = cColumna;
        boolean mayor = false;
        while (true) {
            if (aux.j > nuevo.j) {
                mayor = true;
                break;
            } else if (aux.abj != null) {
                aux = aux.abj;
            } else {
                break;
            }
        }

        if (mayor) {
            nuevo.abj = aux;
            nuevo.arb = aux.arb;
            aux.arb.abj = nuevo;
            aux.arb = nuevo;
        } else {
            aux.abj = nuevo;
            nuevo.arb = aux;
        }
        return nuevo;
    }
}
