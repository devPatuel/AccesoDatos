package org.example.Ejercicio06;

import org.example.Ejercicio05.Alumno;
import org.example.Ejercicio05.Asignatura;
import org.example.Ejercicio05.ParsesJson;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Alumno[] alumnos = ParsesJson.parsearAlumnos();
            String nombreAlumno = "";
            String asignatura = "";
            double nota = 0;
            double notaMedia = 0;

            if (alumnos != null) {
                for (Alumno alumno : alumnos) {
                    Asignatura[] asignaturas = alumno.getAsigantura();
                    for (Asignatura a : asignaturas) {
                        if (nota < a.getNota()) {
                            asignatura = a.getNombre();
                            nota = a.getNota();
                        }
                    }
                    if (notaMedia < alumno.notaMedia()) {
                        nombreAlumno = alumno.getNombre();
                        notaMedia = alumno.notaMedia();
                    }
                    System.out.println("Alumno: " + alumno.getNombre() + "\n" +
                            "Mejor asignatura: " + asignatura + " con una nota de: " + nota);
                    asignatura = "";
                    nota = 0;
                }
                System.out.println("-------------------------------------------");
                System.out.println("Alumno con la mejor nota media es: " + nombreAlumno +
                        " con una nota media de: " + notaMedia);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }
    }
}
