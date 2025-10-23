package org.example.Ejercicio05;

/**
 * Clase para representar una asignatura.
 */
public class Asignatura {
    private String nombre;
    private double nota;

    /**
     *      * Constructor de la clase Asignatura.
     * @param nombre Nombre de la asignatura.
     * @param nota Nota de la asignatura.
     */
    public Asignatura(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "nombre='" + nombre + '\'' +
                ", nota=" + nota +
                '}';
    }
}
