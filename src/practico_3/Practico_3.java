package practico_3;

public class Practico_3 {

    public static void main(String[] args) {
        mostrarAsc(5);
        mostrarDesc(5);
        
        System.out.println(ejercicio1(5));
        System.out.println(fibonacci(4));
        System.out.println(ejercicio3("Hola"));
        System.out.println(sumarDigitos(321));
        
    }

    //Muestra los números desde 1 hasta n
    public static void mostrarAsc(int n){
        if (n > 0) {
            mostrarAsc(n - 1);
        }
        System.out.println(n);
    } 
    
    //Muestra los números de n hasta 1
    public static void mostrarDesc(int n){
        if (n == 0) {
            System.out.println(0);
        } else {
            System.out.println(n);
            mostrarDesc(n - 1);

        }
    }
    
    // ============================== EJERCICIO 1 ==============================
    // Implementar una función recursiva que calcule el factorial de un número natural N.
    public static int ejercicio1(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return ejercicio1(n - 1) * n;
        }
        
    }
    
    // ============================== EJERCICIO 2 ==============================
    // Implementar un algoritmo que dado un número natural N, calcule el n‐ésimo 
    // número de Fibonacci.
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
        
    }
    
    // ============================== EJERCICIO 3 ==============================
    // Implementar un algoritmo recursivo que permita invertir una palabra.
    public static String ejercicio3(String palabra) {
        if(palabra.length() == 1) {
            return palabra;
        } else {
            System.out.print(palabra.charAt(palabra.length() - 1));
            return ejercicio3(palabra.substring(0, palabra.length() - 1));
        }
    }
    
    // ============================== EJERCICIO 4 ==============================
    // Implementar un algoritmo recursivo que permita sumar los dígitos de un número.
    // 321 % 10 = 1
    // 321 / 10 = 32
    // 32 % 10 = 2
    // 32 / 10 = 3
    public static int sumarDigitos(int numero) {
        if(numero == 0) {
            return 0;
        } else {
            return numero % 10 + sumarDigitos(numero/10);
        }
    }
    
    // ============================== EJERCICIO 5 ==============================
    // Implementar un algoritmo recursivo que permita sumar los elementos de un vector.
    
    public static int sumaVector(int[] v) {
        return sumaVector()
    }
}
