package org.example.Ejercicio04;

public class Usuario {
    private String passwordHash;
    private String nombreUsuario;
    public Usuario(String passwordHash, String nombreUsuario) {
        this.passwordHash = passwordHash;
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

}
