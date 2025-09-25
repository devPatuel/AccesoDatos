import java.io.File;

public class Main    {
    public static void main(String[] args) throws Exception {
        GestionArchivos obj = new GestionArchivos();
        // obj.crearArchivo(Config.RUTA, "ArchivoAct5.txt");
        //obj.listarDirectorio(Config.RUTA);
        // obj.verInfo(Config.RUTA, "ArchivoAct5.txt");
        // obj.mostrarContenido(Config.RUTA, "Archivoact5.txt");

        // Ejercicio 9
        File archivo1 = new File("C:\\Users\\pocap\\OneDrive\\Escritorio\\AccesoDatos\\Tema01\\src\\Archivo1.txt");
        File archivo2 = new File("C:\\Users\\pocap\\OneDrive\\Escritorio\\AccesoDatos\\Tema01\\src\\Archivo2.txt");

        // Ejercicio9 obj2 = new Ejercicio9();
        // obj2.compararArchivos(archivo1,archivo2);

        //Ejercicio10
        Ejercicio10 obj3 = new Ejercicio10();
        obj3.concat(archivo1,archivo2);

        //Ejercicio11
        Ejercicio11 obj4 = new Ejercicio11();
        obj4.concatLines(archivo1,archivo2);



    }
}