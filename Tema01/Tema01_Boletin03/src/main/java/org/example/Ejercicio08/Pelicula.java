package org.example.Ejercicio08;

import java.util.Arrays;
import java.util.Objects;

public class Pelicula {
    private String id;
    private String titulo;
    private String director;
    private int estreno;
    private int duracionMin;
    private String[] generos;
    private Puntuacion puntuaciones;

    public Pelicula(String id, String titulo, String director, int estreno, int duracionMin, String[] generos, Puntuacion puntuaciones) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.estreno = estreno;
        this.duracionMin = duracionMin;
        this.generos = generos;
        this.puntuaciones = puntuaciones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getEstreno() {
        return estreno;
    }

    public void setEstreno(int estreno) {
        this.estreno = estreno;
    }

    public int getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(int duracionMin) {
        this.duracionMin = duracionMin;
    }

    public String[] getGeneros() {
        return generos;
    }

    public void setGeneros(String[] generos) {
        this.generos = generos;
    }

    public Puntuacion getPuntuaciones() {
        return puntuaciones;
    }

    public void setPuntuaciones(Puntuacion puntuaciones) {
        this.puntuaciones = puntuaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return estreno == pelicula.estreno && duracionMin == pelicula.duracionMin && Objects.equals(id, pelicula.id) && Objects.equals(titulo, pelicula.titulo) && Objects.equals(director, pelicula.director) && Objects.deepEquals(generos, pelicula.generos) && Objects.equals(puntuaciones, pelicula.puntuaciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, director, estreno, duracionMin, Arrays.hashCode(generos), puntuaciones);
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", director='" + director + '\'' +
                ", estreno=" + estreno +
                ", duracionMin=" + duracionMin +
                ", generos=" + Arrays.toString(generos) +
                ", puntuaciones=" + puntuaciones +
                '}';
    }
}
