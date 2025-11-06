package org.example.Ejercicio05;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Alumno[] alumnos = ParsesJson.parsearAlumnos();

            if (alumnos != null) {
                for (Alumno alumno : alumnos) {
                    System.out.print("Alumno: " +alumno.getNombre());
                    System.out.println("  || Fecha de Nacimiento: " + alumno.getFechaNacimiento());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }
    }
}

