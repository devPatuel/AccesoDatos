package org.example.Ejercicio03;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.Scanner;

public class Menu {
    /**
     * Muestra el primer menú del programa y gestiona el acceso al sistema.
     * Si el usuario valida correctamente la contraseña, accede al segundo menú.
     *
     * @throws NoSuchAlgorithmException si ocurre un error al generar o validar el hash.
     * @throws IOException si ocurre un error al leer o escribir el archivo de propiedades.
     */
    public void primerMenu() throws NoSuchAlgorithmException, IOException {
        Scanner scanner = new Scanner(System.in);
        int seleccion = -1;
        do {
            System.out.println("*******************");
            System.out.println("1. Validar acceso.");
            System.out.println("*******************");
            System.out.println("Selecciona una opción");
            seleccion = scanner.nextInt();
            if (seleccion == 1) {
                if (introducirPassword()) {
                    segundoMenu();
                }
            }
        }
        while (seleccion != 1);

        scanner.close();
    }
    /**
     * Comprueba si existe el archivo de propiedades con el hash de la contraseña.
     * Si no existe, crea uno con una contraseña por defecto ("S3cret@").
     * Solicita al usuario que introduzca la contraseña hasta que sea válida.
     *
     * @return true cuando el acceso ha sido validado correctamente.
     * @throws NoSuchAlgorithmException si ocurre un error al validar el hash.
     * @throws IOException si ocurre un error al acceder al archivo de propiedades.
     */
    private boolean introducirPassword() throws NoSuchAlgorithmException, IOException {
        Scanner scanner = new Scanner(System.in);
        File file = new File("datos.properties");
        Properties props = new Properties();
        // Si no existe creo con el hash por defecto
        if (!file.exists()) {
            String hashDefecto = Seguridad.generarHash("S3cret@");
            props.setProperty("passwordHash", hashDefecto);
            try (FileOutputStream fos = new FileOutputStream(file)) {
                props.store(fos, "Archivo creado");
            }
        } else {
            try (FileInputStream fis = new FileInputStream(file)) {
                props.load(fis);
            }
        }
        String hash = props.getProperty("passwordHash");

        boolean accesoValido = false;
        do {
            System.out.println("*******************");
            System.out.println("Introduce tu contraseña.");
            String password = scanner.nextLine();
            if (Seguridad.validarHash(password, hash)) {
                accesoValido = true;
            }
        }
        while (!accesoValido);
        return true;
    }
    /**
     * Muestra el segundo menú del programa tras validar el acceso.
     * Permite al usuario modificar la contraseña o salir del programa.
     *
     * @throws IOException si ocurre un error al leer o escribir en el archivo.
     * @throws NoSuchAlgorithmException si ocurre un error al generar o validar hashes.
     */
    public void segundoMenu() throws IOException, NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        int seleccion = -1;
        do {
            System.out.println("*******************");
            System.out.println("1.Modificar contraseña.");
            System.out.println("2.Salir del programa.");
            System.out.println("*******************");
            System.out.println("Selecciona una opción");
            seleccion = scanner.nextInt();
            if (seleccion == 1) {
                modificarContra();
            } else if (seleccion == 2) {
                System.exit(0);
            }
        } while (seleccion <= 0 || seleccion > 2);
        {
        }
    }
    /**
     * Permite al usuario cambiar la contraseña almacenada.
     * Solicita la contraseña actual y una nueva, y actualiza el hash en el archivo.
     * Repite el proceso hasta que el cambio se realice correctamente.
     *
     * @throws IOException si ocurre un error al acceder al archivo de propiedades.
     * @throws NoSuchAlgorithmException si ocurre un error al generar o validar el hash.
     */
    public void modificarContra() throws IOException, NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        File file = new File("datos.properties");
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(file)) {
            props.load(fis);
        }

        boolean cambiada = false;
        do{
        System.out.println("Introduce tu contraseña actual:");
        String actual = scanner.nextLine();

        System.out.println("Introduce la nueva contraseña:");
        String nueva = scanner.nextLine();

        cambiada= Seguridad.cambiarHash(actual,nueva,props,file);
        if(!cambiada){System.out.println("Error al cambiar la contarseña.");}

        }while(!cambiada);
    }
}
