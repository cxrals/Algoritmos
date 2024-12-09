package practica_parcial;

import java.util.Arrays;

public class Vectores {

    public static void main(String[] args) {
        //==========================================================================================
        // Examen 2024-09-20
        //==========================================================================================
        int[] vec1 = {1, 3, 5};
        int[] vec2 = {2, 4, 6};

        int[] resultado = entrelazarOrdenado(vec1, vec2);

        // Imprimir el vector resultante
        System.out.println(Arrays.toString(resultado));
        
        //==========================================================================================
        // Examen 2024-07-31
        //==========================================================================================
        int[] vec = {1, 3, 5, 7, 9, 11, 13, 15};
        int M = 7;

        boolean encontrado = buscarM(vec, M);
        System.out.println("¿El número " + M + " está en el vector? " + encontrado); 

        M = 8;
        encontrado = buscarM(vec, M);
        System.out.println("¿El número " + M + " está en el vector? " + encontrado); 
        
        //==========================================================================================
        // Parcial 2022-06-30
        //==========================================================================================
        int[] v = {1, 5, 34, 4, 70, 80, 8, 100};
        System.out.println("Suma entre posiciones 2 y 6: " + algoritmo(v, 2, 6));
        
        
        //==========================================================================================
        // Parcial 2022-06-27
        //==========================================================================================
        int[] vec3 = {10, 14, 19, 25, 30, 45, 49, 51};

        int resultado2 = suma(vec3, 3); // Llamada inicial con tope = 3
        System.out.println("Suma de 0 a 3: " + resultado2);
        
        //==========================================================================================
        // Parcial diciembre 2023
        //==========================================================================================
        int[] arr = {54, 166, 32, 73, 8, 713, 91, 48};

        int resultado5 = contarPares(arr, 1, 5); // Rango: posiciones 1 a 5
        System.out.println("Cantidad de números pares: " + resultado5);
        
        //==========================================================================================
        // Examen 2022-10-28
        //==========================================================================================
        int[] lista = {3, 6, 7, 10, 15, 20};
        int resultado6 = sumaMultiplos(lista, lista.length - 1); // Procesar desde el último elemento
        System.out.println("Suma de múltiplos de 2: " + resultado6);
        
        //==========================================================================================
        // Examen 2022-02-09
        //==========================================================================================
        int[] v5 = {11, 12, 22, 25, 34, 64, 90};

        System.out.println(busqueda(v5, 64, 0, v5.length - 1)); 
        System.out.println(busqueda(v5, 34, 0, v5.length - 1)); 
        System.out.println(busqueda(v5, 200, 0, v5.length - 1)); 


    }
    
    //==========================================================================================
    // Examen 2024-09-20
    //==========================================================================================
    /*
    Dado dos vectores de enteros ordenados en forma ascendente, implemente un método que
    retorne un nuevo vector, con los números de ambos vectores dispuestos en forma ordenada,
    en forma ascendente. Se valorará que el método sea eficiente. Escriba la pre y post
    condiciones del método.
    */
    public static int[] entrelazarOrdenado (int[ ] vec1, int[ ] vec2){
        // Crear un nuevo vector para el resultado
        int[] resultado = new int[vec1.length + vec2.length];
        int i = 0, j = 0, k = 0; // i y j para recorrer vec1 y vec2, k para resultado

        // Mezclar elementos de ambos vectores mientras haya elementos en ambos
        while (i < vec1.length && j < vec2.length) {
            if (vec1[i] <= vec2[j]) {
                resultado[k++] = vec1[i++];
            } else {
                resultado[k++] = vec2[j++];
            }
        }

        // Agregar los elementos restantes de vec1 (si quedan)
        while (i < vec1.length) {
            resultado[k++] = vec1[i++];
        }

        // Agregar los elementos restantes de vec2 (si quedan)
        while (j < vec2.length) {
            resultado[k++] = vec2[j++];
        }

        return resultado; // Retornar el vector resultante
    }
    
    //==========================================================================================
    // Examen 2024-07-31
    //==========================================================================================
    /*
    Dado un vector de enteros ordenado en forma ascendente y un número entero M, implemente
    un método de búsqueda que indique si se encuentra dicho número en el vector. Se valorará
    que el método sea eficiente. Escriba la pre y post condiciones del método.
    */
    
    // pre:
    // El vector de entrada (vec) debe estar ordenado en forma ascendente.
    // El vector no debe ser nulo.
    // El valor M es un entero que puede estar o no en el vector.
    // post:
    // El método retorna true si el número M está presente en el vector.
    // Retorna false si M no se encuentra en el vector.
    public static boolean buscarM (int[ ] vec, int M){
        // Inicializar los índices para búsqueda binaria
        int inicio = 0;
        int fin = vec.length - 1;

        // Búsqueda binaria iterativa
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2; // Evita desbordamiento al calcular el índice medio

            if (vec[medio] == M) {
                return true; // Se encontró el número
            } else if (vec[medio] < M) {
                inicio = medio + 1; // Buscar en la mitad derecha
            } else {
                fin = medio - 1; // Buscar en la mitad izquierda
            }
        }

        // Si se termina el bucle sin encontrar el número
        return false;
    }
    
    //==========================================================================================
    // Parcial 2022-06-30
    //==========================================================================================
    /* 
    a) Implementar un algoritmo recursivo que, dado una posición desde y una posición hasta, retorne la suma
    de los números que se encuentran entre estas dos posiciones (inclusive)
    Vector v= 1 5 34 4 70 80 8 100
    b) Realizar el diagrama de llamadas para Llamada inicial: algoritmo(v,2,6) 
    */
    
    private static int algoritmo(int[] v, int desde, int hasta){
        // Caso base: si 'desde' es igual a 'hasta', devolver el elemento en esa posición
        if (desde == hasta) {
            return v[desde];
        }

        // Caso recursivo: sumar el elemento actual con el resultado de la llamada recursiva
        return v[desde] + algoritmo(v, desde + 1, hasta);
    }
    
    //==========================================================================================
    // Parcial 2022-06-27
    //==========================================================================================
    /* 
    Dado el siguiente vector ordenado:
    10 14 19 25 30 45 49 51
    a. implementar un método recursivo que, dado un entero que indica la posición tope del array hasta la que
    hay que sumar, retorne la suma desde la posición 0 a esa posición tope. Para el ejemplo del vector
    dispuesto a continuación con tope 3, el retorno debería ser: 68
    b. Realizar el diagrama de llamadas para el array dispuesto anteriormente con tope 4
    */
    public static int suma(int vec[], int tope){
        // Caso base: si tope es 0, retornar el elemento en la posición 0
        if (tope == 0) {
            return vec[0];
        }

        // Caso recursivo: sumar el elemento en la posición tope con la suma de 0 a tope - 1
        return vec[tope] + suma(vec, tope - 1);
    }
    
    /*
    Suma(vec,4)
    vec[4]: 30 + suma(vec, 3)
    vec[3]: 25 + suma(vec, 2)
    vec[2]: 19 + suma(vec, 1)
    vec[1]: 14 + suma(vec, 0)
    vec[0]: 10 (caso base)
    vec[1]: 14 + 10 = 24
    vec[2]: 19 + 24 = 43
    vec[3]: 25 + 43 = 68
    vec[4]: 30 + 68 = 98
    Suma(vec,4) = 98
    */
    
    //==========================================================================================
    // Parcial diciembre 2023
    //==========================================================================================
    /* 
    Aplicando recursión desarrolle una función que, recibiendo un array de enteros, y dos números enteros
    (izq, der) retorne la cantidad de elementos pares que se encuentran entre dichas posiciones (izq y der)
    inclusive. Especifique las pre y post condiciones. Realice el diagrama de llamadas para el ejemplo
    detallado a continuación:
    Ejemplo: Retorno esperado para los valores izq=1 y der=5: 3.
        54 166 32 73 8 713 91 48
    */
    public static int contarPares(int[] arr, int izq, int der) {
        // Caso base: rango inválido
        if (izq > der) {
            return 0;
        }

        // Caso recursivo
        if (arr[izq] % 2 == 0) {
            return 1 + contarPares(arr, izq + 1, der); // Sumar 1 si el elemento es par
        } else {
            return contarPares(arr, izq + 1, der); // Continuar sin sumar si no es par
        }
    }
    
    /*
    contarPares(arr, 1, 5)
    arr[1]: 166 es par → 1 + contarPares(arr, 2, 5)
        arr[2]: 32 es par → 1 + contarPares(arr, 3, 5)
            arr[3]: 73 no es par → contarPares(arr, 4, 5)
                arr[4]: 8 es par → 1 + contarPares(arr, 5, 5)
                    arr[5]: 713 no es par → contarPares(arr, 6, 5)
                        Caso base: izq > der (6 > 5) → 0
                    Resultado: 0
                Resultado: 1 + 0 = 1
            Resultado: 1 + 1 = 2
        Resultado: 1 + 2 = 3
    Resultado: 1 + 3 = 3
    */

    
    //==========================================================================================
    // Examen 2022-10-28
    //==========================================================================================
    /* 
    Realizar un algoritmo recursivo que, dado un vector de enteros retorne la suma de todos aquellos valores que
    son múltiplos de dos.
    */
    public static int sumaMultiplos (int lista[], int pos){
        // Caso base: si la posición actual es menor que 0, no hay más elementos que procesar
        if (pos < 0) {
            return 0;
        }

        // Caso recursivo: si el elemento actual es múltiplo de 2, lo sumamos
        if (lista[pos] % 2 == 0) {
            return lista[pos] + sumaMultiplos(lista, pos - 1);
        } else {
            return sumaMultiplos(lista, pos - 1); // Continuar sin sumar si no es múltiplo de 2
        }
    }
    
    //==========================================================================================
    // Examen Mayo 2022
    //==========================================================================================
    /* 
    Sean disponibles los métodos minPosVec(int[] vec, int desde, int hasta) y maxPosVec(int[]
    vec, int desde, int hasta) que retornan respectivamente la posición del mínimo y máximo
    elemento del vector entre dos posiciones (inclusive) dadas:
    a) Implementar un algoritmo que reciba un vector de enteros desordenado y lo ordene,
    utilizando los métodos anteriormente mencionados.
    public void ordenarPorMinMax(int[] vec) {
        // Validación inicial
        if (vec == null || vec.length <= 1) {
            return; // No es necesario ordenar un vector nulo o de un solo elemento
        }

        int i = 0;                // Puntero al inicio del rango
        int j = vec.length - 1;   // Puntero al final del rango

        while (i < j) {
            // Encontrar posiciones del mínimo y máximo en el rango [i, j]
            int minPos = minPosVec(vec, i, j);
            int maxPos = maxPosVec(vec, i, j);

            // Colocar el mínimo en la posición i
            if (minPos != i) {
                int temp = vec[i];
                vec[i] = vec[minPos];
                vec[minPos] = temp;
            }

            // Actualizar la posición del máximo si fue afectado por el intercambio del mínimo
            if (maxPos == i) {
                maxPos = minPos;
            }

            // Colocar el máximo en la posición j
            if (maxPos != j) {
                int temp = vec[j];
                vec[j] = vec[maxPos];
                vec[maxPos] = temp;
            }

            // Reducir el rango de búsqueda
            i++;
            j--;
        }
    }
    */
    public int ordenarPorMinMax(int[] vec){throw new UnsupportedOperationException("Not supported yet.");}
    
    //==========================================================================================
    // Examen 2022-02-09
    //==========================================================================================
    /* 
    Implemente un método de búsqueda por bipartición en forma recursiva que retorne -1 si
    no encuentra el valor x recibido como parámetro y si lo encuentra retorne la posición
    dentro del vector.
    Firma a utilizar int busqueda(int v[], int X, int i, int j)
    Ejemplo
     Int v[] = { 11, 12,22, 25, 34, 64, 90};

     System.out.println(busqueda(v, 64, 0, v.length-1)); retorna 5
     System.out.println(busqueda(v, 34, 0, v.length-1)); retorna 4
     System.out.println(busqueda(v, 200, 0, v.length-1)); retorna 0
    */
    public static int busqueda(int v[], int X, int i, int j){
        // Caso base: rango inválido
        if (i > j) {
            return -1; // El valor X no está en el vector
        }

        // Calcular el índice medio
        int medio = i + (j - i) / 2; // Evita desbordamientos al calcular el medio

        // Caso base: el valor se encuentra en la posición media
        if (v[medio] == X) {
            return medio;
        }

        // Caso recursivo: buscar en la mitad izquierda
        if (X < v[medio]) {
            return busqueda(v, X, i, medio - 1);
        }

        // Caso recursivo: buscar en la mitad derecha
        return busqueda(v, X, medio + 1, j);
    }
}
