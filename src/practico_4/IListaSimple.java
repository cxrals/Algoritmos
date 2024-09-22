package practico_4;

public interface IListaSimple {
    boolean esVacia();
    void agregarInicio(int dato);
    void agregarFinal(int dato);
    void eliminarInicio();
    void eliminarFinal();
    void eliminarElemento(int dato);
    boolean existeElemento(int dato);
    Nodo obtenerElemento(int dato);
    void vaciar();
    void mostrar();
    int cantidadElementos();
    public void agregarOrd(int n);
    public void mostrarREC(Nodo nodo);
    public void mostrarRECinverso();
}
