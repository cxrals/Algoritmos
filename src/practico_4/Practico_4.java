package practico_4;

public class Practico_4 {
    public static void main(String[] args) {
        ListaInt lista = new ListaInt();
        
        lista.agregarInicio(3);
        lista.agregarInicio(5);
        lista.agregarInicio(2);
        
        lista.mostrar();
        
        lista.eliminarFinal();
        
        lista.mostrar();
        
        System.out.println("cantidadElementos: " + lista.cantidadElementos());
    }
    
}
