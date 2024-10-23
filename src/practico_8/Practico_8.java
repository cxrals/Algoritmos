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
    // ============================== EJERCICIO 5 ==============================
        
        
    
    
}
