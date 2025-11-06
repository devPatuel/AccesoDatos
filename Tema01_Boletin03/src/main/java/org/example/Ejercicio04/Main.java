package org.example.Ejercicio04;

import java.util.Scanner;
import org.example.Ejercicio01.Parses;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class Main {
    public static void main(String[] args) {
        try {
            Scanner lector = new Scanner(System.in);
            Pedido[] pedidos = Parses.parsePedidos();

            System.out.println("¿Que pedido quieres mostrar? Te muestro los que existen: ");
            for (Pedido pedido : pedidos) {
                System.out.println(pedido.getId());
            }
            // Lista de productos
            String idPedido = lector.nextLine();
            for (Pedido pedido : pedidos) {
                if (pedido.getId().equals(idPedido)) {
                    Producto[] productos = pedido.getItems();
                    for (Producto p : productos) {
                        System.out.println("Lista de productos del pedido: " + pedido.getId());
                        System.out.println("Producto: " + p.getSku());
                    }
                }
            }
            // Calcular total
            for (Pedido pedido : pedidos) {
                if (pedido.getId().equals(idPedido)) {
                    Producto[] productos = pedido.getItems();
                    double total = pedido.getTotal();
                    double totalProductos = 0;
                    for (Producto p : productos) {
                        totalProductos += p.getPrecioUnitario() * p.getCantidad();
                    }
                    // Para tratar los decimales finales que dan error
                    if (Math.abs(total - totalProductos) < 0.001) {
                        System.out.println("El total es correcto Total: " + String.format("%.2f", total) + " Total productos: " + String.format("%.2f", totalProductos));
                    }
                }
            }
        }catch (IOException e){
            System.err.println("Error: Fallo al leer el fichero XML");
        } catch (ParserConfigurationException e) {
            System.err.println("Error: Fallo en la configuración del parser XML");
        } catch (SAXException e) {
            System.err.println("Error: Fallo al parsear el fichero XML");
        }
    }
}
