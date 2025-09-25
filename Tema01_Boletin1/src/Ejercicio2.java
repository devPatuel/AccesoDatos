import java.io.File;
import java.util.ArrayList;

public class Ejercicio2 {
    public static void main(String[] args) {
        File ejercicio2 = new File(Config.RUTA);

        File[] lista = ejercicio2.listFiles();

        for (File f : lista) {

            System.out.println(f.getName());

        }

    }
}
