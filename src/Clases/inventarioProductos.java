package Clases;

public class inventarioProductos {

    private Producto[] productos;
    private int cantidad;
    private int capacidad;

    public inventarioProductos(int capacidad) {
        this.capacidad = capacidad;
        this.productos = new Producto[capacidad];
        this.cantidad = 0;
    }

    public boolean agregar(Producto p) {
        if (cantidad >= capacidad) {
            System.out.println("Error: inventario lleno, no se puede agregar " + p.getCodigo());
            return false;
        }
        if (buscar(p.getCodigo()) != null) {
            System.out.println("Error: ya existe un producto con el codigo " + p.getCodigo());
            return false;
        }
        productos[cantidad] = p;
        cantidad++;
        System.out.println("Producto agregado: " + p.getNombre() + " [" + p.getCodigo() + "]");
        return true;
    }
    public Producto buscar(String codigo) {
        for (int i = 0; i < cantidad; i++) {
            if (productos[i].getCodigo().equals(codigo)) {
                return productos[i];
            }
        }
        return null;
    }
    public boolean eliminar(String codigo) {
        for (int i = 0; i < cantidad; i++) {
            if (productos[i].getCodigo().equals(codigo)) {
                for (int j = i; j < cantidad - 1; j++) {
                    productos[j] = productos[j + 1];
                }
                productos[cantidad - 1] = null;
                cantidad--;
                System.out.println("Producto eliminado: " + codigo);
                return true;
            }
        }
        System.out.println("No se encontro el producto con codigo: " + codigo);
        return false;
    }

      public boolean actualizarStock(String codigo, int delta) {
        Producto p = buscar(codigo);
        if (p == null) {
            System.out.println("No se encontro el producto con codigo: " + codigo);
            return false;
        }
        int stockNuevo = p.getStockActual() + delta;
        if (stockNuevo < 0) {
            System.out.println("Error: el stock no puede quedar negativo.");
            return false;
        }
        p.setStockActual(stockNuevo);
        System.out.println("Stock actualizado: " + p.getNombre() + " -> " + stockNuevo + " unidades");
        return true;
    }

    public boolean contiene(String codigo) {
        return buscar(codigo) != null;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void listar() {
        if (cantidad == 0) {
            System.out.println("El inventario esta vacio.");
            return;
        }
        System.out.println("=== INVENTARIO ===");
        for (int i = 0; i < cantidad; i++) {
            System.out.println("  " + productos[i]);
            if (productos[i].esCritico()) {
                System.out.println("  *** STOCK CRITICO - REQUIERE REPOSICION ***");
            }
        }
        System.out.println("==================");
    }

    //nos devuelve una copia de todos los productos q hay en el momento
    //nos sirve para la  cola de inventario critico

    public Producto[] getProductos() {
        Producto[] copia = new Producto[cantidad];
        for (int i = 0; i < cantidad; i++) {
            copia[i] = productos[i];
        }
        return copia;
    }
}