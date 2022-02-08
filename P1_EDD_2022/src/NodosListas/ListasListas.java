
package NodosListas;

public class ListasListas {
    NodoS lc;
    NodoS primero;
    int tamaño;
    public ListasListas(){
        lc=null;
    }

    public void insertarLc(Object info) {
        NodoS nuevo = new NodoS();
        nuevo.setSiguiente((NodoS)info);
        nuevo.setAnterior((NodoS)info);
        if (this.lc!=null){
            nuevo.sig=lc.sig;
            lc.sig=nuevo;
            nuevo.ant=lc;
            lc.sig.ant=nuevo;
        }
        lc=nuevo;
        tamaño+=1;
    }
    public void insertarZ(Object info,Object buscar){
        NodoS nuevo = new NodoS();
        nuevo.info=info;
        NodoS aux= new NodoS();
        aux=lc;
        int contador=0;
        while(buscar!=aux && contador<tamaño){//BUSCAR POR POSICOIN SIG, NO PASE DEL TAMAÑO
            aux=aux.sig;
            contador+=1;
        }
        //TODO: NOTA PUEDE HABER ERROR SI NO SE PONE BIEN
        if(primero==null){
            aux.pZ=nuevo;
        }else{
            while(aux.pZ!=null){
                aux=aux.pZ;
            }
            aux.pZ=nuevo;
        }
    }
}
