package practico_6;

public interface IPila<T> {
    void push(T dato);
    T pop();
    T top();
    boolean esVacia();
    int cantElementos();
    public void vaciar ();
}
