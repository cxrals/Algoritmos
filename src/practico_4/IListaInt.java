package practico_4;

public interface IListaInt {
    boolean esVacia();
    void agregarInicio(int dato);
    void agregarFinal(int dato);
    void eliminarInicio();
    void eliminarFinal();
    void eliminarElemento(int dato);
    boolean existeElemento(int dato);
    NodoInt obtenerElemento(int dato);
    void vaciar();
    void mostrar();
    int cantidadElementos();
    public void agregarOrd(int n);
    public void mostrarREC(NodoInt nodo);
    public void mostrarRECinverso();
}
