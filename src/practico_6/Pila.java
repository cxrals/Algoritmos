package practico_6;

public class Pila<T> implements IPila<T> {

    private Nodo<T> inicio;
    
    @Override
    public void push(T dato) {
        inicio = new Nodo<T>(dato, inicio);
        
        //Nodo<T> nuevo = new Nodo<T>(dato);
        //nuevo.setSiguiente(inicio);
        //inicio = nuevo;
    }

    @Override
    public T pop() {
        T aux = inicio.getDato();
        inicio = inicio.getSiguiente();
        return aux;
    }

    @Override
    public T top() {
        return inicio.getDato();
    }

    @Override
    public boolean esVacia() {
        return inicio == null;
    }

    @Override
    public int cantElementos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void vaciar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
