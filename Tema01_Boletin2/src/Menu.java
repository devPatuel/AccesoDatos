import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.Scanner;

public class Menu {
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
