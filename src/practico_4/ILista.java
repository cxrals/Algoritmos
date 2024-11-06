package practico_4;

public interface ILista<T> {
    public void agregar(T dato);
    public void eliminar(T dato);
    public T obtener(int indice);
    public T obtener(T dato);
    public int largo();
    public boolean esVacia();
    public boolean existe(T dato);
    
    
}
