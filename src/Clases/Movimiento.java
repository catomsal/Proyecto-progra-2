package Clases;

public class Movimiento {

    private String idProducto;
    private String tipo;           // para entrada salida y repo
    private int cantidadAnterior;
    private int cantidadNueva;
    private long timestamp;

    public Movimiento(String idProducto, String tipo, int cantidadAnterior, int cantidadNueva) {
        this.idProducto = idProducto;
        this.tipo = tipo.toUpperCase();
        this.cantidadAnterior = cantidadAnterior;
        this.cantidadNueva = cantidadNueva;
        this.timestamp = System.currentTimeMillis();
    }

    public String getIdProducto() {
        return idProducto;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidadAnterior() {
        return cantidadAnterior;
    }

    public int getCantidadNueva() {
        return cantidadNueva;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "[" + tipo + "] Producto: " + idProducto +
                " | Stock: " + cantidadAnterior + " -> " + cantidadNueva +
                " | Timestamp: " + timestamp;
    }
}