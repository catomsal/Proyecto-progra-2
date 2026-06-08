package Clases;

public class Producto {

    private String codigo;
    private String nombre;
    private int stockActual;
    private int stockMinimo;
    private Ubicacion ubicacion;

    public Producto(String codigo, String nombre, int stockActual, int stockMinimo, Ubicacion ubicacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.ubicacion = ubicacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    // Devuelve true si el stock esta en nivel critico
    public boolean esCritico() {
        return stockActual <= stockMinimo;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", stock=" + stockActual +
                ", stockMinimo=" + stockMinimo +
                ", ubicacion=" + ubicacion +
                '}';
    }
}