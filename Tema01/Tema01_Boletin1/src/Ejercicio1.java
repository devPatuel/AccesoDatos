import java.io.File;

public class Ejercicio1 {
    public static void main(String[] args) {
        File ejercicio1 = new File(Config.RUTA);

        System.out.println("Existe? : "+ ejercicio1.exists());
        System.out.println("Es un directorio? : "+ ejercicio1.isDirectory());
    }
}
