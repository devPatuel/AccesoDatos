package org.example.Ejercicio07;

import java.util.Arrays;
import java.util.Objects;

public class Inventario {
    private String almacen;
    private String actualizado;
    private ProductoInventario[] productos;

    public Inventario(String almacen, String actualizado, ProductoInventario[] productos) {
        this.almacen = almacen;
        this.actualizado = actualizado;
        this.productos = productos;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getActualizado() {
        return actualizado;
    }

    public void setActualizado(String actualizado) {
        this.actualizado = actualizado;
    }

    public ProductoInventario[] getProductos() {
        return productos;
    }

    public void setProductos(ProductoInventario[] productos) {
        this.productos = productos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Inventario that = (Inventario) o;
        return Objects.equals(almacen, that.almacen) && Objects.equals(actualizado, that.actualizado) && Objects.deepEquals(productos, that.productos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(almacen, actualizado, Arrays.hashCode(productos));
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "almacen='" + almacen + '\'' +
                ", actualizado='" + actualizado + '\'' +
                ", productos=" + Arrays.toString(productos) +
                '}';
    }
}
