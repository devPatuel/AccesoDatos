package org.example.Ejercicio07;

import org.example.Ejercicio05.ParsesJson;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        try {
            while (true) {
                Inventario inventario = ParsesJson.parsearInventario();
                if (inventario != null) {
                    System.out.println("¿Que producto quieres encontrar?");
                    ProductoInventario[] listaProdcutos = inventario.getProductos();
                    System.out.println("Lista de productos: ");
                    for (ProductoInventario producto : listaProdcutos) {
                        System.out.println("Id: " + producto.getId());
                    }
                    String producto = lector.next();
                    for (ProductoInventario productoInventario : listaProdcutos) {
                        if (productoInventario.getId().equals(producto)) {
                            System.out.println(productoInventario.getUbicacion().toString());
                        }
                    }
                    if (producto.equalsIgnoreCase("Salir")) {
                        break;
                    }
                }
            }
        }catch (IOException e){
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }
    }

}
