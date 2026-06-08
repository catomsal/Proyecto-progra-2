import Clases.Movimiento;
import Clases.ServicioTrazabilidad;


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



    }



}
