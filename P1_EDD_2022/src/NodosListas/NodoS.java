
package NodosListas;

public class NodoS {
        Object info;
        NodoS sig;//+X
        NodoS ant;//-X
        NodoS pZ;//+ Z
        public void setSiguiente(NodoS sig){
            this.sig=this;
        } 
        public void setAnterior(NodoS sig) {
                this.sig = this;
        }
}
