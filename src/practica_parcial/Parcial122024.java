
package practica_parcial;

import practico_4.NodoInt;
import practico_6.Cola;
import practico_6.Pila;


public class Parcial122024 {
    private static NodoInt inicio;
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    /*
    a) Desarrollar un algoritmo que reciba la matriz de enteros, una columna y un valor e indique
    mediante un valor boolean si se encuentra dicho valor en la columna indicada de la matriz
    b) Desarrollar un algoritmo que verifique si existe en la matriz alguna fila donde se encuentren 3
    numeros consecutivos iguales
    Ejemplo de matrix de 6x5 tanto en fila 1 como en fila 4 se cumple la condicion
    10  1   34  34  22
    34  5   7   7   7
    6   5   45  3   4
    45  8   45  45  0
    44  66  66  66  8
    78  9   0   32  11
    c) Desarrollar un algoritmo que reciba la matriz de enteros, una fila y un valor e indique
    mediante un valor boolean si se encuentra dicho valor en la fila indicada de la matriz
    */
    public static boolean buscarEnColumna(int[][] matriz, int columna, int valor) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][columna] == valor) {
                return true; 
            }
        }

        return false; 
    }
    
    public static boolean buscarEnFila(int[][] matriz, int fila, int valor) {

        for (int j = 0; j < matriz[fila].length; j++) {
            if (matriz[fila][j] == valor) {
                return true; 
            }
        }

        return false;
    }
    
    public static boolean existeFilaConTresConsecutivos(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            // Recorrer las columnas de la fila y buscar 3 números consecutivos iguales
            for (int j = 0; j < matriz[i].length - 2; j++) {
                if (matriz[i][j] == matriz[i][j + 1] && matriz[i][j + 1] == matriz[i][j + 2]) {
                    return true; 
                }
            }
        }

        return false;
    }
    
    public static boolean existeColumnaConTresConsecutivos(int[][] matriz) {
        for (int j = 0; j < matriz[0].length; j++) {
            // Recorrer las filas de la columna y buscar 3 números consecutivos iguales
            for (int i = 0; i < matriz.length - 2; i++) {
                if (matriz[i][j] == matriz[i + 1][j] && matriz[i + 1][j] == matriz[i + 2][j]) {
                    return true; 
                }
            }
        }

        return false; 
    }
    /*
    A continuacion se detalla una version con errores del algoritmo insert sort utilizado para ordenar el siguiente
    vector en forma ascentente [34, 11, 5, 1, 3, 90]
    public static void insertSort(int[] arr){
        
    */
    
    /*
    Dado una lista simplemente enlazada de nodos con valores enteros y un valor N
    a) Implemente un algoritmo recursivo que retorne la suma de los valores de la lista que sean mayores a N
    Lista: 1 -> 8 -> 2 -> 32 -> 23 -> 10
    Ejemplo: para un valor N=10 deberia retornar 55
    b) Realice el diagrama de llamadas para el ejemplo dado
    */
    public int sumarMayoresA(NodoInt nodo, int n) {
        // Caso base: si el nodo es nulo, no hay más elementos que procesar
        if (nodo == null) {
            return 0;
        }

        // Caso recursivo: si el valor del nodo es mayor a N, lo sumamos
        if (nodo.getDato() > n) {
            return nodo.getDato() + sumarMayoresA(nodo.getSig(), n);
        } else {
            // Si no es mayor a N, simplemente continuamos con la siguiente llamada recursiva
            return sumarMayoresA(nodo.getSig(), n);
        }
    }
    /*
    sumarMayoresA(nodo: 10) = 0
    sumarMayoresA(nodo: 23) = 23 + 0 = 23
    sumarMayoresA(nodo: 32) = 32 + 23 = 55
    sumarMayoresA(nodo: 2) = 0 + 55 = 55
    sumarMayoresA(nodo: 8) = 0 + 55 = 55
    sumarMayoresA(nodo: 1) = 0 + 55 = 55
    */
    
    /*
    Dada una implementacion de un TAD Lista con nodos simplemente enlazados ordenados en forma 
    ascendente sin numeros repetidos con puntero al inicio 
    Lista: 4 -> 5 -> 7 -> 23 -> 30 -> 39
    a) Implemente una nueva operacion en el TAD que inserte en forma ordenada un valor indicado en la
    lista, unicamente si ya no existe dicho numero en la lista. Se debera retornar un boolean indicando
    si se pudo agregar o no el valor.
    public boolean insertarOrdenado(int valor)
    b) Implemente una nueva operacion en el TAD que retorne una cola con los elementos que se 
    encuentran en la lista. La cola debe estar dispuesta de forma que el elemento que se encuentra
    al principio de la lista sea el ultimo elemento de la cola y el elemento que se encuentra al final de la
    lista sea el frente de la cola.
    public Cola listaACola()
    Ejemplo de retorno para la lista dada. Cola resultante: 4 -> 5 -> 7 -> 23 -> 30 -> 39 (frente)
    */
    
    public boolean insertarOrdenado(int valor) {
        NodoInt nuevo = new NodoInt(valor);

        // Recorrer la lista para encontrar la posición adecuada
        NodoInt actual = inicio;
        while (actual.getSig() != null && actual.getSig().getDato() < valor) {
            actual = actual.getSig();
        }

        // Verificar si el valor ya existe
        if (actual.getSig() != null && actual.getSig().getDato() == valor) {
            return false; // El valor ya existe
        }

        // Insertar el nuevo nodo en la posición correcta
        nuevo.setSig(actual.getSig());
        actual.setSig(nuevo);
        return true;
    }
    
    public Cola listaACola() {
        Cola cola = new Cola();

        // Crear una pila temporal para invertir el orden
        Pila pila = new Pila();
        NodoInt actual = inicio;

        // Pasar los elementos de la lista a la pila (invertir el orden)
        while (actual != null) {
            pila.push(actual.getSig());
            actual = actual.getSig();
        }

        // Pasar los elementos de la pila a la cola
        while (!pila.esVacia()) {
            cola.enqueue(pila.pop());
        }

        return cola;
    }
    
    public Pila listaAPila() {
        Pila pila = new Pila();
        NodoInt actual = inicio;

        // Recorrer la lista y agregar cada elemento a la pila
        while (actual != null) {
            pila.push(actual.getDato());
            actual = actual.getSig();
        }

        return pila;
    }
}
