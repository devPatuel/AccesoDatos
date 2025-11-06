package org.example.Ejercicio01;

/**
 *  * Clase que representa un empleado.
 */
public class Empleado {

    private String id;
    private String nombre;
    private Double salario;
    private String departamento;
    private String fechaAlta;

    /**
     * Constructor de la clase Empleado.
     * @param id Parámetro que representa el ID del empleado.
     * @param nombre El nombre del empleado.
     * @param salario El salario del empleado.
     */
    public Empleado(String id, String nombre, Double salario) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
    }

    /**
     * Constructor de la clase Empleado .
     * @param id Parámetro que representa el ID del empleado.
     * @param nombre El nombre del empleado.
     * @param salario El salario del empleado.
     * @param departamento El departamento del empleado.
     * @param fechaAlta La fecha de alta del empleado.
     */
    public Empleado(String id, String nombre, Double salario, String departamento, String fechaAlta) {
        this(id, nombre, salario);
        this.departamento = departamento;
        this.fechaAlta = fechaAlta;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", salario=" + salario +
                ", departamento='" + departamento + '\'' +
                ", fechaAlta='" + fechaAlta + '\'' +
                '}';
    }

}
