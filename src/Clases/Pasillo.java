package Clases;

public class Pasillo {

    private String id;
    private String descripcion;
    
    // Lista de conexiones adyacentes
    private Arista[] conexiones;
    private int cantidadConexiones;
    private static final int MAX_CONEXIONES = 10;

    public Pasillo(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.conexiones = new Arista[MAX_CONEXIONES];
        this.cantidadConexiones = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Metodos solicitados en el issue
    public void agregarConexion(Pasillo destino, int distancia) {
        if (cantidadConexiones < MAX_CONEXIONES) {
            conexiones[cantidadConexiones] = new Arista(destino, distancia);
            cantidadConexiones++;
        } else {
            System.out.println("No se pueden agregar más conexiones al pasillo " + id);
        }
    }

    public Arista[] getConexiones() {
        // Devolvemos solo la porción válida del arreglo para no mandar nulls
        Arista[] validas = new Arista[cantidadConexiones];
        System.arraycopy(conexiones, 0, validas, 0, cantidadConexiones);
        return validas;
    }

    @Override
    public String toString() {
        return "Pasillo{" +
                "id='" + id + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pasillo pasillo = (Pasillo) o;

        return id != null ? id.equals(pasillo.id) : pasillo.id == null;
    }
}
