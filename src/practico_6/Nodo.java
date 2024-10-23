package practico_6;

public class Nodo<T> {
    private T dato;
    private Nodo sig;

    public Nodo(T dato) {
        this.dato = dato;
        this.sig = null;
    }

    // crear nodo y puntero
    public Nodo(T dato, Nodo sig) {
        this.dato = dato;
        this.sig = sig;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return sig;
    }

    public void setSiguiente(Nodo sig) {
        this.sig = sig;
    }
}
