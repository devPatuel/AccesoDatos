import java.io.File;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Ejercicio4 {
    public static void main(String[] args) {
        File ejercicio4 = new File(Config.RUTA, "ArchivoPrueba.txt");

        // a
        System.out.println("Nombre: "+ ejercicio4.getName());
        // b
        System.out.println("Path: "+ ejercicio4.getAbsolutePath());
        // c
        System.out.println("Oculto: "+ ejercicio4.isHidden());
        // d
        System.out.println("Leer: "+ ejercicio4.canRead());
        // e
        System.out.println("Escribir: "+ ejercicio4.canWrite());
        // f
        // DateTimeFormatter time = DateTimeFormatter.ofPattern("dd/MM/yy");
        // System.out.println(String.format(String.format("Ultima modificacion: " + ejercicio4.lastModified());
        // g
        System.out.println("Tamaño en bytes: "+ ejercicio4.length());
        double kb = (double)ejercicio4.length()/1024;
        System.out.println("Tamaño en KB: "+ kb);
        double mb = kb/1024;
        System.out.println("Tamaño en MB: "+ mb);
    }
}
