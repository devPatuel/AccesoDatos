package org.example.Ejercicio04;

/**
 * Clase para representar un cliente.
 */
public class Cliente {
    private String nombre;
    private String email;

    /**
     * Constructor de la clase Cliente.
     * @param nombre Nombre del cliente.
     * @param email Email del cliente.
     */
    public Cliente(String nombre, String email){
        this.nombre = nombre;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
