package practico_3;

public class Practico_3 {

    public static void main(String[] args) {
        mostrarAsc(5);
        mostrarDesc(5);
        
        int[] v = {1,2,3};
        
        System.out.println("ej1: " + ejercicio1(5));
        System.out.println("ej2: " + ejercicio2Fibonacci(4));
        System.out.println("ej2 v2: " + fibV2(4));
        System.out.println("ej3: " + ejercicio3("Hola"));
        System.out.println("ej4: " + ejercicio4SumarDigitos(321));
        System.out.println("ej5: " + ejercicio5SumaVector(v));
        System.out.println("ej6: " + ejercicio6MultiplicarVector(v));
        System.out.println("ej8 max: " + maximo(v));
        System.out.println("ej8 min: " + minimo(v));
        System.out.println("ej8 minV2: " + minimoRecV2(v));
        System.out.println("ej9 existe: " + existe(v, 2));
        System.out.println("ej9 existeV2: " + existeRecV2(v, 2));

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
    public static int ejercicio2Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return ejercicio2Fibonacci(n - 1) + ejercicio2Fibonacci(n - 2);
        
    }
    
    // version más eficiente
    private static long fibV2(int n) {
        long[] aux = new long[n + 1];
        return fibAux(n, aux);
    }
    
    private static long fibAux(int n, long[] aux) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (aux[n] == 0) {
            aux[n] = fibAux(n - 1, aux) + fibAux(n - 2, aux);
        }
        
        return aux[n];
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
    public static int ejercicio4SumarDigitos(int numero) {
        if(numero == 0) {
            return 0;
        } else {
            return numero % 10 + ejercicio4SumarDigitos(numero/10);
        }
    }
    
    // ============================== EJERCICIO 5 ==============================
    // Implementar un algoritmo recursivo que permita sumar los elementos de un vector.
    // 1
    // 2 + 1 = 3
    // 3 + 3 = 6
    // v[pos] + resultado de suma de v[pos - 1]
    public static int ejercicio5SumaVector(int []v) {
       return ejercicio5SumaVector(v, v.length - 1);
    }
    
    public static int ejercicio5SumaVector(int []v, int pos) {
        if (pos == 0) {
            return v[0];
        } else {
            return ejercicio5SumaVector(v, pos-1) + v[pos];
        }
    }
    
    /*
        ejercicio5SumaVector(v, 2) + 3
        ejercicio5SumaVector(v, 1) + 2
        ejercicio5SumaVector(v, 0)
    
        ejercicio5SumaVector(v, 0) = 1
        ejercicio5SumaVector(v, 1) + 2 = 1 + 2 = 3
        ejercicio5SumaVector(v, 2) + 3 = 3 + 3 = 6
    
    */
    
    // otra version
    public static int sumarVector(int[] datos) {
        return sumarVector(datos, 0, datos.length - 1);
    }
    
    private static int sumarVector(int[] datos, int desde, int hasta) {
        // casos base
        if (desde == hasta) {
            return datos[desde];
        }
        // llamadas recursivas (paso recursivo)
        int medio = (desde + hasta) / 2;
        int sumaIzq = sumarVector(datos, desde, medio);
        int sumaDer = sumarVector(datos, medio + 1, hasta);

        // unir los resultados
        return sumaDer + sumaIzq;
    }
    
    // version más eficiente
    private static int sumarVectorV2(int[] datos, int desde, int hasta) {
        if (desde == hasta) {
            return datos[desde];
        }
        int medio = (desde + hasta) / 2;
        return sumarVector(datos, desde, medio) + sumarVector(datos, medio + 1, hasta);
    }
    
    // ============================== EJERCICIO 6 ==============================
    // Implementar un algoritmo recursivo que permita multiplicar los elementos de un vector
    // 2 3 4
    // 2
    // 3 x 2 = 6
    // 4 x 6 = 24
    public static int ejercicio6MultiplicarVector(int[] datos) {
        return ejercicio6MultiplicarVector(datos, datos.length - 1);
    }
    
    public static int ejercicio6MultiplicarVector(int[] datos, int pos) {
        if (pos == 0) {
            return datos[0];
        } else {
            return ejercicio6MultiplicarVector(datos, pos - 1) * datos[pos];
        }
    }
    
    /*
        ejercicio6MultiplicarVector(v, 2) * 4
        ejercicio6MultiplicarVector(v, 1) * 3
        ejercicio6MultiplicarVector(v, 0)
    
        ejercicio6MultiplicarVector(v, 0) = 2
        ejercicio6MultiplicarVector(v, 1) * 3 = 2 * 3 = 6
        ejercicio6MultiplicarVector(v, 2) * 4 = 6 * 4 = 24
    */
    
    // ============================== EJERCICIO 8 ==============================
    // Dado un arreglo de números enteros:
        // a) Implementar una función recursiva que calcule el máximo valor del vector.
        public static int maximo(int[] datos) {
            return maximoRec(datos, 0);
        }
        
        private static int maximoRec(int[] datos, int pos) {
            if (pos == datos.length - 1) {
                return datos[pos];
            }
            return Math.max(datos[pos], maximoRec(datos, pos + 1));
        }
        
        // b) Implementar una función recursiva que calcule el mínimo valor del vector.
        public static int minimo(int[] datos) {
            return minimoRec(datos, 0);
        }

        private static int minimoRec(int[] datos, int pos) {
            int min;
            if (pos == datos.length - 1) {
                min = datos[pos];
            } else {
                int a = datos[pos];
                int b = minimoRec(datos, pos + 1);
                if (a < b) {
                    min = a;
                } else {
                    min = b;
                }
            }
            return min;
        }
        
        public static int minimoRecV2(int[] datos) {
            return minimoRecV2(datos, 0);
        }

        private static int minimoRecV2(int[] datos, int pos) {
            if (pos == datos.length - 1) {
                return datos[pos];
            }
            return Math.min(datos[pos], minimoRec(datos, pos + 1));
        }
    // ============================== EJERCICIO 9 ==============================
    // Dado un arreglo de números enteros, implementar una función recursiva que indique si se
    // encuentra determinado número en un vector.
        // a) Implementar una solución para un vector desordenado.
        // b) Implementar una solución para un vector ordenado
    public static boolean existe(int[] datos, int dato) {
        return existeRec(datos, dato, 0, datos.length - 1);
    }

    public static boolean existeRec(int[] datos, int dato, int desde, int hasta) {
        // casos base
        if (desde == hasta) {
            return datos[desde] == dato;
        }
        // llamadas recursivas (paso recursivo)
        int medio = (desde + hasta) / 2;
        boolean existeIzq = existeRec(datos, dato, desde, medio);
        boolean existeDer = existeRec(datos, dato, medio + 1, hasta);

        // unir los resultados
        return existeIzq || existeDer;
    }

    // version más eficiente
    public static boolean existeRecV2(int[] datos, int dato) {
        return existeRecV2(datos, dato, 0, datos.length - 1);
    }
    
    public static boolean existeRecV2(int[] datos, int dato, int desde, int hasta) {
        // casos base
        if (desde == hasta) {
            return datos[desde] == dato;
        }
        int medio = (desde + hasta) / 2;
        return existeRec(datos, dato, desde, medio) || existeRec(datos, dato, medio + 1, hasta);
    }
        

}
