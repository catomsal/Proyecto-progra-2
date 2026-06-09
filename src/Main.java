import Clases.*;

public class Main {

    public static void main(String[] args) {
        ServicioTrazabilidad trazabilidad = new ServicioTrazabilidad();

        System.out.println("pruebo historial");

        // metemos movimientos a la pila
        trazabilidad.registrarMovimiento("PROD-001", "ENTRADA", 0, 50);
        trazabilidad.registrarMovimiento("PROD-002", "ENTRADA", 0, 30);
        trazabilidad.registrarMovimiento("PROD-001", "SALIDA", 50, 40);
        trazabilidad.registrarMovimiento("PROD-002", "REPOSICION", 30, 60);

        System.out.println("--- Historial completo ---");
        trazabilidad.mostrarHistorial();

        System.out.println("--- Último movimiento ---");
        trazabilidad.consultarUltimoMovimiento();

        System.out.println("--- Deshacemos el último movimiento (error del operario) ---");
        Movimiento revertido = trazabilidad.deshacerUltimoMovimiento();

        System.out.println("--- Historial tras deshacer ---");
        trazabilidad.mostrarHistorial();

        System.out.println("--- Casos límite ---");

        // tipo inválido
        trazabilidad.registrarMovimiento("PROD-001", "TRANSFERENCIA", 10, 20);

        //id vacío
        trazabilidad.registrarMovimiento("", "ENTRADA", 0, 10);

        // cantidad negativa
        trazabilidad.registrarMovimiento("PROD-003", "SALIDA", -5, 10);

        // deshacer hasta vaciar
        trazabilidad.deshacerUltimoMovimiento();
        trazabilidad.deshacerUltimoMovimiento();
        trazabilidad.deshacerUltimoMovimiento();
        trazabilidad.deshacerUltimoMovimiento(); // pila ya vacía


        // pruebo inventario
        System.out.println("\npruebo inventario");

        inventarioProductos inventario = new inventarioProductos(10);

        inventario.agregar(new Producto("TOR-001", "Tornillos 5mm", 50, 10, new Ubicacion("A", 1, 2)));
        inventario.agregar(new Producto("CLA-002", "Clavos 3cm",    8,  10, new Ubicacion("A", 2, 1)));
        inventario.agregar(new Producto("TUE-003", "Tuercas M8",    30, 5,  new Ubicacion("B", 1, 3)));

        // codigo duplicado
        inventario.agregar(new Producto("TOR-001", "Duplicado", 5, 1, new Ubicacion("C", 1, 1)));

        inventario.listar();

        System.out.println("busco TUE-003: " + inventario.buscar("TUE-003"));
        System.out.println("busco XYZ-999 (no existe): " + inventario.buscar("XYZ-999"));


        // pruebo cola de expedicion
        System.out.println("\npruebo cola de expedicion");

        colaExpedicion expedicion = new colaExpedicion();

        expedicion.encolar(new Pedido("PED-001", new String[]{"TOR-001", "TUE-003"}));
        expedicion.encolar(new Pedido("PED-002", new String[]{"CLA-002"}));
        expedicion.encolar(new Pedido("PED-003", new String[]{"TOR-001", "CLA-002"}));

        expedicion.mostrarFila();

        expedicion.despachar();
        expedicion.despachar();

        System.out.println("fila despues de despachar 2:");
        expedicion.mostrarFila();

        // cola vacia
        expedicion.despachar();
        expedicion.despachar();
    }
}