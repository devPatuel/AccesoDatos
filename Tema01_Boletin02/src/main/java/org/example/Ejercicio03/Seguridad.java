package org.example.Ejercicio03;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

public class Seguridad {
    /**
     * Genera el hash SHA-1 de una contraseña en formato hexadecimal.
     *
     * @param password Contraseña en texto que se convertirá
     * @return La cadena Hexadecimal que representa la contraseña.
     * @throws NoSuchAlgorithmException Si el algoritmo no está disponible
     */
    public static String generarHash(String password) throws NoSuchAlgorithmException {
        // Crea un objeto aplicando el algoritmo SHA-1
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        // Convierte el texto a bytes
        byte[] bytes = md.digest(password.getBytes());
        // Juntamos los bytes en un stringBuilder
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    /**
     * Comprueba si una contraseña introducida coincide con un hash almacenado.
     *
     * @param password Contraseña introducida por el usuario.
     * @param hash     Hash guardado previamente en el archivo .properties.
     * @return true si el hash de la contraseña introducida coincide con el guardado; false en caso contrario.
     * @throws NoSuchAlgorithmException Si el algoritmo SHA-1 no está disponible.
     */
    public static boolean validarHash(String password, String hash) throws NoSuchAlgorithmException {
        String hashintroducido = generarHash(password);
        return hashintroducido.equals(hash);
    }

    /**
     * Verifica si una contraseña cumple los requisitos mínimos de seguridad.
     *
     * @param password Contraseña que se desea validar.
     * @return true si cumple todos los requisitos, false si falla alguno.
     * <p>
     * Requisitos:
     * - Mínimo 8 caracteres.
     * - Al menos una letra mayúscula.
     * - Al menos una letra minúscula.
     * - Al menos un número.
     * - Al menos un carácter no alfanumérico (símbolo).
     * <p>
     * Utiliza expresiones regulares para detectar la presencia de cada tipo de carácter.
     */
    private static boolean validarPassword(String password) {
        return password.length() >= 8 &&                     // 8 o mas caracteres
                password.matches(".*[A-Z].*") &&       // al menos una mayúscula
                password.matches(".*[a-z].*") &&       // al menos una minúscula
                password.matches(".*[0-9].*") &&       // al menos un número
                password.matches(".*[^A-Za-z0-9].*");  // al menos un símbolo
    }

    /**
     * Cambia la contraseña almacenada en el archivo .properties si la actual es correcta
     * y la nueva cumple los requisitos de seguridad.
     *
     * @param actual  Contraseña actual introducida por el usuario.
     * @param nueva   Nueva contraseña que se desea establecer.
     * @param props   Objeto Properties cargado con las propiedades del archivo.
     * @param archivo Archivo .properties donde se guarda el hash.
     * @return true si la contraseña se cambia correctamente; false si falla la validación o la escritura.
     * @throws NoSuchAlgorithmException Si el algoritmo SHA-1 no está disponible.
     * @throws IOException              Si ocurre un error al guardar el archivo .properties.
     */
    public static boolean cambiarHash(String actual, String nueva, Properties props, File archivo) throws IOException, NoSuchAlgorithmException {
        String hashGuardado = props.getProperty("passwordHash");

        if (!validarHash(actual, hashGuardado)) {
            return false;
        }

        if (!validarPassword(nueva)) {
            return false;
        }

        String nuevoHash = generarHash(nueva);
        props.setProperty("passwordHash", nuevoHash);

        try (FileOutputStream fos = new FileOutputStream(archivo)) {
            props.store(fos, "Contraseña actualizada");
        }
        return true;
    }

    public static boolean cambiarHashJson(String actual, String nueva, Properties props, File archivo) throws IOException, NoSuchAlgorithmException {
        String hashGuardado = props.getProperty("passwordHash");

        if (!validarHash(actual, hashGuardado)) {
            return false;
        }

        if (!validarPassword(nueva)) {
            return false;
        }

        String nuevoHash = generarHash(nueva);
        props.setProperty("passwordHash", nuevoHash);

        try (FileOutputStream fos = new FileOutputStream(archivo)) {
            props.store(fos, "Contraseña actualizada");
        }
        return true;
    }
}


