package EstructurasBase;

public class ColaConPrioridad<T> {
    private Elemento<T>[] cola;
    private int max;
    private int cantidad;


    public ColaConPrioridad(int tamanio) {
        this.max = tamanio;
        this.cola = (Elemento<T>[]) new Elemento[max];
        this.cantidad = 0;
    }

    public boolean estaVacia() {
        return cantidad == 0;
    }

    public boolean estaLlena() {
        return cantidad == max;
    }

    public void encolar(T dato, int prioridad) {
        if (estaLlena()) {
            System.out.println("Error: La cola está llena.");
            return;
        }

        Elemento<T> nuevo = new Elemento<>(dato, prioridad);

        if (estaVacia()) {
            cola[0] = nuevo;
        } else {
            int i = cantidad - 1;

            while (i >= 0 && cola[i].prioridad > nuevo.prioridad) {
                cola[i + 1] = cola[i];
                i--;
            }

            cola[i + 1] = nuevo;
        }
        cantidad++;
    }

    public Elemento<T> desencolar() {
        if (estaVacia()) {
            System.out.println("Error: La cola está vacía.");
            return null;
        }

        Elemento<T> eliminado = cola[0];

        for (int i = 0; i < cantidad - 1; i++) {
            cola[i] = cola[i + 1];
        }
        cantidad--;

        return eliminado;
    }

    public Elemento<T> recuperarFrente() {
        if (estaVacia()) {
            return null;
        }
        return cola[0];
    }

    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("Cola vacía.");
            return;
        }
        System.out.print("Estado de la cola: ");
        for (int i = 0; i < cantidad; i++) {
            System.out.print("[" + cola[i].dato.toString() + " (P:" + cola[i].prioridad + ")] ");
        }
        System.out.println();
    }
}

