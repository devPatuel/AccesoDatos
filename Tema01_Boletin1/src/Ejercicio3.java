import java.io.File;

public class Ejercicio3 {
    public static void main(String[] args) {
        File ejercicio3 = new File(Config.RUTA);

        // a
        System.out.println("El nombre de la carpeta es: " + ejercicio3.getName());

        // b
        System.out.println("La ruta  de la carpeta es: " + ejercicio3.getAbsolutePath());

        // c
        System.out.println("La carpeta se puede leer: " + ejercicio3.canRead());

        // d
        System.out.println("La carpeta se puede escribir: " + ejercicio3.canWrite());
    }
}