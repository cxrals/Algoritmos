package practica_parcial;
import practico_4.NodoInt;
import practico_6.Pila;



public class ListaSimple {
    private static NodoInt inicio;
    private NodoInt fin;
    private int cantidad;

    public static void main(String[] args) {
        //==========================================================================================
        // Parcial 2024-07-25
        //==========================================================================================
        ListaSimple lista = new ListaSimple();

        lista.agregarInicio(70);
        lista.agregarInicio(56);
        lista.agregarInicio(45);
        lista.agregarInicio(5);
        lista.agregarInicio(3);

        int pos = lista.posiciónDeNumero(56);
        System.out.println("pos = " + pos);
    }
    
    //==========================================================================================
    // Parcial 2024-09-20
    //==========================================================================================
    /*
    Se ha implementado una Lista simplemente enlazada que cuenta con un puntero al inicio y un
    entero para almacenar la cantidad de elementos.
    public class Lista {
        private Nodo inicio;
        private int cantidad;
        //…….
    }
    public class Nodo {
        private int dato;
        private Nodo sig;
        //Métodos de acceso y modificación disponibles
    }
    
    a.  Implemente la operación de instancia eliminar al final, que elimine el último elemento de la
        lista, retornando su valor
    
    b.  Implemente la operación de instancia sumaPares (de forma recursiva), que retorne la suma
        de todos los elementos pares de la lista. 
        Ej: para la lista 10-3-5-76-11-2 debería retornar: 88
    c.  Implemente la operación de instancia pilaDeMayores que recibe un número entero y retorna
        una pila con los elementos de la lista, cuyo valor sea mayor al número indicado. El primer
        número de la lista que cumpla la condición debe estar situado al tope de la lista. Los nodos
        de la lista y pila no deben compartir espacios en memoria (si quito un elemento de una
        estructura no debe afectar a la otra). Se dispone de las operaciones de pila vistas en el
        curso (apilar, desapilar, top) 
    d.  Implemente la nueva operación de instancia eliminarPrimerosN que recibe un entero N por
        parámetro y elimina los primeros N elementos de la lista
    */
    // ==================================== a ====================================
    public int eliminarFinal() {
        if (inicio != null) {
            NodoInt actual = inicio;

            // Si la lista tiene un solo elemento
            if (inicio.getSig() == null) {
                int dato = inicio.getDato();
                inicio = null;
                cantidad--;
                return dato;
            } else {
                // Recorremos hasta el penúltimo nodo
                while (actual.getSig().getSig() != null) {
                    actual = actual.getSig();
                }

                int dato = actual.getSig().getDato();
                actual.setSig(null);
                cantidad--;
                return dato;
            }
        }
        return -1;
    }
    
    // ==================================== b ====================================
    public int sumaPares(){
       return sumaParesAux(inicio);
    }
     
    // Método auxiliar recursivo
    private int sumaParesAux(NodoInt actual) {
        if (actual == null) {
            return 0; // Caso base
        }

        int suma = 0;
        
        // Si el dato es par
        if(actual.getDato() % 2 == 0) {
            return actual.getDato() + sumaParesAux(actual.getSig());
        } else {
            return sumaParesAux(actual.getSig());
        }
    }
    
    // ==================================== c ====================================
    public Pila pilaDeMayores(int numero) {
        Pila pila = new Pila();
        Pila pRet = new Pila();
        NodoInt actual = inicio;

        // Recorremos la lista
        while (actual != null) {
            if (actual.getDato() > numero) {
                pila.push(actual.getDato()); // Apilamos los elementos mayores que "numero"
            }
            actual = actual.getSig();
        }
        while (!pila.esVacia()) {
            pRet.push(pila.pop());
        }
        return pRet;
    }

    // ==================================== d ====================================
    //pre: n <= cantidad
    public void eliminarPrimerosN(int n){
        if (n <= cantidad) {
            for (int i = 0; i < n; i++) {
                if (inicio != null) {
                    inicio = inicio.getSig();
                    cantidad--;
                }
            }
        }
    }
    
    //==========================================================================================
    // Parcial 2024-07-25
    //==========================================================================================
    /*
    Dado una lista simplemente enlazada de nodos con valores enteros positivos, un valor C y una pila vacía:
    a) Implemente un algoritmo recursivo que coloque todos los elementos de la lista que sea mayores
    que C en la pila, de forma de que el primer elemento de la lista que cumpla con la condición se
    situé en el tope de la pila. Defina las pre y post condiciones.  Se Asumen disponibles los
    métodos gets y sets, así como todas las operaciones del TAD Pila (top(), apilar(), desapilar(), esVacia())
    Ejemplo para un valor C = 12
    LISTA
    23-11-20-5-14
    PILA
    23
    20
    14
    b) Realice el diagrama de llamadas 
    filtrarYApilar(Nodo(23))
    filtrarYApilar(Nodo(11))
    filtrarYApilar(Nodo(20))
    filtrarYApilar(Nodo(5))
    filtrarYApilar(Nodo(14))
    filtrarYApilar(null) // Caso base
    */
    void filtrarYApilar(NodoInt lista, int C, Pila pila) {
        // Caso base: Si la lista está vacía, terminamos
        if (lista == null) {
            return;
        }

        // Paso recursivo: Procesar el resto de la lista primero
        filtrarYApilar(lista.getSig(), C, pila);

        // Condición para apilar
        if (lista.getDato() > C) {
            pila.push(lista.getDato());
        }
    }
    /*
    Dada una implementación de un TAD Lista con nodos simplemente enlazados ordenados en forma
    ascendente, con puntero al inicio y puntero al final como se muestra a continuación:
    3-5-45-56-70
    a)  Implemente una nueva operación en el TAD que dado un número, retorne la posición en donde se
    encuentra dicho número en la lista, o retorne -1 en caso de no encontrarlo. Se valorará la eficiencia
    de la implementación. Ejemplo: para la lista anterior y el número 56, debería retornar 4.
    Firma sugerida: public int posiciónDeNumero(int num) (8 ptos)
    b) Implemente una nueva operación en el TAD que dada una posición, elimine de la lista el elemento
    que se encuentra en dicha posición y el siguiente (en caso de no existir un siguiente solamente
    eliminará el de la posición dada). Para un pos=2 la lista quedaría con: 3->56->70
    Firma sugerida: public void eliminar2Elementos(int pos)
    */
    public int posiciónDeNumero(int num) {
        NodoInt actual = inicio; // Comenzamos desde el inicio de la lista
        int pos = 0; 

        while (actual != null) { // Mientras no lleguemos al final de la lista
            if (actual.getDato() == num) { // Si encontramos el número
                return pos; // Retornamos la posición
            }
            actual = actual.getSig(); // Avanzamos al siguiente nodo
            pos++; // Incrementamos la posición
        }

        return -1; // Si llegamos aquí, el número no está en la lista
    }
    //==========================================================================================
    // Examen 2024-07-31
    //==========================================================================================
    /*
    Se ha implementado una Lista simplemente enlazada que cuenta con un puntero al inicio,
    puntero al final y un entero para almacenar la cantidad de elementos.
    
    public class Lista {
        private Nodo inicio;
        private Nodo fin;
        private int cantidad;
        //…….
    }
    public class Nodo {
        private int dato;
        private Nodo sig;
        //Métodos de acceso y modificación disponibles
    }
    Implemente las siguientes operaciones en el TAD Lista:
    a.  Implemente la operación de instancia agregarInicio que agregue un elemento al inicio
        retornando la cantidad de elementos actualizada.
    b.  Implemente la operación de instancia mostrar (de forma recursiva) que muestre por consola
        los primeros n elementos de la lista respetando el orden. Escribir el diagrama de llamadas
        para una lista que tenga los siguientes elementos agregados. Lista: 4 – 3 – 2 – 1
    c.  Implemente la operación de instancia obtenerInvertida que retorne una nueva lista con los
        elementos de forma invertida. Las listas no deben compartir espacios en memoria (si quito
        un elemento de una no debe afectar a la otra)
    d.  Implemente la nueva operación de instancia concatenar que recibe una lista por parámetro
        y agregue los elementos al final. Las listas no deben compartir espacios en memoria (si
        quito un elemento de una no debe afectar a la otra) 
    */
    // ==================================== a ====================================
    public void agregarInicio(int dato){
        inicio = new NodoInt(dato, inicio);
        this.cantidad++;
        if (this.fin == null) {
            this.fin = inicio;
        }
    }
    // ==================================== b ====================================
    //pre: n <= cantidad
    public void mostrar(int n){
        mostrarRecursivo(inicio, n);
    }
    private void mostrarRecursivo(NodoInt nodo, int n) {
        // Caso base: Si n es 0 o el nodo es null, se detiene la recursión
        if (n == 0 || nodo == null) {
            return;
        }
        // Imprimir el dato del nodo actual
        System.out.println(nodo.getDato());
        mostrarRecursivo(nodo.getSig(), n - 1);
    }
    // ==================================== c ====================================
    public ListaSimple obtenerInvertida(){
        ListaSimple listaInvertida = new ListaSimple();
        NodoInt actual = inicio;
        
        // Recorrer la lista original y agregar cada elemento al inicio de la nueva lista
        while (actual != null) {
            listaInvertida.agregarInicio(actual.getDato()); 
            actual = actual.getSig();
        }
        return listaInvertida;
    }
    // ==================================== d ====================================
    public void concatenar(ListaSimple lista){
        NodoInt actual = lista.inicio;
        while (actual != null) {
            this.agregarAlFinal(actual.getDato());
            actual = actual.getSig();
        }
    }
    
    // Método para agregar un elemento al final de la lista
    public void agregarAlFinal(int dato) {
    NodoInt nuevo = new NodoInt(dato);
        if (estaVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSig(nuevo);
            fin = nuevo;
        }
        cantidad++;
    }
    
    // Método para verificar si la lista está vacía
    public boolean estaVacia() {
        return inicio == null;
    }
    
    //==========================================================================================
    // Examen 2024-05-10
    //==========================================================================================
    /*
    Dada la siguiente lista simplemente enlazada y ordenada:
        L -> 17 -> 25 -> 32 -> 43 -> 54 -> 69 ->
    a.  Implemente un algoritmo recursivo que muestre los últimos n elementos impares de la lista
        Ejemplo: para la lista anterior y un n = 2, el resultado sería: 69 43
    b.  Realice el diagrama de llamadas para el ejemplo anterior
    */
    public void mostrarUltimosNImpares (ListaSimple L, int n){
        //int totalNodosImpares = contarTotalNodosImpares(L.getInicio())
        //mostrarUltimosNImpares (L.getInicio(), totalNodosImpares - n);
    }
    
    public void mostrarUltimosNImpares(NodoInt n, int pos) {
        if (n != null) {
            if (n.getDato() % 2 != 0) {
                if (pos <= 0) {
                    mostrarUltimosNImpares(n.getSig(), pos - 1);
                    System.out.println(n.getDato());
                } else {
                    mostrarUltimosNImpares(n.getSig(), pos - 1);
                }
            } else {
                mostrarUltimosNImpares(n.getSig(), pos);
            }
        }
    }
    
    /*
    Diagrama de llamadas
    mostrarUltimosNImpares (Nodo(17), 2)
        mostrarUltimosNImpares (Nodo(25), 1)
            mostrarUltimosNImpares (Nodo(32), 0)
                mostrarUltimosNImpares (Nodo(43), 0)
                    mostrarUltimosNImpares (Nodo(54), -1)
                        mostrarUltimosNImpares (Nodo(69), -1)
                            mostrarUltimosNImpares (Nodo(null), -2)
                            FIN
                        SOUT(69)
                        FIN
                    FIN
                SOUT(43)
                FIN
            FIN
        FIN
    FIN
    */
    
    /*
    a.  Realizar un algoritmo, que reciba 2 listas simplemente encadenadas ordenadas en
        forma ascendente y retorne una lista ordenada L3 ascendente que contenga los
        elementos de L1 y L2:
        L1: 1 – 5 – 16 – 34
        L2: 3 – 4 – 35 – 37 – 44
        L3: 1 – 3 – 4 – 5 – 16 – 34 – 35 – 37 – 44 
    b.  Realizar un algoritmo de búsqueda eficiente que, dada la lista retornada en el punto 1
        (enlazada y ordenada en forma ascendente), busque un número en la lista y retorne un
        valor booleano indicando si lo encuentra o no.
    c.  Realizar un algoritmo – eficiente - que reciba las listas L1 y L2 de la parte a) y retorne la
        siguiente Pila apilada de menor a mayor según figura: 
            44
            37
            35
            34
            16
            5
            4
            3
            1
        Se disponen de las estructuras vistas en clase (Pila) con los métodos básicos vistos de
        dichas estructuras (esVacia(),top(), desapilar(), apila(elemento),etc.). En caso de necesitar
        alguna otra estructura (ej. Cola), se deberán implementar sus operaciones.
    */
    // ==================================== a ====================================
    public ListaSimple encadenarListas(ListaSimple l1, ListaSimple l2) {
        ListaSimple l3 = new ListaSimple();
        NodoInt nodoL1 = l1.inicio;
        NodoInt nodoL2 = l2.inicio;
        while (nodoL1 != null || nodoL2 != null) {
            if (nodoL1 != null && nodoL2 != null) {
                if (nodoL1.getDato() <= nodoL2.getDato()) {
                    l3.agregarFinal(nodoL1.getDato());
                    nodoL1 = nodoL1.getSig();
                } else {
                    l3.agregarFinal(nodoL2.getDato());
                    nodoL2 = nodoL2.getSig();
                }
            } else {
                if (nodoL1 != null) {
                    l3.agregarFinal(nodoL1.getDato());
                    nodoL1 = nodoL1.getSig();
                } else {
                    l3.agregarFinal(nodoL2.getDato());
                    nodoL2 = nodoL2.getSig();
                }
            }
            return l3;
        } 
        return null;
    }
    
    public void agregarFinal(int dato) {
        if (estaVacia()) {
            agregarInicio(dato);
        } else {
            NodoInt nuevo = new NodoInt(dato);
            this.fin.setSig(nuevo);
            this.fin = nuevo;
            this.cantidad++;
        }
    }
    // ==================================== b ====================================
    public boolean buscar(ListaSimple l3, int numero) {
        boolean esta = false;
        NodoInt aux = l3.inicio;
        while (aux != null && !esta) {
            if (aux.getDato() == numero) {
                esta = true;
            }
            aux = aux.getSig();
        }
        return esta;
    }
    // ==================================== c ====================================
    public Pila encadenarListasEnPila(ListaSimple l1, ListaSimple l2) {
        Pila p = new Pila();
        NodoInt nodoL1 = l1.inicio;
        NodoInt nodoL2 = l2.inicio;
        while (nodoL1 != null || nodoL2 != null) {
            if (nodoL1 != null && nodoL2 != null) {
                if (nodoL1.getDato() <= nodoL2.getDato()) {
                    p.push(nodoL1.getDato());
                    nodoL1 = nodoL1.getSig();
                } else {
                    p.push(nodoL2.getDato());
                    nodoL2 = nodoL2.getSig();
                }
            } else {
                if (nodoL1 != null) {
                    p.push(nodoL1.getDato());
                    nodoL1 = nodoL1.getSig();
                } else {
                    p.push(nodoL2.getDato());
                    nodoL2 = nodoL2.getSig();
                }
            }
            return p;
        }
        return null;
    }
}