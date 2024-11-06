package practico_5;

public interface IListaDoble<T> {
    public boolean esVacia();
    public void agregarInicio(int dato);
    public void agregarFinal(int dato);
    public void agregarOrd(int n);
    public void borrarInicio();
    public void borrarFin();
    public void borrarElemento(int n);
    public boolean buscarelemento(int dato);
    public NodoDoble obtenerElemento(int n);
    public void vaciar();
    public void mostrar();
    public void mostrarREC(NodoDoble l); // recursivo
    public int cantElementos();
}
