import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio11 {
    // Nota para mi: utilizare en este ejercicio FileInput en vez del BufferedReader
    public void concatLines (File archivo1, File archivo2) throws IOException {
        FileInputStream fis1= new FileInputStream(archivo1);
        FileInputStream fis2= new FileInputStream(archivo2);
        FileOutputStream fos= new FileOutputStream("Archivo3Act11");
        // Creamos una Array de bytes para que sea mas rapido, poruqe en archivos grandes ir de 1 en uno seria mucho.
        byte[] contenido = new byte[1024];
        int bytesLeidos;
        // try with resources, no hace lo que pide el enunciado :(
        while((bytesLeidos = fis1.read(contenido)) != -1){
            // El array con el contenido, la posicion desde donde epieza a escribir, tamaño que escribira a partir de la posicion de inicio.
            fos.write(contenido, 0 , bytesLeidos);
        }
        while((bytesLeidos = fis2.read(contenido)) != -1){
            // El array con el contenido, la posicion desde donde epieza a escribir, tamaño que escribira a partir de la posicion de inicio.
            fos.write(contenido, 0 , bytesLeidos);
        }


    }
}
