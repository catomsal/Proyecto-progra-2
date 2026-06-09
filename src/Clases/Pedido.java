package Clases;

// Representa un pedido listo para ser cargado en el camion de reparto.

public class Pedido {

    private String idPedido;
    private String[] codigosProductos;
    private int cantidadItems;
    private String estado; // LISTO o DESPACHADO
    private long timestamp;

    public Pedido(String idPedido, String[] codigosProductos) {
        this.idPedido = idPedido;
        this.codigosProductos = codigosProductos;
        this.cantidadItems = codigosProductos.length;
        this.estado = "LISTO";
        this.timestamp = System.currentTimeMillis();
    }

    public String getIdPedido() {
        return idPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void marcarDespachado() {
        this.estado = "DESPACHADO";
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido{id='").append(idPedido).append("', estado=").append(estado);
        sb.append(", items=[");
        for (int i = 0; i < cantidadItems; i++) {
            sb.append(codigosProductos[i]);
            if (i < cantidadItems - 1) sb.append(", ");
        }
        sb.append("]}");
        return sb.toString();
    }
}