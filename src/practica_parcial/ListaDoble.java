package practica_parcial;
import practico_5.NodoDoble;

public class ListaDoble {
    private NodoDoble inicio;
    private NodoDoble fin;
    private int cantidad;

    public NodoDoble getInicio() {
        return inicio;
    }

    public void setInicio(NodoDoble inicio) {
        this.inicio = inicio;
    }

    public NodoDoble getFin() {
        return fin;
    }

    public void setFin(NodoDoble fin) {
        this.fin = fin;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    //==========================================================================================
    // Examen 2024-05-10
    //==========================================================================================
    /*
    Dado una implementación de TAD Lista doblemente encadenada - desordenada - de nodos,
    con puntero al primero (inicio) y puntero al último (fin), realizar - dentro del TAD - una
    operación que me permita eliminar el último elemento de la lista. Se deberán contemplar
    todos los casos de borde e implementar todas las operaciones - adicionales - del TAD que
    sean necesarias la operación requerida.
    */
    
    public void eliminarFinal(){
        if (this.getInicio() != null) {
            if (this.getInicio() == this.getFin()) {
                inicio = null;
                fin = null;
            } else {
                NodoDoble aBorrar = fin;
                fin = aBorrar.getAnterior();
                aBorrar.setAnterior(null);
                fin.setSiguiente(null);
            }
        }
    }
    
}
