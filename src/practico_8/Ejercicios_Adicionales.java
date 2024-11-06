package practico_8;


public class Ejercicios_Adicionales {
    public static void main(String[] args) {
        int mat[][] = {
            {1,2,3},
            {4,2,0},
            {1,2,3}
        };
        
        int mat2[][] = {
            {1,1,5,1,1},
            {1,1,1,1,1},
            {5,1,1,1,1},
            {1,1,1,1,1},
            {1,1,1,1,1},
            {1,1,1,1,1},
            {1,1,5,1,1},
        };
        
        System.out.println("============================== EJERCICIO 1 ==============================");
        boolean especial = esEspecial(mat);
        System.out.println("especial = " + especial);
        System.out.println("============================== EJERCICIO 2 ==============================");
        boolean repetidos = repetidos(mat2,2,1);
        System.out.println("repetidos = " + repetidos);
        boolean noRepetidos = repetidos(mat2,6,2);
        System.out.println("repetidos = " + noRepetidos);
    }
    
    // ============================== EJERCICIO 1 ==============================
    public static boolean esEspecial(int[][] mat){
        int [] sumaCol = new int[mat[0].length];
        int[] sumaFilas = new int[mat.length];
        int sumaDiagonal = 0;
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                sumaCol[j] += mat[i][j];
                sumaFilas[i] += mat[i][j];
                
                if(i == j) {
                    sumaDiagonal += mat[i][j];
                }
            }
            
        }
        
        for (int x = 0; x < sumaFilas.length; x++) {
            if(sumaDiagonal != sumaFilas[x] ||  sumaDiagonal != sumaCol[x]) {
                return false;
            }
        }
        
        return true;
    }
    // ============================== EJERCICIO 2 ==============================
    public static boolean repetidos(int[][] mat, int fila, int col) {
        
        int i;
        int j;
        
        // derecha abajo
        i = fila + 1;
        j = col + 1;
        
        while (i < mat.length && j < mat[0].length) {
            if(mat[fila][col] == mat[i][j]) {
                return true;
            }
            i++;
            j++;
        }
        
        // derecha arriba
        i = fila - 1;
        j = col + 1;
        
        while (i >= 0 && j < mat[0].length) {
            if(mat[fila][col] == mat[i][j]) {
                return true;
            }
            i--;
            j++;
        }
        
        // izquierda abajo
        i = fila + 1;
        j = col - 1;
        
        while (i < mat.length && j >= 0) {
            if(mat[fila][col] == mat[i][j]) {
                return true;
            }
            i++;
            j--;
        }
        
        // izquierda arriba
        i = fila - 1;
        j = col - 1;
        
        while (i >= 0 && j >= 0) {
            if(mat[fila][col] == mat[i][j]) {
                return true;
            }
            i--;
            j--;
        }
        
        return false;
    }
}
