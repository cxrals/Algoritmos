package practico_1;
import java.util.Scanner;

public class Practico_1 {
    
    public static void main(String[] args) {
        // TODO code application logic here
        ejercicio1();
        ejercicio2(1,10);
        ejercicio3(100);
        ejercicio4(1,5);
        ejercicio5(2,2,1);
        ejercicio6();
        ejercicio7();
    }
    
    //****** EJERCICIO 1 ******
    public static void ejercicio1() {
        int suma = 0;
        
        for (int i = 1; i <= 50; i += 2) {
            suma += i;
        }
        
        System.out.println(suma);
    }
    
    //****** EJERCICIO 2 ******
    public static void ejercicio2(int num1, int num2) {
        System.out.println("El promedio es: " + (num1 + num2) / 2.0);

        int cantidadDePares = 0;
        
        for (int i = num1; i <= num2; i++) {
            if (i % 2 == 0) {
                cantidadDePares++;
            }
        }
        
        System.out.println("Cantidad de numeros pares: " + cantidadDePares);
        System.out.println("Suma de absolutos: " + (Math.abs(num1) + Math.abs(num2)));
    }
    
    //****** EJERCICIO 3 ******
    public static void ejercicio3(int num1) {
        String numComoString = num1 + "";
        String res = "";
        
        for (int i = 0; i < numComoString.length(); i++) {
            System.out.println(numComoString.charAt(i));
            res += numComoString.charAt(i) + " ";
        }
	
        System.out.println(res);
    }
    
    //****** EJERCICIO 4 ******
    public static void ejercicio4(int num1, int num2) {
        int max = num2;
        int min = num1;
        
        if (min > max) {
            max = num1;
            min = num2;
        }

        System.out.println("Max: " + max);
        
        int suma = 0;
        
        for (int i = min; i <= max; i++) {
            suma += i;
        }

        System.out.println("suma: " + suma);
    }
    
    //****** EJERCICIO 5 ******
    public static void ejercicio5(int a, int b, int c) {
        Triangulo t = new Triangulo(a,b,c);
        System.out.println("Es equilatero: " + t.esEquilatero());
        System.out.println("Es escaleno: " + t.esEscaleno());
        System.out.println("Es Isosceles: " + t.esIsosceles());
    }
    
    //****** EJERCICIO 6 ******
    public static void ejercicio6() {
        Socio s = new Socio("Ana");
        System.out.println(s);
    }
    
    //****** EJERCICIO 7 ******
    public static void ejercicio7() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar nombre");
        String nombre = scanner.next();
        System.out.println("Ingresar sueldo");
        Double sueldo = scanner.nextDouble();
        
        Funcionario f = new Funcionario(nombre, sueldo);
        System.out.println(f);
    
    }
    
}
