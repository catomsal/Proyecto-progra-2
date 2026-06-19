package Clases;
import EstructurasBase.ColaConPrioridad;
import EstructurasBase.Elemento;

public class inventarioCritico {
    private ColaConPrioridad<Producto> colaCriticos;
    private int capacidad;

    public inventarioCritico(int capacidad) {
        this.capacidad = capacidad;
        this.colaCriticos = new ColaConPrioridad<>(capacidad);
    }

    //hacemos la cola a partir de lo que hay en el inventario en el momento
    public void construirCola(inventarioProductos inventario) {
        colaCriticos = new ColaConPrioridad<>(capacidad);
        Producto[] productos = inventario.getProductos();
        for (int i = 0; i < productos.length; i++) {
            colaCriticos.encolar(productos[i], productos[i].getStockActual());
        }
        System.out.println("Cola de prioridad construida con " + productos.length + " productos.");
    }

    //devuelve el mas critico(el q menor stock tiene)
    public Producto consultarMasCritico() {
        if (colaCriticos.estaVacia()) {
            System.out.println("No hay productos en la cola de prioridad.");
            return null;
        }
        Elemento<Producto> frente = colaCriticos.recuperarFrente();
        System.out.println("Producto mas critico: " + frente.dato.getNombre() +
                " [" + frente.dato.getCodigo() + "]" +
                " - Stock: " + frente.dato.getStockActual());
        return frente.dato;
    }

    //mostramos la cola, ordenada con prioridad a los q se consideran críticos primero
    public void mostrarPorPrioridad() {
        if (colaCriticos.estaVacia()) {
            System.out.println("La cola de prioridad esta vacia.");
            return;
        }
        System.out.println("PRODUCTOS POR NIVEL DE STOCK (menor a mayor) ");
        colaCriticos.mostrarCola();
        System.out.println("====================================================");
    }

    public boolean estaVacia() {
        return colaCriticos.estaVacia();
    }

}
