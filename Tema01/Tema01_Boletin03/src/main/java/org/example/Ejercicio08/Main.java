package org.example.Ejercicio08;

import org.example.Ejercicio05.ParsesJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            Pelicula[] peliculas =ParsesJson.parsearPeliculas();
            if (peliculas != null) {
                double media = 0;
                List<Pelicula> listaPeliculas = new ArrayList<>();
                Set<String> listaSetGeneros = new HashSet<>();
                for (Pelicula p : peliculas) {
                    media = p.getPuntuaciones().getMedia();
                    listaPeliculas.add(p);

                    // Orden Alfabetico
                    String[] generos = p.getGeneros();
                    for(String g : generos){
                        listaSetGeneros.add(g);
                    }
                }
                ArrayList<String> generosOrdenados = new ArrayList<>(listaSetGeneros);
                System.out.println("Lista de generos ordenados: " + "\n" + generosOrdenados);

            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }
    }
}
