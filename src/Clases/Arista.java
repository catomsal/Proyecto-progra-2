package Clases;

public class Arista {

    private Pasillo destino;
    private int distancia;

    public Arista(Pasillo destino, int distancia) {
        this.destino = destino;
        this.distancia = distancia;
    }

    public Pasillo getDestino() {
        return destino;
    }

    public void setDestino(Pasillo destino) {
        this.destino = destino;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "Conexion a " + destino.getId() + " (Distancia: " + distancia + ")";
    }

}
