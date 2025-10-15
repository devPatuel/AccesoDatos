package org.example.Ejercicio01;

import java.io.*;
import java.nio.file.Files;


public class GestionAlumnos {
    private File file;

    public GestionAlumnos(String ruta) throws IOException {
        this.file = new File(ruta);
        if (!file.exists()) {
            // Comprueba que no exista y si lo crea.
            file.createNewFile();
        }
    }

    public void insertarAlumnos(Alumno[] alumnos) throws IOException {
        try (BufferedWriter bfw = new BufferedWriter(new FileWriter(file, true))) { // Usar 'true' para añadir en vez de sobreescribir
            for (Alumno alumno : alumnos) {
                String linea = alumno.getNia() + "," +
                        alumno.getNombre() + "," +
                        alumno.getApellido1() + "," +
                        alumno.getApellido2() + "," +
                        alumno.getFechaNacimiento();
                bfw.write(linea);
                bfw.newLine();
            }
        }
    }

    public void eliminarAlumno(Alumno alumno) throws IOException{
        File fileTemporal = new File("Alumnos");
        try(
                BufferedReader bfr = new BufferedReader(new FileReader(file));
                BufferedWriter bfw = new BufferedWriter(new FileWriter(fileTemporal))
                ){
            String linea;
            while ((linea = bfr.readLine()) != null){
                String[] division = linea.split(",");
                String niaAlumno = division[0]; // La primera parte sera el Nia.

                // Comapramos si el nia es el no mismo que el del alumno(Queremos copiar en el archivo todos los diferentes).
                if(!niaAlumno.equals(alumno.getNia())){
                    bfw.write(linea);
                    bfw.newLine();
                }
                // Elimina el archivo actual y añade el temporal
            }
        }
                Files.delete(file.toPath());
                Files.move(fileTemporal.toPath(), file.toPath());
    }
        // Evitar el RunTimeException
    public String toString() {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader bfr = new BufferedReader(new FileReader(file))){
            String linea;
            // Separamos las partes
            while ((linea= bfr.readLine()) != null){
                String[] partes = linea.split(",");
                sb.append("Nia: "+ partes[0] +
                                " Nombre: "+ partes[1] + " " + partes[2] + " " + partes[3] +
                                " Fecha: "+ partes[4]);
                sb.append("\n");
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
