package org.example.Ejercicio03;

import org.example.Ejercicio01.Parses;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            Libro[] libros = Parses.parseBiblioteca();
            Set<String> generos = new HashSet<>();
            Map<String, Integer> contadorGenero = new HashMap<>();
            System.out.println("Titulos: ");
            for (Libro libro : libros) {
                for (String genero : libro.getGeneros()){
                    generos.add(genero);
                    // Obtengo el valor actual y lo incremento en 1(Si no es 1);
                    Integer actual = contadorGenero.get(genero);
                    int nuevo;
                    if (actual == null){nuevo = 1;}
                    else {nuevo = actual + 1;}
                    contadorGenero.put(genero, nuevo);
                }
                System.out.println(libro.getTitulo());
            }
                System.out.println(contadorGenero);
    } catch (Exception e){
        e.printStackTrace();
        }
    }
}
