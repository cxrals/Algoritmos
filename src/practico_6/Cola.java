package practico_6;

public class Cola<T> implements ICola<T> {
    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int cantidadDeElementos;

    @Override
    public void enqueue(T dato) {
        if (this.esVacia()) {
            inicio = new Nodo<>(dato, fin);
            if (this.fin == null) {
                this.fin = inicio;
            }
        } else {
            Nodo<T> nuevo = new Nodo<T>(dato);
            this.fin.setSiguiente(nuevo);
            this.fin = nuevo;
            this.cantidadDeElementos++;
        }
    }

    @Override
    public T dequeue() {
        T dato = this.inicio.getDato();
        this.inicio = inicio.getSiguiente();
        this.cantidadDeElementos--;
        return dato;
    }

    @Override
    public T front() {
        return this.inicio.getDato();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void vaciar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int cantidadNodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean esVacia() {
        return inicio == null; 
    }
    
}
