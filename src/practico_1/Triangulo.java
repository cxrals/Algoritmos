package practico_1;

public class Triangulo {
    private int a;
    private int b;
    private int c;

    public Triangulo(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
    
    public boolean esIsosceles() {
        return a == b || b == c || a == c;
    }
    
    public boolean esEscaleno() {
        return a != b && b != c && a != c;
    }
    
    public boolean esEquilatero() {
        return a == b && b == c;
    }
}
