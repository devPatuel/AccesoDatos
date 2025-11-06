package org.example.Ejercicio07;

import java.util.Arrays;
import java.util.Objects;

/**
 * Clase que representa un producto en el inventario.
 */
public class ProductoInventario {
    private String id;
    private String nombre;
    private int stock;
    private double precio;
    private String[] tags;
    private Ubicacion ubicacion;

    /**
     * Constructor de la clase ProductoInventario.
     * @param id El identificador único del producto.
     * @param nombre El nombre del producto.
     * @param stock El número de unidades disponibles en el inventario.
     * @param precio El precio del producto.
     * @param tags Los tags o etiquetas del producto.
     * @param ubicacion Objete Ubicación que contiene la ubicación del producto en el inventario.
     */
    public ProductoInventario(String id, String nombre, int stock, double precio, String[] tags, Ubicacion ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.tags = tags;
        this.ubicacion = ubicacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductoInventario that = (ProductoInventario) o;
        return stock == that.stock && Double.compare(precio, that.precio) == 0 && Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.deepEquals(tags, that.tags) && Objects.equals(ubicacion, that.ubicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, stock, precio, Arrays.hashCode(tags), ubicacion);
    }

    @Override
    public String toString() {
        return "ProductoInventario{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", stock=" + stock +
                ", precio=" + precio +
                ", tags=" + Arrays.toString(tags) +
                ", ubicacion=" + ubicacion +
                '}';
    }
}
