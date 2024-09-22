package practico_4;

public class Practico_4 {
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();
        
        lista.agregarInicio(3);
        lista.agregarInicio(5);
        lista.agregarInicio(2);
        
        lista.mostrar();
        
        System.out.println("cantidadElementos: " + lista.cantidadElementos());
    }
    
}
