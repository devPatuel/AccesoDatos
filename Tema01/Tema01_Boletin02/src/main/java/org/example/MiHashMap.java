package org.example;

import java.util.ArrayList;

/**
 * Clase que representa un par clave-valor dentro del mapa.
 *
 */
class Par {
    String clave; // Nombre
    String valor; // DNI, NIA ...
    /**
     * Crea un nuevo par clave-valor.
     * @param clave la clave del par
     * @param valor el valor asociado
     */
    Par(String clave, String valor) {
        this.clave = clave;
        this.valor = valor;
    }
}
/**
 * Implementación simple de una tabla hash (tipo HashMap) sin usar la clase HashMap de Java.
 */
public class MiHashMap {
    private final int TAM = 10;
    private ArrayList<Par>[] tabla;
    /**
     * Constructor: inicializa la tabla con ArrayList vacíos en cada posición.
     */
    public MiHashMap() {
        tabla = new ArrayList[TAM];
        for (int i = 0; i < TAM; i++) {
            tabla[i] = new ArrayList<>();
        }
    }
    /**
     * Calcula el índice de la tabla a partir del {@code hashCode()} de la clave.
     *
     * @param clave, la clave de la cual obtener el índice
     * @return índice entre 0 y el tamaño(TAM)
     */
    private int getHash(String clave) {
        return Math.abs(clave.hashCode() % TAM);
    }
    /**
     * Inserta un nuevo par clave-valor o actualiza el valor si la clave ya existe.
     *
     * @param clave la clave que se desea insertar o actualizar
     * @param valor el valor a asociar a la clave
     */
    public void put(String clave, String valor) {
        int hash = getHash(clave);
        for (Par p : tabla[hash]) {
            if (p.clave.equals(clave)) {
                p.valor = valor; // actualiza
                return;
            }
        }
        tabla[hash].add(new Par(clave, valor)); // Añade si no existe
    }
    /**
     * Devuelve el valor asociado a una clave si existe.
     *
     * @param clave la clave a buscar
     * @return el valor asociado o {@code null} si no se encuentra
     */
    public String get(String clave) {
        int hash = getHash(clave);
        for (Par p : tabla[hash]) {
            if (p.clave.equals(clave)) {
                return p.valor;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MiHashMap mapa = new MiHashMap();
        mapa.put("Jordi", "20963122");
        mapa.put("Ana", "12121234");
        System.out.println(mapa.get("Jordi"));

        System.out.println(mapa.get("Ana"));
    }
}