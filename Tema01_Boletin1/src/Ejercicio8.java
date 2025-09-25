import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Ejercicio8 {
    //Nota para mi:  Probado con ArchivoAct5.txt, pasado como argumento en la cofiguracion de intelij
    public static void main(String[] args) throws Exception{
        String ruta = args[0];
        File file = new File(ruta);
        // Comprobar que solo se le pasa un argumento.
        // Comprobar que es un archivo valido o no existe.

        if(!file.exists()){
            System.out.println("No existe el archivo");
        }
        else {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String contenido;
            while ((contenido = br.readLine()) != null) {
                System.out.println(contenido);
            }
            // Falta el close(Liberar recursos)
        }
    }
}
