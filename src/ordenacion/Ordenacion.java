package ordenacion;

import java.util.Arrays;

public class Ordenacion {

    public static void main(String[] args) {
        int[] datos = {122, 2, 30, 4, 5, 60, 7, 8, 9, 23, 24};
        int[] datos2 = {122, 2, 30, 4, 5, 60, 7, 8, 9, 23, 24};
        int[] datos3 = {122, 2, 30, 4, 5, 60, 7, 8, 9, 23, 24};
        int[] datos4 = {122, 2, 30, 4, 5, 60, 7, 8, 9, 23, 24};
        int[] datos5 = {122, 2, 30, 4, 5, 60, 7, 8, 9, 23, 24};
        
        System.out.println("============================ SELECTION SORT ============================");
        System.out.println(Arrays.toString(datos));
        selectionSort(datos);
        System.out.println(Arrays.toString(datos));
        System.out.println("============================= BUBBLE SORT ==============================");
        System.out.println(Arrays.toString(datos2));
        burbuja(datos2);
        System.out.println(Arrays.toString(datos2));
        System.out.println("============================ INSERTION SORT ============================");
        System.out.println(Arrays.toString(datos3));
        insertionSort(datos3, 0, datos3.length - 1);
        System.out.println(Arrays.toString(datos3));
        System.out.println("============================== MERGE SORT ==============================");
        System.out.println(Arrays.toString(datos4));
        mergeSort(datos4);
        System.out.println(Arrays.toString(datos4));
        System.out.println("============================== QUICK SORT ==============================");
        System.out.println(Arrays.toString(datos5));
        quickSort(datos5,0, datos5.length - 1);
        System.out.println(Arrays.toString(datos5));
    }
    
    // ============================== SELECTION SORT ==============================
    public static void selectionSort(int[] vector) {
        int cantidadDeIntercambios = 0;
        int cantidadDeIteraciones = 0;
        int aux;
        for (int i = 0; i < vector.length - 1; i++) {
            int posMin = i;
            for (int j = i + 1; j < vector.length; j++) {
                cantidadDeIteraciones++;
                if (vector[j] < vector[posMin]) {
                    posMin = j;
                }
            }
            if (vector[posMin] < vector[i]) {
                aux = vector[i];
                vector[i] = vector[posMin];
                vector[posMin] = aux;
                cantidadDeIntercambios++;
            }
        }
        System.out.println("cantidadDeIteraciones = " + cantidadDeIteraciones);
        System.out.println("cantidadDeIntercambios = " + cantidadDeIntercambios);
    }
    
    // ============================== BUBBLE SORT ==============================
    public static void burbuja(int[] vector) {
        int cantidadDeIntercambios = 0;
        int cantidadDeIteraciones = 0;
        boolean estaOrdenado = false;
        for (int i = 0; i < vector.length && !estaOrdenado; i++) {
            estaOrdenado = true;
            for (int j = 0; j < vector.length - 1 - i; j++) {
                cantidadDeIteraciones++;
                if (vector[j] > vector[j + 1]) {
                    int aux = vector[j + 1];
                    vector[j + 1] = vector[j];
                    vector[j] = aux;
                    cantidadDeIntercambios++;
                    estaOrdenado = false;
                }
            }
        }
        System.out.println("cantidadDeIteraciones = " + cantidadDeIteraciones);
        System.out.println("cantidadDeIntercambios = " + cantidadDeIntercambios);
    }
     
    // ============================== INSERTION SORT ==============================
    public static void insertionSort(int[] vector, int desde, int hasta) {
        int aux;
        for (int i = desde + 1; i <= hasta; i++) {
            int j = i - 1;
            while(j >= desde && vector[j] > vector[j+1]) {
                // intercambiar
                aux = vector[j];
                vector[j] = vector[j+1];
                vector[j+1] = aux;
                
                // moverme <--
                j--;
            }
        }
    }
    
    // ============================== MERGE SORT ==============================
    public static void mergeSort(int[] vector) {
        if (vector.length > 1) {
            int mid = vector.length / 2;
            int[] vec1 = new int[mid];
            int[] vec2 = new int[vector.length - mid];

            // Cargo los arrays
            for (int i = 0; i < mid; i++) {
                vec1[i] = vector[i];
            }

            for (int i = mid; i < vector.length; i++) {
                vec2[i - mid] = vector[i];
            }

            // Uso recursividad para dividir el problema
            mergeSort(vec1);
            mergeSort(vec2);

            // Junto las soluciones
            merge(vector, vec1, vec2);
        }
    }
    
    public static void merge(int[] vector, int[] vec1, int[] vec2) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < vec1.length || j < vec2.length) {
            if (i < vec1.length && j < vec2.length) {
                if (vec1[i] <= vec2[j]) {
                    vector[k++] = vec1[i++];
                } else {
                    vector[k++] = vec2[j++];
                }
            } else {
                if (i < vec1.length) {
                    vector[k++] = vec1[i++];
                } else {
                    vector[k++] = vec2[j++];
                }
            }
        }
    }
    
    // ============================== QUICK SORT ==============================
    private static void quickSort(int[] vec, int inicio, int fin) {
        if (inicio < fin) {
            int pos = particion(vec, inicio, fin);
            quickSort(vec, inicio, pos - 1);
            quickSort(vec, pos + 1, fin);
        }
    }

    private static int particion(int[] vec, int inicio, int fin) {
        int pivot = vec[fin];
        int i = inicio;
        int aux;

        for (int j = inicio; j < fin; j++) {
            if (vec[j] <= pivot) {
                aux = vec[i];
                vec[i] = vec[j];
                vec[j] = aux;
                i++;
            }
        }
        vec[fin] = vec[i];
        vec[i] = pivot;
        return i;
    }
}
