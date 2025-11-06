package org.example;

import java.io.*;
import java.time.LocalDate;
import org.example.Ejercicio01.Alumno;
import org.example.Ejercicio01.GestionAlumnos;

public class Main {
    public static void leerDni(String archivo1) throws IOException {
        File file = new File(archivo1);
        // split devuelve un Array separando, [] porque . significa cualquier caracter
        String[] sinExtension = file.getName().split("[.]");
        String nombre = sinExtension[0] + "_con Letras"+ "." + sinExtension[1];
        StringBuilder stbld = new StringBuilder();
        // Leer la linea y comprobar que tiene 8, sino escribir a la izquierda 0
        try (
                BufferedReader bfr1 = new BufferedReader(new FileReader(file));
                BufferedWriter bfw1 = new BufferedWriter(new FileWriter(nombre));
        ) {
            // Leer y añadir 0
            String linea;
            while ((linea = bfr1.readLine()) != null) {
                // Reiniciamos el stringBuilder.
                stbld.setLength(0);
                int tamanyo = linea.length();
                if (tamanyo <= 8) {
                    for (int i = tamanyo; i < 8; i++) {
                        // Insertamos 0 al inicio
                        stbld.insert(0, "0");
                    }
                    // Añadimos la linea del dni
                    stbld.append(linea);
                    // Calcular letra dni
                    String letraDni = "TRWAGMYFPDXBNJZSQVHLCKE";
                    // Lo hacemos int
                    int dni = Integer.parseInt(linea);
                    int resto = (dni % 23);
                    char letra = letraDni.charAt(resto);
                    // Añadimos la letra alfinal del StringBuilder
                    stbld.append(letra);
                    bfw1.write(stbld.toString());
                    bfw1.newLine();
                }
            }
        }
    }

    // Nuevo archivo concat dnis y letras.
    public static void main(String[] args) throws Exception {
        leerDni("C:\\Users\\pocap\\OneDrive\\Escritorio\\AccesoDatos\\Tema01_Boletin2\\src\\Dnis.txt");
        GestionAlumnos obj = new GestionAlumnos("Alumnos.txt");
        Alumno[] alumnos = {
                new Alumno("20250001", "Jordi", "Patuel", "García", LocalDate.of(2004, 5, 10)),
                new Alumno("20250002", "Ana", "López", "Martínez", LocalDate.of(2003, 12, 1)),
                new Alumno("20250003", "Pedro", "Sánchez", "Ruiz", LocalDate.of(2005, 1, 20)),
                new Alumno("20250004", "Laura", "Fernández", "Torres", LocalDate.of(2004, 7, 15)),
                new Alumno("20250005", "Marcos", "Gómez", "Hernández", LocalDate.of(2003, 11, 30)),
                new Alumno("20250006", "Lucía", "Díaz", "Morales", LocalDate.of(2004, 9, 25)),
                new Alumno("20250007", "Sergio", "Romero", "Castro", LocalDate.of(2005, 2, 5)),
                new Alumno("20250008", "Paula", "Ortega", "Jiménez", LocalDate.of(2004, 4, 18)),
                new Alumno("20250009", "Daniel", "Navarro", "Serrano", LocalDate.of(2003, 8, 12)),
                new Alumno("20250010", "Elena", "Vega", "Domínguez", LocalDate.of(2005, 6, 22))
        };
        obj.insertarAlumnos(alumnos); // Inserto los alumnos
        obj.eliminarAlumno(alumnos[0]); // Elimino 1 alumno
        System.out.println(obj.toString());
    }
}



