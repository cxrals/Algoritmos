package practica_parcial;

import java.util.Arrays;

public class Ordenacion {

    
    public static void main(String[] args) {
        int[] datos = {34, 1, 22, 18, 33};
        
        System.out.println(Arrays.toString(datos));
        insertionSort(datos);
        System.out.println(Arrays.toString(datos));
    }
    
    //==========================================================================================
    // Parcial 2024-07-25 NOCT
    //==========================================================================================
    /*
    A continuación, se detalla una versión del algoritmo insert sort, la cual cuenta con algunos errores en la
    sección marcada en amarillo.
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            // Completar el siguiente bucle while
            while (j > 0 && arr[j] > key) {
                arr[j] = arr[j];
                j = j - 1;
            }
            arr[j] = key;
        }
    }
    a) Corrija únicamente lo que considere que es incorrecto del algoritmo. 
    b) Para un vector con los valores [34,1,22,18,33], muestre como quedaría el vector luego de cada
    inserción.
    */
    // ==================================== a ====================================
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            // Corrección del bucle while
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key; // Inserción del valor clave
        }
    }
    // ==================================== b ====================================
    /*
    Primera iteración (i = 1, key = 1):
    Comparación: 34 > 1.
    Resultado: [1, 34, 22, 18, 33].
    
    Segunda iteración (i = 2, key = 22):
    Comparación: 34 > 22.
    Resultado: [1, 22, 34, 18, 33].
    
    Tercera iteración (i = 3, key = 18):
    Comparación: 34 > 18, 22 > 18.
    Resultado: [1, 18, 22, 34, 33].
    
    Cuarta iteración (i = 4, key = 33):
    Comparación: 34 > 33.
    Resultado: [1, 18, 22, 33, 34].
    */
    
    //==========================================================================================
    // Parcial 2024-07-25 MAT
    //==========================================================================================
    /*
    A continuación, se detalla una versión del algoritmo selection sort, el cual cuenta con algunos errores en la
    sección marcada en amarillo.
     public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int arr[minIdx] = i;
            for (int j = i + 1; j < arr.length-1; j++) {
                if (arr[j] > arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Completar el siguiente intercambio
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
    a) Corrija únicamente lo que considere que es incorrecto del algoritmo. 
    b) Para un vector con los valores [34,1,22,18,33], muestre como quedaría el vector luego de cada
    iteración de búsqueda del mínimo.
    */
    // ==================================== a ====================================
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { // Corrección: Hasta el penúltimo elemento
            int minIdx = i; // Inicializar índice del mínimo
            for (int j = i + 1; j < arr.length; j++) { // Corrección: Comparar hasta el último elemento
                if (arr[j] < arr[minIdx]) { // Buscar el mínimo
                    minIdx = j;
                }
            }
            // Intercambio de elementos
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
    // ==================================== b ====================================
    /*
    Primera iteración (i = 0):
    minIdx se actualiza a 1 porque arr[1] = 1 es el mínimo.
    Intercambio entre arr[0] y arr[1].
    Resultado: [1, 34, 22, 18, 33].
    
    Segunda iteración (i = 1):
    minIdx se actualiza a 3 porque arr[3] = 18 es el mínimo.
    Intercambio entre arr[1] y arr[3].
    Resultado: [1, 18, 22, 34, 33].
    
    Tercera iteración (i = 2):
    minIdx se mantiene en 2 porque arr[2] = 22 ya es el mínimo.
    No hay intercambio.
    Resultado: [1, 18, 22, 34, 33].
    
    Cuarta iteración (i = 3):
    minIdx se actualiza a 4 porque arr[4] = 33 es el mínimo.
    Intercambio entre arr[3] y arr[4].
    Resultado: [1, 18, 22, 33, 34].
    */
    
    //==========================================================================================
    // Parcial 2023-07 NOCT
    //==========================================================================================
    /*
    Dado el siguiente vector: int v[] = {23, 60, 33, 40, 7, 56, 44};
    a) Complete la secuencia faltante, indicando el nombre del algoritmo de ordenación que
    fue ejecutado 
        [23, 60, 33, 40, 7, 56, 44]
        [23, 33, 40, 7, 56, 44, 60]
        [23, 33, 7, 40, 44, 56, 60]
        -------COMPLETAR-------
        [7, 23, 33, 40, 44, 56, 60]
        [7, 23, 33, 40, 44, 56, 60]
    b) Escriba el algoritmo de ordenación. Indique como se podría implementar una mejora
    para que no siga recorriendo, para el caso de que el vector quede ordenado antes de
    realizar las 6 pasadas.
    */
    
    // ==================================== a ====================================
    /*
    Estado inicial: Vector: [23, 60, 33, 40, 7, 56, 44]
    BUBBLE
    Primera pasada:
    Comparamos e intercambiamos si es necesario:
    23 < 60: Sin cambios.
    60 > 33: Intercambiamos → [23, 33, 60, 40, 7, 56, 44].
    60 > 40: Intercambiamos → [23, 33, 40, 60, 7, 56, 44].
    60 > 7: Intercambiamos → [23, 33, 40, 7, 60, 56, 44].
    60 > 56: Intercambiamos → [23, 33, 40, 7, 56, 60, 44].
    60 > 44: Intercambiamos → [23, 33, 40, 7, 56, 44, 60].
    Resultado: [23, 33, 40, 7, 56, 44, 60] (el 60 está en su posición final).

    Segunda pasada:
    Repetimos el proceso, excepto en el último elemento (ya ordenado):
    23 < 33: Sin cambios.
    33 < 40: Sin cambios.
    40 > 7: Intercambiamos → [23, 33, 7, 40, 56, 44, 60].
    40 < 56: Sin cambios.
    56 > 44: Intercambiamos → [23, 33, 7, 40, 44, 56, 60].
    Resultado: [23, 33, 7, 40, 44, 56, 60] (el 56 está en su posición final).

    Tercera pasada:
    Repetimos el proceso, excepto en los últimos dos elementos (ya ordenados):
    23 < 33: Sin cambios.
    33 > 7: Intercambiamos → [23, 7, 33, 40, 44, 56, 60].
    33 < 40: Sin cambios.
    Resultado: [23, 7, 33, 40, 44, 56, 60] (el 44 está en su posición final).

    Cuarta pasada:
    Repetimos el proceso, excepto en los últimos tres elementos (ya ordenados):
    23 > 7: Intercambiamos → [7, 23, 33, 40, 44, 56, 60].
    23 < 33: Sin cambios.
    Resultado: [7, 23, 33, 40, 44, 56, 60] (el 40 está en su posición final).

    Quinta y sexta pasada:
    No se hacen intercambios, ya que el vector está completamente ordenado.
    Resultado: [7, 23, 33, 40, 44, 56, 60].
    */
    // ==================================== b ====================================
    
    //==========================================================================================
    // Parcial 2023-07 MAT
    //==========================================================================================
    /*
    Dado el siguiente vector: int v[] = {64, 34, 25, 12, 22, 11, 90};
    a) Complete la secuencia faltante, indicando el nombre del algoritmo de ordenación que
    fue ejecutado. (3 ptos.)
        - 34- 25- 12- 22- 11- 64- 90
        - 25- 12- 22- 11- 34- 64- 90
        - 12- 22- 11- 25- 34- 64- 90
        - COMPLETAR -
        - 11- 12- 22- 25- 34- 64- 90
        - 11- 12- 22- 25- 34- 64- 90
    b) Realice la implementación de un algoritmo de ordenación - de los vistos en el curso -
    que considere que es más eficiente al algoritmo presentado en a). Describa de qué
    forma se le podría realizar una mejora, para el escenario en que el vector quede
    ordenado antes del total de pasadas previstas por el algoritmo.
    */
    
    // ==================================== a ====================================
    /*\
    BUBBLE
    Comparaciones e intercambios:
    64 > 34, intercambiamos → [34, 64, 25, 12, 22, 11, 90].
    64 > 25, intercambiamos → [34, 25, 64, 12, 22, 11, 90].
    64 > 12, intercambiamos → [34, 25, 12, 64, 22, 11, 90].
    64 > 22, intercambiamos → [34, 25, 12, 22, 64, 11, 90].
    64 > 11, intercambiamos → [34, 25, 12, 22, 11, 64, 90].
    El 90 ya está en su posición final.
    Resultado: [34, 25, 12, 22, 11, 64, 90].
    
    Segunda pasada:
    Comparaciones e intercambios:
    34 > 25, intercambiamos → [25, 34, 12, 22, 11, 64, 90].
    34 > 12, intercambiamos → [25, 12, 34, 22, 11, 64, 90].
    34 > 22, intercambiamos → [25, 12, 22, 34, 11, 64, 90].
    34 > 11, intercambiamos → [25, 12, 22, 11, 34, 64, 90].
    El 64 ya está en su posición final.
    Resultado: [25, 12, 22, 11, 34, 64, 90].
    
    Tercera pasada:
    Comparaciones e intercambios:
    25 > 12, intercambiamos → [12, 25, 22, 11, 34, 64, 90].
    25 > 22, intercambiamos → [12, 22, 25, 11, 34, 64, 90].
    25 > 11, intercambiamos → [12, 22, 11, 25, 34, 64, 90].
    El 34 ya está en su posición final.
    Resultado: [12, 22, 11, 25, 34, 64, 90].
    
    Cuarta pasada:
    Comparaciones e intercambios:
    12 < 22: Sin cambios.
    22 > 11, intercambiamos → [12, 11, 22, 25, 34, 64, 90].
    El 25 ya está en su posición final.
    Resultado: [12, 11, 22, 25, 34, 64, 90].
    
    Quinta pasada:
    Comparaciones e intercambios:
    12 > 11, intercambiamos → [11, 12, 22, 25, 34, 64, 90].
    El 22 ya está en su posición final.
    Resultado: [11, 12, 22, 25, 34, 64, 90].
    
    Sexta pasada:
    Sin intercambios, ya está completamente ordenado:
    Resultado final: [11, 12, 22, 25, 34, 64, 90].
    */
    
    //==========================================================================================
    // Parcial 2022-06-30 N3E
    //==========================================================================================
    /*
    Dado el siguiente vector: int v[] = {35,7,67,52,31,28}
    Indique el algoritmo de ordenación utilizado en la vista parcial y realice su implementación
        - 35 – 07 – 67 – 52 – 31 - 28
        - 07 - 35 – 67 – 52 – 31 - 28
        - 07 – 28 – 67 – 52 – 31 - 35
        - 07 – 28 – 31 – 52 – 67 - 35
    */
    /*
    Dado el vector inicial: int v[] = {35, 7, 67, 52, 31, 28}.
    SELECTION
    Paso 1: Primera iteración (i = 0)
    Subconjunto: [35, 7, 67, 52, 31, 28].
    Encuentra el menor valor (7) y lo intercambia con el elemento en la posición 0.
    Resultado: [7, 35, 67, 52, 31, 28].
    
    Paso 2: Segunda iteración (i = 1)
    Subconjunto: [35, 67, 52, 31, 28].
    Encuentra el menor valor (28) y lo intercambia con el elemento en la posición 1.
    Resultado: [7, 28, 67, 52, 31, 35].
    
    Paso 3: Tercera iteración (i = 2)
    Subconjunto: [67, 52, 31, 35].
    Encuentra el menor valor (31) y lo intercambia con el elemento en la posición 2.
    Resultado: [7, 28, 31, 52, 67, 35].
    
    Paso 4: Cuarta iteración (i = 3)
    Subconjunto: [52, 67, 35].
    Encuentra el menor valor (35) y lo intercambia con el elemento en la posición 3.
    Resultado: [7, 28, 31, 35, 67, 52].
    
    Paso 5: Quinta iteración (i = 4)
    Subconjunto: [67, 52].
    Encuentra el menor valor (52) y lo intercambia con el elemento en la posición 4.
    Resultado: [7, 28, 31, 35, 52, 67].
    */
}
