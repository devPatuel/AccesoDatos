package org.example.Ejercicio03;

import java.util.List;
import java.util.Objects;

/**
 * Clase que representa un libro.
 */
public class Libro {
    private String titulo;
    private List<String> generos;

    /**
     * Constructor de la clase Libro.
      * @param titulo El título del libro.
     * @param generos La lista de géneros del libro.
     */
    public Libro( String titulo, List<String> generos) {
        this.generos = generos;
        this.titulo = titulo;
    }

    public List<String> getGeneros() {
        return generos;
    }
    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", generos=" + generos.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(titulo, libro.titulo) && Objects.equals(generos, libro.generos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, generos);
    }
}
