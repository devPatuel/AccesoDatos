package org.example.Ejercicio04;

/**
 * Clase para representar un producto.
 */
public class Producto {
    private String sku;
    private String descripcion;
    private float cantidad;
    private float precioUnitario;

    /**
     * Constructor de la clase Producto.
     * @param sku ID del producto.
     * @param descripcion Descripción del producto.
     * @param cantidad Cantidad del producto.
     * @param precioUnitario Precio unitario del producto.
     */
    public Producto(String sku, String descripcion, float cantidad, float precioUnitario) {
        this.sku = sku;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "Item{" +
                "sku='" + sku + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                '}';
    }

}
