package Clases;

import EstructurasBase.Pila;

public class ServicioTrazabilidad {

    private Pila<Movimiento> historial;

    public ServicioTrazabilidad() {
        this.historial = new Pila<>();
    }

    // registramos nuevo movimiento y lo apila
    public void registrarMovimiento(String idProducto, String tipo, int cantidadAnterior, int cantidadNueva) {
        if (idProducto == null || idProducto.isEmpty()) {
            System.out.println("Error: el ID del producto no puede estar vacío.");
            return;
        }

        String tipoUpper = tipo.toUpperCase();
        if (!tipoUpper.equals("ENTRADA") && !tipoUpper.equals("SALIDA") && !tipoUpper.equals("REPOSICION")) {
            System.out.println("Error: tipo de movimiento inválido. Use ENTRADA, SALIDA o REPOSICION.");
            return;
        }

        if (cantidadAnterior < 0 || cantidadNueva < 0) {
            System.out.println("Error: las cantidades no pueden ser negativas.");
            return;
        }

        Movimiento movimiento = new Movimiento(idProducto, tipoUpper, cantidadAnterior, cantidadNueva);
        historial.apilar(movimiento);
        System.out.println("Movimiento registrado: " + movimiento);
    }

    // deshacemos ultimo movimiento registrado y devuelve el movimiento revertido
    public Movimiento deshacerUltimoMovimiento() {
        if (historial.estaVacia()) {
            System.out.println("No hay movimientos para deshacer.");
            return null;
        }

        Movimiento ultimo = historial.desapilar();
        System.out.println("Movimiento revertido: " + ultimo);
        System.out.println("Stock de '" + ultimo.getIdProducto() +
                "' restaurado a: " + ultimo.getCantidadAnterior());
        return ultimo;
    }

    // mostramos ultimo movimiento sin desapilarlo
    public void consultarUltimoMovimiento() {
        if (historial.estaVacia()) {
            System.out.println("No hay movimientos registrados.");
            return;
        }
        System.out.println("Último movimiento: " + historial.verTope());
    }

    //mostramos el hist
    public void mostrarHistorial() {
        if (historial.estaVacia()) {
            System.out.println("Historial vacío.");
            return;
        }

        System.out.println("Historial de movimientos (más reciente primero)");
        Pila<Movimiento> aux = new Pila<>();
        int orden = 1;

        // desapilamos para mostrar y guardamos en aux para restaurar
        while (!historial.estaVacia()) {
            Movimiento m = historial.desapilar();
            System.out.println(orden + ". " + m);
            aux.apilar(m);
            orden++;
        }

        //recuperamos el historial q perdimos
        while (!aux.estaVacia()) {
            historial.apilar(aux.desapilar());
        }
        System.out.println("-------------------------------------------------------------");
    }

    public boolean estaVacio() {
        return historial.estaVacia();
    }

    public int cantidadMovimientos() {
        return historial.tamano();
    }
}