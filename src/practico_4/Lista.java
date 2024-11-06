package practico_4;

public class Lista<T> implements ILista<T> {

    private Nodo inicio;
    private Nodo fin;
    private int cantidadDeElementos;
    
    @Override
    public void agregar(T dato) {
        if (this.esVacia()) {
            inicio = new Nodo<>(dato, inicio);
        } else {
            Nodo<T> aux = inicio;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            Nodo nuevo = new Nodo(dato);
            aux.setSiguiente(nuevo);
        }
        this.cantidadDeElementos++;
    }

    @Override
    public void eliminar(T dato) {
        if (inicio.getDato().equals(dato)) {
            inicio = inicio.getSiguiente();
        } else {
            Nodo<T> aux = inicio;
            while (!dato.equals(aux.getSiguiente().getDato())) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(aux.getSiguiente().getSiguiente());
        }
        cantidadDeElementos--;
    }
    
    @Override
    public T obtener(int indice) {
        Nodo<T> aux = inicio;
        int cont = 0;
        while(cont < indice){
            cont++;
            aux = aux.getSiguiente();
        }
        return aux.getDato();
    }

    @Override
    public T obtener(T dato) {
        Nodo<T> aux = inicio;
        while (aux != null) {
            if (aux.getDato().equals(dato)) {
                return aux.getDato();
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    @Override
    public int largo() {
        return cantidadDeElementos;
    }

    @Override
    public boolean esVacia() {
        return cantidadDeElementos == 0;
    }

    @Override
    public boolean existe(T dato) {
        Nodo<T> aux = inicio;
        while(aux != null) {
            if (aux.getDato().equals(dato)) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    
    
}
