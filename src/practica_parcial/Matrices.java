package practica_parcial;


public class Matrices {
    public static void main(String[] args) {
        int[][] matriz = {
            {1, 6, 7, 31},
            {10, 4, 11, 40},
            {3, 23, 5, 43},
            {51, 2, 8, 9}
        };
        
        int[][] matriz2 = {
            {1, 4, 2, 3},
            {2, 4, 7, 4},
            {5, 1, 5, 5},
            {3, 2, 5, 7}
        };
        
        int[][] matriz3 = {
            {28,      3,       62,      18},
            {15,      39,      47,      5},
            {8,       57,      45,      6},
            {25,      16,      71,      35}
        };
        
        int[][] matriz4 = {
            {1,   6,   3,   11,  3},
            {11,  12,  6,   40,  14},
            {5,   5,   6,   2,   6},
            {8,   6,   20,  1,   9},
            {7,   23,  1,   5,   4},
            {6,   8,   2,   4,   6}
        };
        
        
        System.out.println("============== Examen 2024-09-20 ==============");
        System.out.println("minimoEntreCol: " + minimoEntreCol(matriz, 1,2));
        System.out.println("indiceFilaMax: " + indiceFilaMax(matriz));
        System.out.println("mostrarColumna: " );
        mostrarColumna(matriz, 2, 0);
        System.out.println("============== Examen 2024-07-31 ==============");
    }
    
    //==========================================================================================
    // Examen 2024-09-20
    //==========================================================================================
    /*
    Dado una matriz de enteros, no repetidos:
        1       6      7       31
        10      4      11      40
        3       23     5       43
        51      2      8       9
    a.  Escriba un algoritmo que retorne el mínimo de los elementos de la matriz, entre dos
        columnas dadas.
        Ej: para col1: 1 y col2: 2, el resultado debería ser: 2
    b.  Escriba un algoritmo que retorne el índice de la fila que tenga el valor más grande
        Ej: para la matriz dispuesta, debería retornar 3 (el 51 es el valor más grande)
    c.  Escriba un método recursivo que muestre los valores de una columna dada, comenzando
        por el valor de la fila 0. Realice el diagrama de llamadas para la matriz dada y la columna:2
        Ej: para la columna: 2 debería mostrar 7 11 5 8
    */
    //pre: col1 <= col2
    public static int minimoEntreCol (int[][] mat, int col1, int col2){
        int minimo = Integer.MAX_VALUE;
        
        for(int i=0; i < mat.length; i++) {
            for(int j = col1; j < col2; j++) {
                if (mat[i][j] < minimo) {
                minimo = mat[i][j];
                }
            }
        }
        return minimo;
    }
    
    public static int indiceFilaMax(int[][] mat) {
        int max = Integer.MIN_VALUE;
        int filaMax = -1;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] > max) {
                    max = mat[i][j];
                    filaMax = i;
                }
            }
        }
        return filaMax;
    }
    
    public static void mostrarColumna(int[][] mat, int col, int fila) {
        // Caso base: si la fila supera el tamaño de la matriz
        if (fila != mat.length) {
            System.out.print(mat[fila][col] + " ");
            // Llamada recursiva a la siguiente fila
            mostrarColumna(mat, col, fila + 1);
        }
    }
    
    //==========================================================================================
    // Examen 2024-07-31
    //==========================================================================================
    /*
    Dado una matriz cuadrada de entero:
        1 4 2 3
        2 4 7 4
        5 1 5 5
        3 2 5 7
    a.  Escriba un algoritmo que retorne el máximo de los elementos de la matriz.
    b.  Escriba un algoritmo que retorne el índice de la columna que tenga la mayor suma. En caso
        de haber más de una, retornar la de índice mayor.
        Ej: para la matriz dispuesta, la columna con la mayor suma es la de índice 2 y 3 (ambas suman 19). En este
        caso, se debería retornar 3
    c.  Escriba un método recursivo que retorne la suma de la diagonal principal de la matriz.
    */
    // ==================================== a ====================================
    public static int obtenerMaximo(int[][] matriz) {
        int maximo = matriz[0][0];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > maximo) {
                    maximo = matriz[i][j];
                }
            }
        }
        return maximo;
    }

    // ==================================== b ====================================
    public static int encontrarColumnaMayorSuma(int[][] matriz) {
        int columnas = matriz[0].length;
        int filas = matriz.length;
        int maxSuma = Integer.MIN_VALUE;
        int indiceMaxColumna = -1;
        for (int j = 0; j < columnas; j++) {
            int sumaColumna = 0;
            for (int i = 0; i < filas; i++) {
                sumaColumna += matriz[i][j];
            }
            if (sumaColumna >= maxSuma) {
                maxSuma = sumaColumna;
                indiceMaxColumna = j;
            }
        }
        return indiceMaxColumna;
    }
    // ==================================== c ====================================
    public static int sumaDiagonalRecursiva(int[][] matriz, int indice) {
        // Caso base: Si el índice ha alcanzado el tamaño de la matriz, se retorna 0
        if (indice == matriz.length) {
            return 0;
        }
        // Caso recursivo: Sumar el elemento en la diagonal principal y llamar recursivamente para el siguiente
        return matriz[indice][indice] + sumaDiagonalRecursiva(matriz, indice + 1);
    }
    //==========================================================================================
    // Examen 2024-05-10
    //==========================================================================================
    /*
    Escriba un algoritmo que, dado una matriz de enteros de largo mxn indique (mediante un valor
    booleano) si las diagonales de la matriz suman lo mismo, como se muestra en el ejemplo.
        28      3       62      18
        15      39      47      5
        8       57      45      6
        25      16      71      35
    */
    public boolean sumanIguales(int mat[][]) {
        boolean iguales = true;
        int diagoPrincipal = 0;
        int diagoSecundaria = 0;
        for (int i = 0; i < mat.length; i++) {
            diagoPrincipal += mat[i][i];
            diagoSecundaria += mat[i][mat.length - 1 - i];
        }
        if (diagoPrincipal != diagoSecundaria) {
            iguales = false;
        }
        return iguales;
    }
    //==========================================================================================
    // Parcial 2024-07-25
    //==========================================================================================
    /*
    Sea M una matriz de enteros:
    Ejemplo de matriz de 4 X 5:
            0   1   2   3   4

        0   1   6   3   11  3
        1   11  12  6   40  14
        2   5   5   6   2   6
        3   8   6   20  1   9
        4   7   23  1   5   4
        5   6   8   2   4   6
    a.  desarrollar un algoritmo que verifique que indique si existen en la matriz 2 columnas que sumen
        exactamente lo mismo. En caso de existir, retornar true; en caso contrario retornar false.
    */
    

    public static boolean verificarColumnasIguales(int[][] matriz) {
        // Arreglo para almacenar las sumas de las columnas
        int[] sumaColumnas = new int[matriz[0].length];

        // Calcular las sumas de las columnas
        for (int col = 0; col < matriz[0].length; col++) {
            int suma = 0;
            for (int fila = 0; fila < matriz.length; fila++) {
                suma += matriz[fila][col];
            }
            sumaColumnas[col] = suma;
        }

        // Comparar las sumas entre todas las columnas
        for (int i = 0; i < matriz[0].length; i++) {
            for (int j = i + 1; j < matriz[0].length; j++) {
                if (sumaColumnas[i] == sumaColumnas[j]) {
                    return true; // Encontramos dos columnas con la misma suma
                }
            }
        }

        // Si no se encontró ninguna coincidencia
        return false;
    }

    

}
