
package practica_parcial;

import practico_4.NodoInt;
import practico_6.Pila;

public class Parcial091224 {
    private static NodoInt inicio;
   
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    /*
    Ejercicio 1 (10 pts)
    a) Desarrollar un algoritmo que reciba una matriz cuadrada de enteros y retorne 
    el menor valor de la diagonal principal de la matriz. (4 puntos)
    b) Desarrollar un algoritmo que reciba una matriz de enteros y retorne un boolean 
    indicando si existe en la matriz al menos una columna donde haya al menos dos números repetidos consecutivos. (6 puntos)
    Ejemplo de matriz de 5 x 5 (columna 2 cumple con la condición):
    10   1   34   34   22  
    34   5    7    7    7  
    45   8   45    3    4  
    45   8   45    4    0  
    44  66   66    66   8  
    */
    public static int menorValorDiagonal(int[][] matriz) {
        int menor = matriz[0][0]; // Inicializamos con el primer elemento de la diagonal
        for (int i = 1; i < matriz.length; i++) {
            if (matriz[i][i] < menor) {
                menor = matriz[i][i];
            }
        }
        return menor;
    }

    public static boolean columnaConRepetidosConsecutivos(int[][] matriz) {
        for (int j = 0; j < matriz[0].length; j++) {
            for (int i = 0; i < matriz.length - 1; i++) {
                if (matriz[i][j] == matriz[i + 1][j]) {
                    return true; 
                }
            }
        }
        return false; 
    }

    /*
    Ejercicio 2 (8 pts)
    A continuación, se detalla una versión con errores del algoritmo bubble sort 
    utilizado para ordenar el siguiente vector en forma ascendente: [34, 11, 5, 1, 3, 90]
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i <= arr.length; i++) {  
            for (int j = 0; j <= arr.length - i; j++) {  
                if (arr[j] < arr[j + 1]) {  
                    // Intercambio  
                    int temp = arr[j];  
                    arr[j] = arr[j + 1];  
                    arr[j + 1] = arr[j];  
                }  
            }  
        }  
    }
    
    a) Escribir el algoritmo con los errores solucionados. (4 puntos)
    b) Tomando en cuenta el array inicial y el algoritmo corregido, indicar cómo quedaría 
    el vector en las sucesivas pasadas (estado del vector luego de cada iteración). (4 puntos)
    
    Iteración 1:  [11, 5, 1, 3, 34, 90]
    Iteración 2:  [5, 1, 3, 11, 34, 90]
    Iteración 3: [1, 3, 5, 11, 34, 90]
    Iteración 4: [1, 3, 5, 11, 34, 90] (sin cambios, ya está ordenado).
    Iteración 5: [1, 3, 5, 11, 34, 90] (sin cambios).
    */
    
    /*
    Ejercicio 3 (12 pts)
    Dado una lista simplemente enlazada de nodos con valores enteros y un valor N:
    a) Implemente un algoritmo recursivo que, dado un número N, muestre por pantalla 
    todos aquellos números que sean menores a N. El último número de la lista que cumpla 
    dicha condición es el que se deberá mostrar primero. (10 puntos)
    b) Realice el diagrama de llamadas para el ejemplo dado. (2 puntos)
    Ejemplo:
        Lista: 7 -> 8 -> 2 -> 32 -> 23 -> 5  
        Para un valor N = 8 debería mostrar en orden:  
        5  
        2  
        7  
    */
    
    public void imprimirMenoresAN(NodoInt nodo, int N) {
        if (nodo == null) {
            return; // Caso base: lista vacía o fin de la lista
        }

        // Llamada recursiva al siguiente nodo
        imprimirMenoresAN(nodo.getSig(), N);

        // Imprimir solo si el valor del nodo actual es menor a N
        if (nodo.getDato() < N) {
            System.out.println(nodo.getDato());
        }
    }
    
    /*
    Llamada inicial: imprimirMenoresAN(7)
    Llama a imprimirMenoresAN(8)
    Llamada: imprimirMenoresAN(8)
    Llama a imprimirMenoresAN(2)
    Llamada: imprimirMenoresAN(2)
    Llama a imprimirMenoresAN(32)
    Llamada: imprimirMenoresAN(32)
    Llama a imprimirMenoresAN(23)
    Llamada: imprimirMenoresAN(23)
    Llama a imprimirMenoresAN(5)
    Llamada: imprimirMenoresAN(5)
    Llama a imprimirMenoresAN(null)
    Caso base: imprimirMenoresAN(null) retorna.
    Flujo de impresión al retornar
    Al volver de la llamada imprimirMenoresAN(5), imprime 5 (porque 5 < 8).
    Al volver de la llamada imprimirMenoresAN(23), no imprime nada (porque 23 >= 8).
    Al volver de la llamada imprimirMenoresAN(32), no imprime nada (porque 32 >= 8).
    Al volver de la llamada imprimirMenoresAN(2), imprime 2 (porque 2 < 8).
    Al volver de la llamada imprimirMenoresAN(8), no imprime nada (porque 8 >= 8).
    Al volver de la llamada imprimirMenoresAN(7), imprime 7 (porque 7 < 8).
    */
    
    /*
    Ejercicio 4 (15 pts)
    Dada una implementación de un TAD Lista con nodos simplemente enlazados con puntero al inicio como se muestra a continuación:
        Lista: 4 -> 50 -> 7 -> 23 -> 30 -> 39  
    a) Implemente una nueva operación en el TAD que dada una posición, elimine el 
    nodo de dicha posición de la lista (pre pos >= 0 y < largo de la lista). (7 puntos)
    Firma: public void eliminar(int pos)
    Ej: Para la lista dada y pos = 2, quedaría la lista:
    4 -> 50 -> 23 -> 30 -> 39
    b) Implemente una nueva operación en el TAD que retorne una pila con los elementos 
    de la lista que sean pares. La pila debe ser cargada de forma que el primer número 
    de la lista que cumpla con la condición quede al tope de la pila. (8 puntos)
    Firma: public Pila listaAPila()
    Ejemplo de retorno para lista dada:
    Pila resultante:
        4  
        50  
        30
    */
    public void eliminar(int pos) {

        if (pos == 0) {
            // Eliminar el primer nodo
            inicio = inicio.getSig();
            return;
        }

        NodoInt actual = inicio;
        int i = 0;

        // Avanzar hasta el nodo anterior a la posición deseada
        while (i < pos - 1 && actual.getSig() != null) {
            actual = actual.getSig();
            i++;
        }

        if (actual.getSig() == null) {
            // Posición fuera de rango
            return;
        }

        // Eliminar el nodo en la posición dada
        actual.setSig(actual.getSig().getSig());
    }

    
    // Método listaAPila
    public Pila listaAPila() {
        Pila pila = new Pila();
        Pila pilaAuxiliar = new Pila(); // Pila auxiliar para invertir el orden

        NodoInt actual = inicio;
        while (actual != null) {
            if (actual.getDato() % 2 == 0) {
                pilaAuxiliar.push(actual.getDato());
            }
            actual = actual.getSig();
        }

        // Invertir el contenido de la pila auxiliar a la pila final
        while (!pilaAuxiliar.esVacia()) {
            pila.push(pilaAuxiliar.pop());
        }

        return pila;
    }
}
