import java.io.*;

public class GestionArchivos {
    public boolean crearArchivo(String directorio, String archivo) throws IOException {
        File file = new File(directorio, archivo);

        if (file.exists()) {
            return (false);
        }
        file.createNewFile();
        return (file.exists());
    }

    public void listarDirectorio(String directorio) {
        File file = new File(directorio);
        char c;
        if (file.exists() && file.isDirectory()) {
            File[] lista = file.listFiles();
            if (lista != null) {
                for (File archivo : lista) {
                    if (archivo.isDirectory()) {
                        c = 'd';
                    } else {
                        c = 'f';
                    }
                    // Para utilizar ? : , ponemos la condicion ? valor true : Valor false.
                    String permiso = (archivo.canRead() ? "r" : "-") + (archivo.canWrite() ? "w" : "-") + (archivo.canExecute() ? "x" : "-");
                    System.out.println("Nombre: " + archivo.getName() + " Tipo: " + c + " Tamaño " + archivo.length() + " Bytes " + "Permisos " + permiso);


                }
            }
        }

    }

    public void verInfo(String directorio, String archivo) {
        File file = new File(directorio, archivo);

        if (file.exists()) {
            System.out.println("Nombre: " + file.getName() + " Ruta: " + file.getAbsolutePath());
            System.out.println(" Leer: " + file.canRead() + " Escribir: " + file.canWrite() + " Ejecutar: " + file.canExecute());
            System.out.println("Tamaño " + file.length());
            if (file.isDirectory()) {
                System.out.println("Tipo : Directorio");
            } else {
                System.out.println("Tipo : Fichero");
            }
        }
    }

    public void mostrarContenido(String directorio, String archivo) throws IOException {
        File file = new File(directorio, archivo);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String contenido;
        while ((contenido = br.readLine()) != null) {
            System.out.println(contenido);
        }

    }

     // Ejercicio 8 No entiendo muy bien que se pide.
}