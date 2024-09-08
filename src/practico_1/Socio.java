package practico_1;

public class Socio {
    private String nombre;
    private int numero;
    private static int ProximoNumero = 0;
    
    public Socio(){
    }
    
    public Socio(String nombre){
        this.nombre = nombre;
        this.numero = ProximoNumero++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public static int getProximoNumero() {
        return ProximoNumero;
    }

    public static void setProximoNumero(int ProximoNumero) {
        Socio.ProximoNumero = ProximoNumero;
    }
    
    public String toString(){
        return "Nombre: " + this.nombre + " " + "Numero: " + this.numero + " Proximo: " + this.ProximoNumero;
    }
}
