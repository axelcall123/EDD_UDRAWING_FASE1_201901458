
package NodosListas;

public class ListasListas {
    NodoS lc;
    NodoS primero;
    int tamañoLc;
    public ListasListas(){
        lc=null;
    }

    public int lengthLc(){
        return tamañoLc;
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
        tamañoLc+=1;
    }

    public void insertarZ(Object info,int buscar){
        NodoS nuevo = new NodoS();
        nuevo.info=info;
        NodoS aux= new NodoS();
        aux=lc;
        int contador=0;
        while(buscar>contador /*&& contador<tamañoLc*/){//BUSCAR POR POSICOIN SIG, NO PASE DEL TAMAÑO
            aux=aux.sig;
            contador+=1;
        }
        //FIXME: NOTA PUEDE HABER ERROR SI NO SE PONE BIEN
        if(tamañoLc!=0){
            if (primero == null) {
                aux.pZ = nuevo;
                primero=nuevo;
            } else {
                while (aux.pZ != null) {
                    aux = aux.pZ;
                }
                aux.pZ = nuevo;
            }
        }
        
    }

    public void elimnarNodo(int id){//FIXME: nodo
        int contador = 0;
        NodoS aux = new NodoS();
        aux = lc;
        while(contador<id){
            aux = aux.sig;
            contador += 1;
        }
        if (aux == lc) {
            lc = lc.sig;
        }
        aux.ant.sig=aux.sig;
        aux.sig.ant=aux.ant;      
        if(tamañoLc==1){//EVITAR ERRORES
            lc=null;
        }    
        aux=null;//ELIMINAR EL NODO ENMEDIO
        tamañoLc+=-1;
    }

    public Object verPosicionLc(int posicion){
        NodoS aux = new NodoS();
        aux = lc;
        int contador = 0;
        while (contador < posicion /*&& contador <= tamañoLc*/) {
            aux = aux.sig;
            contador += 1;
        }
        return aux.info;
    }

    public int cantNodosInsertZ(int posicion){//
        NodoS aux = new NodoS();
        aux = lc;
        int tamaño=0;
        for (int i=0;i<posicion;i++) {// BUSCAR
            aux = aux.sig;
        }
        while(aux.pZ!= null){
            aux = aux.pZ;
            tamaño++;
        }
        return tamaño;
    }

    public void sustituirIdLc(int posicion, Object info) {// BUSCA Y SUSTITUYE AL MISMO TIEMPO
        NodoS aux = new NodoS();
        aux = lc;
        int contador = 0;
        while (contador < posicion) {// VEO LA POSICION
            aux = aux.sig;
            contador += 1;
        }
        aux.info = info;// LE TRASLADO NUEVA INFORMACION
    }

    public Object verPosicionZ(int pLc,int pZ){//RETORNA IMAGENES
        NodoS aux = new NodoS();
        aux = lc;
        for (int i = 0; i < pLc; i++) {// BUSCAR
            aux = aux.sig;
        }//NEW
        for (int i = 0; i < pZ+1; i++) {//EVITAR EL PRIMER TRASLADO STRING[]
            aux = aux.pZ;
        }
        //OLD
        /*while (aux.pZ != null) {
            aux = aux.pZ;
        }*/
        return aux.info;
    }
    /*NO SIRVE SOL TEST */
    public void verLcSigAnt(){
        int contador = 0;
        NodoS aux = new NodoS();
        aux = lc;
        while (contador < tamañoLc) {
            System.out.println("SIG: " + aux.info);
            aux = aux.sig;
            contador += 1;
        }
        contador = 0;
        while (contador < tamañoLc) {
            System.out.println("ANT: " + aux.info);
            aux = aux.ant;
            contador += 1;
        }
    }

    public void verAll(){
        int contador = 0;
        NodoS aux1 = new NodoS();
        NodoS aux2 = new NodoS();
        aux1 = lc;
        while (contador < tamañoLc+1) {
            System.out.println("SIG: " + aux1.info);
            aux2=aux1;
            while (aux2.pZ != null) {
                aux2 = aux2.pZ;
                System.out.println("-->"+aux2.info);
            }
            aux1 = aux1.sig;
            contador += 1;
        }
        contador = 0;
        aux1 = lc;
        while (contador < tamañoLc+1) {
            System.out.println("ANT: " + aux1.info);
            aux2=aux1;
            while (aux2.pZ != null) {
                aux2 = aux2.pZ;
                System.out.println("-->"+aux2.info);
            }
            aux1 = aux1.ant;
            contador += 1;
        }
    }
}
