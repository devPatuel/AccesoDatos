package org.example.Ejercicio05;

import java.util.Objects;

/**
 * Clase para representar un alumno.
 */
public class Alumno {
    private String id;
    private String nombre;
    boolean matriculado;
    private String fechaNacimiento;
    private Asignatura[] asignaturas;

    /**
     * Constructor de la clase Alumno.
     * @param id ID del alumno.
     * @param nombre Nombre del alumno.
     * @param matriculado Indica si el alumno está matriculado.
     * @param fechaNacimiento Fecha de nacimiento del alumno.
     * @param asignaturas Lista de asignaturas del alumno.
     */
    public Alumno(String id, String nombre, boolean matriculado, String fechaNacimiento, Asignatura[] asignaturas) {
        this.id = id;
        this.nombre = nombre;
        this.matriculado = matriculado;
        this.fechaNacimiento = fechaNacimiento;
        this.asignaturas = asignaturas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isMatriculado() {
        return matriculado;
    }

    public void setMatriculado(boolean matriculado) {
        this.matriculado = matriculado;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Asignatura[] getAsigantura() {
        return asignaturas;
    }

    public void setAsigantura(Asignatura[] asignaturas) {
        this.asignaturas = asignaturas;
    }

    /**
     * Calcula la nota media del alumno.
     * @return Nota media del alumno.
     */
    public double notaMedia(){
        double sumaNotas = 0;
        for (Asignatura asignatura : asignaturas) {
            sumaNotas += asignatura.getNota();
        }
        return sumaNotas / asignaturas.length;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return matriculado == alumno.matriculado && Objects.equals(id, alumno.id) && Objects.equals(nombre, alumno.nombre) && Objects.equals(fechaNacimiento, alumno.fechaNacimiento) && Objects.equals(asignaturas, alumno.asignaturas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, matriculado, fechaNacimiento, asignaturas);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", matriculado=" + matriculado +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", asignaturas=" + asignaturas.toString() +
                '}';
    }
}
