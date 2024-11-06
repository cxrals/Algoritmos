package practico_4;

public class NodoInt<T> {
    private int dato;
    private NodoInt sig;

    public NodoInt(int dato) {
        this.dato = dato;
        this.sig = null;
    }

    // crear nodo y puntero
    public NodoInt(int dato, NodoInt sig) {
        this.dato = dato;
        this.sig = sig;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoInt getSig() {
        return sig;
    }

    public void setSig(NodoInt sig) {
        this.sig = sig;
    }
}
