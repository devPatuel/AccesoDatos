package org.example.Ejercicio05;

import java.io.*;

public class GameStorage {
    /**
     * Guarda una partida en un archivo.
     *
     * @param partida La partida a guardar.
     * @param archivo El nombre del archivo donde se guardará la partida.
     * @throws IOException
     */
    public static void guardar(GestionPartida partida, String archivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(partida);
        }
    }

    public static GestionPartida cargar(String archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (GestionPartida) ois.readObject();
        }
    }
}
