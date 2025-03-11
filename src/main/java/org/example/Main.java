package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Producto> productos = new ArrayList<>();

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Crear producto");
            System.out.println("2. Vender producto");
            System.out.println("3. Reponer stock");
            System.out.println("4. Aplicar descuento");
            System.out.println("5. Aumentar precio");
            System.out.println("6. Mostrar información del producto");
            System.out.println("7. Calcular valor total en inventario");
            System.out.println("8. Eliminar producto");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();

            if (opcion == 9) {
                System.out.println("Saliendo...");
                break;
            }

            switch (opcion) {
                case 1: // Crear producto
                    System.out.print("Código: ");
                    String codigo = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    System.out.print("Stock: ");
                    int stock = sc.nextInt();
                    productos.add(new Producto(codigo, nombre, precio, stock));
                    System.out.println("Producto agregado.");
                    break;

                case 2: // Vender producto
                    System.out.print("Código del producto: ");
                    codigo = sc.nextLine();
                    Producto p = buscarProducto(productos, codigo);
                    if (p != null) {
                        System.out.print("Cantidad a vender: ");
                        int cantidad = sc.nextInt();
                        p.vender(cantidad);
                    }
                    break;

                case 3: // Reponer stock
                    System.out.print("Código del producto: ");
                    codigo = sc.nextLine();
                    p = buscarProducto(productos, codigo);
                    if (p != null) {
                        System.out.print("Cantidad a reponer: ");
                        int cantidad = sc.nextInt();
                        p.reponer(cantidad);
                    }
                    break;

                case 4: // Aplicar descuento
                    System.out.print("Código del producto: ");
                    codigo = sc.nextLine();
                    p = buscarProducto(productos, codigo);
                    if (p != null) {
                        p.aplicarDescuento();
                    }
                    break;

                case 5: // Aumentar precio
                    System.out.print("Código del producto: ");
                    codigo = sc.nextLine();
                    p = buscarProducto(productos, codigo);
                    if (p != null) {
                        p.aumentarPrecio();
                    }
                    break;

                case 6: // Mostrar información
                    System.out.print("Código del producto: ");
                    codigo = sc.nextLine();
                    p = buscarProducto(productos, codigo);
                    if (p != null) {
                        p.mostrarInformacion();
                    }
                    break;

                case 7: // Calcular valor total en inventario
                    double totalInventario = 0;
                    for (Producto producto : productos) {
                        totalInventario += producto.calcularValorInventario();
                    }
                    System.out.println("\nValor total del inventario: " + totalInventario);
                    break;

                case 8: // Eliminar producto
                    System.out.print("Código del producto a eliminar: ");
                    codigo = sc.nextLine();
                    productos.removeIf(producto -> producto.getCodigo().equals(codigo));
                    System.out.println("Producto eliminado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }

    public static Producto buscarProducto(ArrayList<Producto> productos, String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        System.out.println("Producto no encontrado.");
        return null;
    }
}
