package org.example.Ejercicio07;

import java.util.Objects;

/**
 * Clase que representa la ubicación de un producto en el inventario.
 */
public class Ubicacion {
    private int pasillo;
    private String estante;

    /**
     * Constructor de la clase Ubicacion.
     * @param pasillo El número de pasillo donde se encuentra el producto.
     * @param estante  El estante donde se encuentra el producto.
     */
    public Ubicacion(int pasillo, String estante) {
        this.pasillo = pasillo;
        this.estante = estante;
    }

    public int getPasillo() {
        return pasillo;
    }

    public void setPasillo(int pasillo) {
        this.pasillo = pasillo;
    }

    public String getEstante() {
        return estante;
    }

    public void setEstante(String estante) {
        this.estante = estante;
    }

    @Override
    public String toString() {
        return "Ubicacion{" +
                "pasillo=" + pasillo +
                ", estante='" + estante + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ubicacion ubicacion = (Ubicacion) o;
        return pasillo == ubicacion.pasillo && Objects.equals(estante, ubicacion.estante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pasillo, estante);
    }
}
