import java.io.*;

public class Ejercicio10 {
    // Nota para mi: Lo he hecho con bufferedReader porque son archivos de texto si quisieramos hacerlo con otros usariamos el fileinput.
    public void concat (File archivo1, File archivo2) throws IOException {
        File archivo3 = new File("Archivo3act10.txt");
        BufferedReader bf1 = new BufferedReader(new FileReader(archivo1));
        BufferedReader bf2 = new BufferedReader(new FileReader(archivo2));
        BufferedWriter bfw = new BufferedWriter(new FileWriter(archivo3));

        // Stringbuilder , para evitar "fundir" Strings
        String contenido;

        while((contenido = bf1.readLine()) !=null){
            bfw.write(contenido);
            bfw.newLine();
        }

        while((contenido = bf2.readLine()) !=null){
            bfw.write(contenido);
            bfw.newLine();
        }

        // Try with resources, se quedarian abiertos en caso de fallo en una parte de antes del codigo.
        bf1.close();
        bf2.close();
        bfw.close();

    }
}
