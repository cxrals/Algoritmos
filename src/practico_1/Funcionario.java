package practico_1;

public class Funcionario {
    private String nombre;
    private Double sueldo;
    
    public Funcionario(){
        
    }
    
    public Funcionario(String nombre, Double sueldo){
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nombre=" + nombre + ", sueldo=" + sueldo + '}';
    }
    
    
}
