package org.example.Ejercicio06;

import java.io.*;
import java.util.Scanner;

public class NumeroPrimo {
    /**
     * Clase principal para la gestión de números primos.
     * Permite calcular y almacenar números primos en un archivo de texto.
     * Si el archivo ya existe, retoma el cálculo desde el último primo guardado.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String archivo = "primos.txt";
        int numero = 2; // primer número a comprobar
        File file = new File(archivo);

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String linea;
                String ultima = null;
                while ((linea = br.readLine()) != null) {
                    ultima = linea;
                }
                if (ultima != null) {
                    numero = Integer.parseInt(ultima);
                }
            }
        }
        System.out.println("Comenzando a calcular primos desde: " + numero);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Pulsa ENTER para generar el siguiente primo o escribe 'salir' para terminar.");
            String entrada;

            while (true) {
                entrada = scanner.nextLine();
                if (entrada.equalsIgnoreCase("salir")) break;

                while (!esPrimo(numero)) {
                    numero++;
                }

                System.out.println("Primo encontrado: " + numero);
                bw.write(Integer.toString(numero));
                bw.newLine();
                bw.flush();

                numero++;
            }

            scanner.close();
        }
    }

    /**
     * Comprueba si un número es primo.
     *
     * @param n El numero a comprobar.
     * @return true si es primo, false en caso contrario.
     */
    private static boolean esPrimo(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
