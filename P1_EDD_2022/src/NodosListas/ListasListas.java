
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
        nuevo.info = info;
        nuevo.setSiguiente(nuevo);
        nuevo.setAnterior(nuevo);
        if (this.lc!=null){
            nuevo.ant=lc;
            lc.sig.ant=nuevo;
            nuevo.sig=lc.sig;
            lc.sig=nuevo;           
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

    public void ver(){
        int contador=0;
        NodoS aux= new NodoS();
        aux=lc;
        while(contador<tamaño){
            System.out.println("SIG: "+aux.info);
            aux=aux.sig;
            contador+=1;
        }
        contador = 0;
        while (contador < tamaño) {
            System.out.println("ANT: " + aux.info);
            aux = aux.ant;
            contador+=1;
        }
    }

    public void popId(int id){
        int contador = 0;
        NodoS aux = new NodoS();
        aux = lc;
        while(contador<id){
            aux = aux.ant;
            contador += 1;
        }
        aux.ant.sig=aux.sig;
        aux.sig.ant=aux.ant;
        if(aux==lc){
            lc=lc.sig;
        }
        aux=null;
        tamaño--;
    }
}
