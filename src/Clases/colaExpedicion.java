package Clases;

import EstructurasBase.Cola;

public class colaExpedicion {

    private Cola<Pedido> cola;

    public colaExpedicion() {
        this.cola = new Cola<>();
    }

    // Agrega un pedido al final de la fila
    public void encolar(Pedido pedido) {
        if (pedido == null) {
            System.out.println("Error: no se puede encolar un pedido nulo.");
            return;
        }
        cola.encolar(pedido);
        System.out.println("Pedido en fila: " + pedido.getIdPedido());
    }

    // Saca el primer pedido de la fila y lo marca como despachado
    public Pedido despachar() {
        if (cola.estaVacia()) {
            System.out.println("No hay pedidos esperando despacho.");
            return null;
        }
        Pedido pedido = cola.desencolar();
        pedido.marcarDespachado();
        System.out.println("Pedido despachado: " + pedido.getIdPedido());
        return pedido;
    }

    // Mira el primer pedido sin sacarlo de la fila
    public Pedido verSiguiente() {
        if (cola.estaVacia()) {
            System.out.println("La fila esta vacia.");
            return null;
        }
        return cola.RecuperarFrente();
    }

    public boolean estaVacia() {
        return cola.estaVacia();
    }

    public int cantidadPedidos() {
        return cola.tamano();
    }

    public void mostrarFila() {
        if (cola.estaVacia()) {
            System.out.println("No hay pedidos en la fila.");
            return;
        }
        System.out.println("Pedidos esperando despacho: " + cola.tamano());
        // Usamos una cola auxiliar para mostrar sin destruir la original
        Cola<Pedido> aux = new Cola<>();
        int orden = 1;
        while (!cola.estaVacia()) {
            Pedido p = cola.desencolar();
            System.out.println("  " + orden + ". " + p);
            aux.encolar(p);
            orden++;
        }
        // Restauramos la cola
        while (!aux.estaVacia()) {
            cola.encolar(aux.desencolar());
        }
    }
}