import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ejercicio9 {
    public boolean compararArchivos(File archivo1, File archivo2) throws IOException {
        if (!archivo1.exists() || !archivo2.exists()){
            System.out.println("Alguno de los archivos no existe");
            return (false);
        }

        FileInputStream fs1 = new FileInputStream(archivo1);
        FileInputStream fs2 = new FileInputStream(archivo2);
        int b1, b2;
        // Nota para mi: FileInputStream leera en bytes, si termina la linea -1.
        while((b1= fs1.read()) !=-1){
            // Mientras que b1 no sea diferente de b2
            b2= fs2.read();
                if(b1 != b2){
                    System.out.println("No son iguales");
                    return (false);
                }
        }
        System.out.println("Son iguales");
                return true;

    } // Sobran los Systems, Modelo vista controlador
}
