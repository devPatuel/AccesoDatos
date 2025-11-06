package org.example.Ejercicio04;

/**
 * Clase para representar un pedido.
 */
public class Pedido {
    private String id;
    private Cliente Cliente;
    private String fecha;
    private Producto[] productos;
    private double total;

    /**
     * Constructor de la clase Pedido.
     * @param id ID del pedido.
     * @param cliente Cliente del pedido.
     * @param fecha Fecha del pedido.
     * @param productos Lista de productos del pedido.
     * @param total Total del pedido.
     */
    public Pedido(String id, Cliente cliente, String fecha, Producto[] productos, double total) {
        this.id = id;
        Cliente = cliente;
        this.fecha = fecha;
        this.productos = productos;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente cliente) {
        Cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Producto[] getItems() {
        return productos;
    }

    public void setItems(Producto[] productos) {
        this.productos = productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
