package EstructurasBase;

public class Diccionario  {
    private Dato[] datosDiccionario;
    private int cantidad;
    private int dimension;

    public Diccionario(int dimension) {
        this.dimension = dimension;
        datosDiccionario = new Dato[dimension];
        cantidad = 0;
    }
    public boolean estaVacio() {
        if (cantidad == 0)
            return true;
        else
            return false;
    }

    public boolean insertar(int clave, String valor) {
        if (cantidad + 1 == dimension) {
            System.out.println("Diccionario lleno: Clave no agregada");
            return false;
        }
        if (existe(clave) == -1){
            datosDiccionario[cantidad] = new Dato(clave, valor);
            cantidad++;
            System.out.println("Clave agregada diccionario");
            return true;
        }
        System.out.println("Clave existente --> no agregada al diccionario");
        return false;
    }

    public boolean eliminar(int clave) {
        int posicion = existe(clave);
        if (posicion == -1){
            System.out.println("Clave no eliminada --> no existe");
            return false;
        }
        System.out.println("Clave eliminada del diccionario");
        for (int i = posicion; i < cantidad-1; i++) {
            datosDiccionario[i] = datosDiccionario[i+1];
        }
        cantidad--;
        return true;
    }

    public boolean modificar(int clave, String valor) {
        int posicion = existe(clave);
        if (posicion != -1 ) {
            datosDiccionario[posicion].valor = valor;
            return true;
        }
        return false;
    }

    public String recuperarValor(int clave) {
        int posicion = existe(clave);
        if (posicion != -1 )
            return datosDiccionario[posicion].valor;
        else
            return "No existe la clave --> no hay valor asociado";
    }

    public int existe(int clave) {
        if (estaVacio()) {
            return -1;
        }
        else {
            for (int i = 0; i < cantidad; i++) {
                if (datosDiccionario[i].clave == clave)
                    return i;
            }
        }
        return -1;
    }

    public int tamanio() {
        return cantidad;
    }

    public void listarClaves() {
        System.out.println("Claves de Diccionarios:");
        for (int i = 0; i < cantidad; i++) {
            System.out.print(datosDiccionario[i].clave+" - ");
        }
        System.out.println("-----------------------");

    }

    public void listarValores() {
        System.out.println("Valores de diccionario:");
        for (int i = 0; i < cantidad; i++) {
            System.out.print(datosDiccionario[i].valor+" - ");
        }
        System.out.println("-----------------------");
    }

    public void mostrar() {
        if (!estaVacio()) {
            System.out.println("Diccionario:");
            for (int i = 0; i < cantidad ; i++) {
                System.out.println(datosDiccionario[i].clave + ": " + datosDiccionario[i].valor);
            }
        }
        else
            System.out.println("No existe elementos en el diccionario");
    }


}

