
package practico_2;
import java.util.Arrays;

public class Practico_2 {
    public static void main(String[] args) {
        int[] v ={6,3,5,1,8,7,2,4};
        int[] vOrdenado ={1,2,3,4,5,6,7,8};
        
        ejercicio1(v);        
        ejercicio2(v);
        ejercicio3Impares(v);
        ejercicio3Pares(v);
        ejercicio4Impares(v);
        ejercicio4Pares(v);
        ejercicio5ArrayDesordenado(v);
        ejercicio5ArrayOrdenado(vOrdenado);
        ejercicio6ArrayDesordenado(v);
        ejercicio6ArrayOrdenado(vOrdenado);
        
        int[] a ={1,3,6};
        int[] b ={2,4,5,10,11,12,12,13};
        int[] resultado = ejercicio11(a,b);
        System.out.println(Arrays.toString(resultado));

    }
    
    // ============================== EJERCICIO 1 ==============================
    
    public static void ejercicio1(int[] v) {
        String resultado = "";
        for (int i = 0; i < v.length; i++) {
            if (i == v.length - 1) {
                resultado += v[i] + "";
            } else {
                resultado += v[i] + " - ";
            }
        }
        System.out.println(resultado);
    }
    
    // ============================== EJERCICIO 2 ==============================
    // Implementar un algoritmo que retorne el promedio de los valores contenidos 
    // en un array
    
    public static void ejercicio2(int[] v) {
        double promedio = 0;
        
        for (int i = 0; i < v.length; i++) {
            promedio += Double.valueOf(v[i]);
        }
        
        System.out.println(promedio / v.length);
    }
    
    // ============================== EJERCICIO 3 ==============================
    // Implementar un algoritmo que muestre los valores impares del array y otro 
    // que muestre los valores pares del array
    
    public static void ejercicio3Impares(int[] v) {
        String impares = "";
        for (int i = 0; i < v.length; i++) {
            if (v[i] % 2 != 0) {
                impares += v[i] + " - ";
            }
        }

        System.out.println(impares.substring(0, impares.length() - 2));
    }
    
    public static void ejercicio3Pares(int[] v) {
        String pares = "";
        for (int i = 0; i < v.length; i++) {
            if (v[i] % 2 != 0) {
                pares += v[i] + " - ";
            }
        }

        System.out.println(pares.substring(0, pares.length() - 2));
    }

    // ============================== EJERCICIO 4 ==============================
    // Implementar un algoritmo que muestre los valores que se encuentran en las
    // posiciones impares del array y otro que muestre los valores que se encuentren 
    // en las posiciones pares del array
    
    public static void ejercicio4Impares(int[] v) {
        String posicionesImpares = "";
        
        for (int i = 1; i < v.length; i = i + 2) {
            posicionesImpares += v[i] + " ";
        }
        
        System.out.println(posicionesImpares);
    }
    
    public static void ejercicio4Pares(int[] v) {
        String posicionesPares = "";
        for (int i = 0; i < v.length; i = i + 2) {
            posicionesPares += v[i] + " ";
        }
        System.out.println(posicionesPares);
    }

    // ============================== EJERCICIO 5 ==============================
    // Implementar un algoritmo que retorne el valor máximo del array.
    // PRE: se asume que el array no está vacío y no esta ordenado
    public static void ejercicio5ArrayDesordenado(int[] v) {
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < v.length; i++) {
            if (v[i] > maxValue) {
                maxValue = v[i];
            }
        }
        
        System.out.println(maxValue);
    }
    
    // PRE: se asume que el array no está vacío y esta ordenado ascendentemente
    public static void ejercicio5ArrayOrdenado(int[] v) {
        System.out.println(v[v.length - 1]);
    }
    
    // ============================== EJERCICIO 6 ==============================
    // Implementar un algoritmo que retorne el valor mínimo del array.
    // PRE: se asume que el array no está vacío y no esta ordenado
    public static void ejercicio6ArrayDesordenado(int[] v) {
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < v.length; i++) {
            if (v[i] < minValue) {
                minValue = v[i];
            }
        }

        System.out.println(minValue);
    }
    
    // PRE: se asume que el array no está vacío y esta ordenado ascendentemente
    public static void ejercicio6ArrayOrdenado(int[] v) {
        System.out.println(v[0]);
    }
    
    // ============================== EJERCICIO 7 ==============================
    // Implementar los métodos del ejercicio anterior, agregando 2 parámetros que 
    // representan desde donde recorremos el array y hasta donde lo hacemos.
    

    // ============================== EJERCICIO 8 ==============================
    // Implementar los métodos del ejercicio anterior, retornando en este caso la posición donde se
    // encuentra el valor máximo o el valor mínimo.
    

    // ============================== EJERCICIO 9 ==============================
    // Implementar un algoritmo que reciba el vector v y un elemento que debe buscar.
    // Considerar 2 casos:
    //      - Retornar un valor booleano que indique si el elemento se encuentra o no en el array
    //      - Retornar la posición del array donde se encuentra el elemento buscado 
    //      y en caso de que no se encuentre, retornar -1.
    
    
    //============================== EJERCICIO 10 ==============================
    // Implemente un algoritmo que retorne un booleano indicando si se encuentra un elemento o
    // no, en un vector ordenado.
    public static boolean busquedaBinaria(int[] vector, int elem) {
        int cantidadDeIteraciones = 0;
        int desde = 0;
        int hasta = vector.length -1;
        int medio;
        while(desde <= hasta){
            cantidadDeIteraciones++;
            medio = (desde+hasta)/2;
            if(vector[medio] == elem){
                System.out.println("cantidadDeIteraciones = " + cantidadDeIteraciones);
                return true;
            }else if(vector[medio] < elem){
                desde = medio+1;
            }else{ //vector[medio] > elem
                hasta = medio-1;
            }
        
        }
        
        System.out.println("cantidadDeIteraciones = " + cantidadDeIteraciones);
        return false;
    }
    
    // ============================= EJERCICIO 11 ==============================
    // Dados dos vectores ordenados v1 y v2 de dimensiones n1 y n2 respectivamente escribir una función
    // que genere un tercer vector v3, también ordenado, que contenga los elementos de los dos
    // anteriores.
    
    public static int[] ejercicio11(int[] v1, int[] v2) {
        int length1 = v1.length;
        int length2 = v2.length;
        
        // crear array resultante con suma de cantidad de elementos
        int[] resultado = new int[length1 + length2];
        
        int i = 0;
        int j = 0;
        int k = 0; // contador para resultado
        
        while(i < length1 && j < length2) {
            // popular nuevo array con el menor
            if(v1[i] < v2[j]) {
                resultado[k] = v1[i];
                i++;
            } else {
                resultado[k] = v2[j];
                j++;
            }
            
            k++;
        }
        
        
        return resultado;
    }

}