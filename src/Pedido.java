public class Pedido {

    private String id;
    private String nombre;
    private int stockActual;
    private int stockMinimo;


    public Pedido(String nombre, String id, int stockActual, int stockMinimo) {
        this.nombre = nombre;
        this.id = id;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public boolean esCritico() {
        return stockMinimo >= (stockActual);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", stockActual=" + stockActual +
                ", stockMinimo=" + stockMinimo +
                '}';
    }
}