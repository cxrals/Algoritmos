package practico_6;

public interface ICola<T> {
    void enqueue(T dato);
    T dequeue();
    T front();
    boolean isEmpty();
    void vaciar();
    int cantidadNodos();
    boolean esVacia();
}
