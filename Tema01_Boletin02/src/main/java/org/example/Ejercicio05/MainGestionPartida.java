package org.example.Ejercicio05;

import java.io.IOException;

public class MainGestionPartida {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String archivo = "partida.data";

        char[][] tablero = {
                {'X', 'O', ' '},
                {' ', 'X', ' '},
                {'O', ' ', ' '}
        };
        char jugadorActual = 'O';
        int puntuacionX = 2;
        int puntuacionO = 1;


        GestionPartida partida = new GestionPartida(tablero, jugadorActual, puntuacionX, puntuacionO);
        GameStorage.guardar(partida, archivo);

        GestionPartida partidaRecuperada = GameStorage.cargar("partida.data");
        System.out.println(partidaRecuperada.toString());

    }
}
