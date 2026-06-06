package EstructurasBase;

public class Pila<T> {
    private Nodo<T> tope;
    private int cantidad;

    public Pila() {
        this.tope = null;
        this.cantidad = 0;
    }

    public void apilar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (!estaVacia()) {
            nuevoNodo.siguiente = tope;
        }

        tope = nuevoNodo;
        cantidad++;
    }

    public T desapilar() {
        if (estaVacia()) {
            System.out.println("La pila está vacía, no hay acciones para deshacer.");
            return null;
        }

        T datoSalida = tope.dato;
        tope = tope.siguiente;
        cantidad--;

        return datoSalida;
    }

    public T verTope() {
        if (estaVacia()) {
            return null;
        }
        return tope.dato;
    }


    public boolean estaVacia() {
        return tope == null;
    }


    public int tamano() {
        return cantidad;
    }
}

