package EstructurasBase;

public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int cantidad;

    public Cola() {
        this.frente = null;
        this.fin = null;
        this.cantidad = 0;
    }

    public void encolar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            frente = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
        }
        fin = nuevoNodo;
        cantidad++;
    }

    public T desencolar() {
        if (estaVacia()) {
            return null;
        }
        T datoSalida = frente.dato;
        frente = frente.siguiente;
        cantidad--;

        if (frente == null) {
            fin = null;
        }
        return datoSalida;
    }


    public T RecuperarFrente() {
        if (estaVacia()) {
            return null;
        }
        return frente.dato;
    }

    public boolean estaVacia() {
        return frente == null;
    }
    public int tamano() {
        return cantidad;
    }
}

