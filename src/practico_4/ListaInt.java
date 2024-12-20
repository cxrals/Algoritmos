package practico_4;

public class ListaInt implements IListaInt {
    private NodoInt inicio;
    private NodoInt fin;
    private int cantidadDeElementos;
    
    public ListaInt() {
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
        inicio = new NodoInt(dato, inicio);
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
            NodoInt nuevo = new NodoInt(dato);
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
        if (inicio != null) {
            NodoInt actual = inicio;

            // Si la lista tiene un solo elemento
            if (inicio.getSig() == null) {
                int dato = inicio.getDato();
                inicio = null;
                cantidadDeElementos--;
            } else {
                // Recorremos hasta el penúltimo nodo
                while (actual.getSig().getSig() != null) {
                    actual = actual.getSig();
                }

                int dato = actual.getSig().getDato();
                actual.setSig(null);
                cantidadDeElementos--;
            }
        }
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
    public NodoInt obtenerElemento(int dato) {
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
    public void mostrarREC(NodoInt nodo) {
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
