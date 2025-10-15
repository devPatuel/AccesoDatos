package org.example.Ejercicio05;

import java.io.Serializable;
import java.util.Arrays;

public class GestionPartida implements Serializable {
    private char[][] tablero;
    private char jugadorActual;
    private int puntuacionX;
    private int puntuacionO;


    public GestionPartida(char[][] tablero, char jugadorActual, int puntuacionX, int puntuacionO) {
        this.tablero = tablero;
        this.jugadorActual = jugadorActual;
        this.puntuacionX = puntuacionX;
        this.puntuacionO = puntuacionO;
    }

    public char[][] getTablero() {
        return tablero;
    }

    public char getJugadorActual() {
        return jugadorActual;
    }

    public int getPuntuacionX() {
        return puntuacionX;
    }

    public int getPuntuacionO() {
        return puntuacionO;
    }

    @Override
    public String toString() {
        return "Ejercicio05.GestionPartida{" +
                "tablero=" + Arrays.toString(tablero) +
                ", jugadorActual=" + jugadorActual +
                ", puntuacionX=" + puntuacionX +
                ", puntuacionO=" + puntuacionO +
                '}';
    }
}
