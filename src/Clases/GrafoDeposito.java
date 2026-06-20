package Clases;

// representa el mapa del deposito, conecta pasillos entre si
// y calcula la ruta mas corta entre dos pasillos usando dijkstra

public class GrafoDeposito {

    private Pasillo[] pasillos;
    private int cantidad;
    private int capacidad;

    public GrafoDeposito(int capacidad) {
        this.capacidad = capacidad;
        this.pasillos = new Pasillo[capacidad];
        this.cantidad = 0;
    }

    public void agregarPasillo(Pasillo pasillo) {
        if (cantidad >= capacidad) {
            System.out.println("No se pueden agregar mas pasillos al deposito.");
            return;
        }
        if (buscarPasillo(pasillo.getId()) != null) {
            System.out.println("Ya existe un pasillo con id " + pasillo.getId());
            return;
        }
        pasillos[cantidad] = pasillo;
        cantidad++;
        System.out.println("Pasillo agregado: " + pasillo.getId());
    }

    // conecta dos pasillos con una distancia, como es no dirigido se agrega en los dos sentidos
    public void conectar(String idA, String idB, int distancia) {
        Pasillo a = buscarPasillo(idA);
        Pasillo b = buscarPasillo(idB);
        if (a == null || b == null) {
            System.out.println("No se pudo conectar, uno de los pasillos no existe.");
            return;
        }
        a.agregarConexion(b, distancia);
        b.agregarConexion(a, distancia);
        System.out.println("Conectado " + idA + " <-> " + idB + " (distancia " + distancia + ")");
    }

    public Pasillo buscarPasillo(String id) {
        for (int i = 0; i < cantidad; i++) {
            if (pasillos[i].getId().equals(id)) {
                return pasillos[i];
            }
        }
        return null;
    }

    private int indiceDe(Pasillo p) {
        for (int i = 0; i < cantidad; i++) {
            if (pasillos[i].equals(p)) {
                return i;
            }
        }
        return -1;
    }

    // dijkstra: calcula la distancia minima desde el origen a cada pasillo
    // y va guardando por donde se llego para despues reconstruir el camino
    public int[] dijkstra(String idOrigen, Pasillo[] previos) {
        int[] distancias = new int[cantidad];
        boolean[] visitados = new boolean[cantidad];
        int infinito = Integer.MAX_VALUE;

        for (int i = 0; i < cantidad; i++) {
            distancias[i] = infinito;
            previos[i] = null;
        }

        Pasillo origen = buscarPasillo(idOrigen);
        if (origen == null) {
            System.out.println("El pasillo de origen no existe: " + idOrigen);
            return distancias;
        }

        distancias[indiceDe(origen)] = 0;

        for (int iteracion = 0; iteracion < cantidad; iteracion++) {
            // buscamos el pasillo no visitado con menor distancia
            int indiceActual = -1;
            int menorDistancia = infinito;
            for (int i = 0; i < cantidad; i++) {
                if (!visitados[i] && distancias[i] < menorDistancia) {
                    menorDistancia = distancias[i];
                    indiceActual = i;
                }
            }

            if (indiceActual == -1) {
                break; // ya no quedan pasillos alcanzables
            }

            visitados[indiceActual] = true;
            Pasillo actual = pasillos[indiceActual];

            // relajamos las conexiones del pasillo actual
            Arista[] conexiones = actual.getConexiones();
            for (int i = 0; i < conexiones.length; i++) {
                Pasillo vecino = conexiones[i].getDestino();
                int indiceVecino = indiceDe(vecino);
                if (indiceVecino == -1 || visitados[indiceVecino]) {
                    continue;
                }
                int distanciaNueva = distancias[indiceActual] + conexiones[i].getDistancia();
                if (distanciaNueva < distancias[indiceVecino]) {
                    distancias[indiceVecino] = distanciaNueva;
                    previos[indiceVecino] = actual;
                }
            }
        }

        return distancias;
    }

    // devuelve la ruta mas corta entre dos pasillos como una lista de ids, en orden
    public String[] rutaMinima(String idOrigen, String idDestino) {
        Pasillo destino = buscarPasillo(idDestino);
        if (destino == null) {
            System.out.println("El pasillo de destino no existe: " + idDestino);
            return new String[0];
        }

        Pasillo[] previos = new Pasillo[cantidad];
        int[] distancias = dijkstra(idOrigen, previos);

        int indiceDestino = indiceDe(destino);
        if (indiceDestino == -1 || distancias[indiceDestino] == Integer.MAX_VALUE) {
            System.out.println("No existe un camino entre " + idOrigen + " y " + idDestino);
            return new String[0];
        }

        // reconstruimos el camino de atras para adelante siguiendo los previos
        String[] caminoInverso = new String[cantidad];
        int cantidadPasos = 0;
        Pasillo actual = destino;

        while (actual != null) {
            caminoInverso[cantidadPasos] = actual.getId();
            cantidadPasos++;
            if (actual.getId().equals(idOrigen)) {
                break;
            }
            actual = previos[indiceDe(actual)];
        }

        // damos vuelta el arreglo para que quede origen -> destino
        String[] camino = new String[cantidadPasos];
        for (int i = 0; i < cantidadPasos; i++) {
            camino[i] = caminoInverso[cantidadPasos - 1 - i];
        }

        System.out.println("Distancia total: " + distancias[indiceDestino]);
        return camino;
    }

    public void mostrarRuta(String idOrigen, String idDestino) {
        String[] ruta = rutaMinima(idOrigen, idDestino);
        if (ruta.length == 0) {
            return;
        }
        System.out.print("Ruta optima: ");
        for (int i = 0; i < ruta.length; i++) {
            System.out.print(ruta[i]);
            if (i < ruta.length - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}