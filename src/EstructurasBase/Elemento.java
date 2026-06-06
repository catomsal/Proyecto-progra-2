package EstructurasBase;

public class Elemento<T> {
    public T dato;
    public int prioridad;

    public Elemento(T dato, int prioridad) {
        this.dato = dato;
        this.prioridad = prioridad;
    }
}
