package practico_4;

public class ListaSimple implements IListaSimple {
    private Nodo inicio;
    private Nodo fin;
    private int cantidadDeElementos;
    
    public ListaSimple() {
        this.inicio = null;
        this.fin = null;
        this.cantidadDeElementos = 0;
    }
    
    @Override
    public boolean esVacia() {
        return this.inicio == null;
    }

    @Override
    public void agregarInicio(int dato) {
        inicio = new Nodo(dato, inicio);
        this.cantidadDeElementos++;
        if (this.fin == null) {
            this.fin = inicio;
        }
    }

    @Override
    public void agregarFinal(int dato) {
        if (this.esVacia()) {
            agregarInicio(dato);
        } else {
            Nodo nuevo = new Nodo(dato);
            this.fin.setSig(nuevo);
            this.fin = nuevo;
            this.cantidadDeElementos++;
        }
    }

    @Override
    public void eliminarInicio() {
        int dato = this.inicio.getDato();
        this.inicio = inicio.getSig();
        this.cantidadDeElementos--;
    }

    @Override
    public void eliminarFinal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarElemento(int dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existeElemento(int dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Nodo obtenerElemento(int dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void vaciar() {
        this.inicio = null;
    }

    @Override
    public void mostrar() {
        mostrarREC(this.inicio);
        System.out.println("");
    }

    @Override
    public int cantidadElementos() {
        return this.cantidadDeElementos;
    }

    @Override
    public void agregarOrd(int n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarREC(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " ");
            mostrarREC(nodo.getSig());
        }
    }

    @Override
    public void mostrarRECinverso() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
