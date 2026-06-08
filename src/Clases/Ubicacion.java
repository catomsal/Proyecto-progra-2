package Clases;

public class Ubicacion {
    private String pasillo;
    private int estanteria;
    private int nivel;

    public Ubicacion(String pasillo, int estanteria, int nivel) {
        this.pasillo = pasillo;
        this.estanteria = estanteria;
        this.nivel = nivel;
    }

    public String getPasillo() {
        return pasillo;
    }

    public void setPasillo(String pasillo) {
        this.pasillo = pasillo;
    }

    public int getEstanteria() {
        return estanteria;
    }

    public void setEstanteria(int estanteria) {
        this.estanteria = estanteria;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Pasillo " + pasillo + " - Estanteria " + estanteria + " - Nivel " + nivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Ubicacion ubicacion = (Ubicacion) o;
        if (this.estanteria != ubicacion.estanteria) {
            return false;
        }
        if (this.nivel != ubicacion.nivel) {
            return false;
        }
        if (this.pasillo == null) {
            return ubicacion.pasillo == null;
        } else {
            return this.pasillo.equals(ubicacion.pasillo);
        }
    }

    public int generarCodigoUnico() {
        int codigoUnico = 17;
        codigoUnico = 31 * codigoUnico + (pasillo != null ? pasillo.hashCode() : 0);
        codigoUnico = 31 * codigoUnico + estanteria;
        codigoUnico = 31 * codigoUnico + nivel;
        return codigoUnico;
    }
}
