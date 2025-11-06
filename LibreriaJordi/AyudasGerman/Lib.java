package com.germangascon.tema01.lib;

import java.util.Random;
import java.util.Scanner;

public class Lib {
    public static Scanner lector = new Scanner(System.in);

    public static void limpiarPantalla() {
        System.out.println("\u001B[H\u001B[2J");
        System.out.flush();
    }

    public static void pausa() {
        System.out.println("Pulsa INTRO para continuar...");
        lector.nextLine();
    }

    public static int aleatorio() {
        Random r = new Random();
        return r.nextInt();
    }

    public static int aleatorio(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min +1 ) + min;
    }

    public static double aleatorio(double min, double max) {
        Random r = new Random();
        return min + r.nextDouble() * (max - min);
    }

    public static float aleatorio(float min, float max) {
        Random r = new Random();
        return min + r.nextFloat() * (max - min);
    }

    public static String stringAleatorio(int longitud) {
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";
        String bombo = alfabeto.toLowerCase() + numeros;
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < longitud; i++) {
            builder.append(bombo.charAt(aleatorio(0,bombo.length()-1)));
        }
        return builder.toString();
    }

    public static void ordenar(int[] vector) {
        boolean hayCambios = true;
        while(hayCambios) {
            hayCambios = false;
            for(int i = 0; i < vector.length - 1; i++) {
                if(vector[i] > vector[i+1]) {
                    intercambio(vector, i, i + 1);
                    hayCambios = true;
                }
            }
        }
    }

    public static int indexOf(int[] vector, int x) {
        for(int i = 0; i < vector.length; i++) {
            if(vector[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static void intercambio(int[] vector, int i, int j) {
        int aux = vector[i];
        vector[i] = vector[j];
        vector[j] = aux;
    }

    public static char letraNIF(int dni) {
        String tabla="TRWAGMYFPDXBNJZSQVHLCKE";
        int modulo= dni % 23;
        return tabla.charAt(modulo);
    }

    public static boolean validarNIF(String nif) {
        if (nif == null) {
            return false;
        }
        nif = nif.toUpperCase();
        StringBuilder dniString = new StringBuilder();
        if (nif.length() >= 2) {
            // Cogemos como letra el último caracter del NIF
            char letra = nif.charAt(nif.length() - 1);
            char c;
            for (int i = 0; i < nif.length(); i++) {
                // Si es un dígito lo añadimos a dniString
                c = nif.charAt(i);
                if (Character.isDigit(c)) {
                    dniString.append(c);
                }
            }

            return !dniString.toString().isEmpty() && letra == letraNIF(Integer.parseInt(dniString.toString()));
        }
        return false;
    }

    public static void sleep(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException ignored) { }
    }
}
