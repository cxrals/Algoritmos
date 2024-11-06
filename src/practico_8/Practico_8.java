package practico_8;

public class Practico_8 {

    
    public static void main(String[] args) {
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
    
        mostrarMatriz(matriz);
        System.out.println("ej2 maximoMatriz: " + maximoMatriz(matriz));
        System.out.println("ej3 minimoMatriz: " + minimoMatriz(matriz)); 
        mostrardiagonal(matriz);
        mostrarColumna(matriz, 1);
        mostrarFila(matriz, 1);
        mostrarFilasImpares(matriz);
        mostrarValoresImpares(matriz);
        System.out.println("ej9 buscarElementoEnMatriz: " +buscarElementoEnMatriz(matriz,1));
        System.out.println("ej9 buscarElementoEnMatriz: " +buscarElementoEnMatriz(matriz,10));
        System.out.println("ej10 buscarEnFila: " + buscarEnFila(matriz,0,1));
        System.out.println("ej11 buscarEnColumna: " + buscarEnColumna(matriz,0,1));
        mostrarRec(matriz,0,0);
        System.out.println("ej13 sumaMatrizRec: " + sumaMatrizRec(matriz,0,0));
        System.out.println("ej14 buscarEnFilaRec: " + buscarEnFilaRec(matriz,0,2,0));
        System.out.println("ej15 buscarEnColumnaRec: " + buscarEnColumnaRec(matriz,2,6,0));
        System.out.println("ej16 buscarElementoEnMatrizRec: " + buscarElementoEnMatrizRec(matriz,2,0,0));
    
    } 

    // ============================== EJERCICIO 1 ==============================
    public static void mostrarMatriz(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    // ============================== EJERCICIO 2 ==============================
    public static int maximoMatriz(int[][] mat) {
        int maximo = mat[0][0];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] > maximo) {
                    maximo = mat[i][j];
                }
            }
        }
        return maximo;
    }
    // ============================== EJERCICIO 3 ==============================
    public static int minimoMatriz(int[][] mat) {
        int minimo = mat[0][0];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] < minimo) {
                    minimo = mat[i][j];
                }
            }
        }
        return minimo;
    }
    // ============================== EJERCICIO 4 ==============================
    public static void mostrardiagonal(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            if (i < mat[i].length) {
                System.out.print(mat[i][i] + " ");
            }
        }
        System.out.println();
    }
    // ============================== EJERCICIO 5 ==============================
    public static void mostrarColumna(int[][] mat, int columna) {
        for (int i = 0; i < mat.length; i++) {
            if (columna < mat[i].length) {
                System.out.println(mat[i][columna]);
            }
        }
    }    
    // ============================== EJERCICIO 6 ==============================
    public static void mostrarFila(int[][] mat, int fila) {
        if (fila < mat.length) {
            for (int j = 0; j < mat[fila].length; j++) {
                System.out.print(mat[fila][j] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Fila fuera de rango.");
        }
    }
    // ============================== EJERCICIO 7 ==============================
    public static void mostrarFilasImpares(int[][] mat) {
        for (int i = 1; i < mat.length; i += 2) {  // Comenzar en 1 para filas impares
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    // ============================== EJERCICIO 8 ==============================
    public static void mostrarValoresImpares(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] % 2 != 0) {  // Verificar si el valor es impar
                    System.out.print(mat[i][j] + " ");
                }
            }
        }
        System.out.println();
    }
    // ============================== EJERCICIO 9 ==============================
    public static boolean buscarElementoEnMatriz(int[][] mat, int elemento) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == elemento) {
                    return true;
                }
            }
        }
        return false;
    }
    // ============================== EJERCICIO 10 ==============================
    public static boolean buscarEnFila(int[][] mat, int fila, int elemento) {
        if (fila < mat.length) {
            for (int j = 0; j < mat[fila].length; j++) {
                if (mat[fila][j] == elemento) {
                    return true;
                }
            }
        }
        return false;
    }
    // ============================== EJERCICIO 11 ==============================
    public static boolean buscarEnColumna(int[][] mat, int columna, int elemento) {
        for (int i = 0; i < mat.length; i++) {
            if (columna < mat[i].length && mat[i][columna] == elemento) {
                return true;
            }
        }
        return false;
    }
    // ============================== EJERCICIO 12 ==============================
    public static void mostrarRec(int[][] mat, int fila, int columna) {
        if (fila >= mat.length) {
            return;
        }
        if (columna < mat[fila].length) {
            System.out.print(mat[fila][columna] + " ");
            mostrarRec(mat, fila, columna + 1);  // Moverse al siguiente elemento en la fila
        } else {
            System.out.println();
            mostrarRec(mat, fila + 1, 0);  // Moverse a la siguiente fila
        }
    }

    // ============================== EJERCICIO 13 ==============================
    // retorna la suma de los valores de la matriz
    public static int sumaMatrizRec(int[][] mat, int fila, int columna) {
        if (fila >= mat.length) {
            return 0;
        }
        if (columna < mat[fila].length) {
            return mat[fila][columna] + sumaMatrizRec(mat, fila, columna + 1);  // Sumar los elementos de la fila
        } else {
            return sumaMatrizRec(mat, fila + 1, 0);  // Moverse a la siguiente fila
        }
    }

    // ============================== EJERCICIO 14 ==============================
    // busca un elemento en una fila de una matriz y retorna true
    public static boolean buscarEnFilaRec(int[][] mat, int fila, int elemento, int columna) {
        if (fila >= mat.length || columna >= mat[fila].length) {
            return false;
        }
        if (mat[fila][columna] == elemento) {
            return true;
        }
        return buscarEnFilaRec(mat, fila, elemento, columna + 1);  // Moverse al siguiente elemento en la fila
    }

    // ============================== EJERCICIO 15 ==============================
    public static boolean buscarEnColumnaRec(int[][] mat, int columna, int elemento, int fila) {
        if (fila >= mat.length) {
            return false;
        }
        if (columna >= mat[fila].length) {
            return false;
        }
        if (mat[fila][columna] == elemento) {
            return true;
        }
        return buscarEnColumnaRec(mat, columna, elemento, fila + 1);  // Moverse al siguiente elemento en la columna
    }

    // ============================== EJERCICIO 16 ==============================
    public static boolean buscarElementoEnMatrizRec(int[][] mat, int elemento, int fila, int columna) {
        if (fila >= mat.length) {
            return false;
        }
        if (columna < mat[fila].length) {
            if (mat[fila][columna] == elemento) {
                return true;
            }
            return buscarElementoEnMatrizRec(mat, elemento, fila, columna + 1);  // Moverse al siguiente elemento en la fila
        } else {
            return buscarElementoEnMatrizRec(mat, elemento, fila + 1, 0);  // Moverse a la siguiente fila
        }
    }
    
}
