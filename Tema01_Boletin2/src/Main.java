import java.io.*;

public class Main {
    public static void leerDni(String archivo1) throws IOException {
        File file = new File(archivo1);
        // split devuelve un Array separando, [] porque . significa cualquier caracter
        String[] sinExtension = file.getName().split("[.]");
        String nombre = sinExtension[0] + "_con Letras"+ "." + sinExtension[1];
        StringBuilder stbld = new StringBuilder();
        // Leer la linea y comprobar que tiene 8, sino escribir a la izquierda 0
        try (
                BufferedReader bfr1 = new BufferedReader(new FileReader(file));
                BufferedWriter bfw1 = new BufferedWriter(new FileWriter(nombre));
        ) {
            // Leer y añadir 0
            String linea;
            while ((linea = bfr1.readLine()) != null) {
                // Reiniciamos el stringBuilder.
                stbld.setLength(0);
                int tamanyo = linea.length();
                if (tamanyo <= 8) {
                    for (int i = tamanyo; i < 8; i++) {
                        // Insertamos 0 al inicio
                        stbld.insert(0, "0");
                    }
                    // Añadimos la linea del dni
                    stbld.append(linea);
                    // Calcular letra dni
                    String letraDni = "TRWAGMYFPDXBNJZSQVHLCKE";
                    // Lo hacemos int
                    int dni = Integer.parseInt(linea);
                    int resto = (dni % 23);
                    char letra = letraDni.charAt(resto);
                    // Añadimos la letra alfinal del StringBuilder
                    stbld.append(letra);
                    bfw1.write(stbld.toString());
                    bfw1.newLine();
                }
            }
        }
    }

    // Nuevo archivo concat dnis y letras.
    public static void main(String[] args) throws Exception {
        leerDni("C:\\Users\\pocap\\OneDrive\\Escritorio\\AccesoDatos\\Tema01_Boletin2\\src\\Dnis.txt");
    }
}



