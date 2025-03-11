package org.example;

import java.util.ArrayList;

class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    // Constructor
    public Producto(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Métodos Getters y Setters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }

    public void setStock(int stock) { this.stock = stock; }
    public void setPrecio(double precio) { this.precio = precio; }

    // Métodos funcionales
    public void vender(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad;
            System.out.println("Venta realizada. Stock restante: " + stock);
        } else {
            System.out.println("Stock insuficiente.");
        }
    }

    public void reponer(int cantidad) {
        stock += cantidad;
        System.out.println("Stock repuesto. Nuevo stock: " + stock);
    }

    public void aplicarDescuento() {
        precio *= 0.98; // Descuento del 2%
        System.out.println("Descuento aplicado. Nuevo precio: " + precio);
    }

    public void aumentarPrecio() {
        precio *= 1.06; // Aumento del 6%
        System.out.println("Precio incrementado. Nuevo precio: " + precio);
    }

    public double calcularValorInventario() {
        System.out.println("\nCódigo: " + this.codigo);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Precio unitario: " + this.precio);
        System.out.println("Stock: " + this.stock);
        return stock * precio;
    }

    public void mostrarInformacion() {
        System.out.println("\nCódigo: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + stock);
    }
}
