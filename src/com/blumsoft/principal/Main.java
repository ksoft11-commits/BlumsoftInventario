package com.blumsoft.principal;

import com.blumsoft.dao.ProductoDAO;
import com.blumsoft.modelo.Producto;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner teclado = new Scanner(System.in);
    private static final ProductoDAO productoDAO = new ProductoDAO();

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n===== BLUMSOFT - INVENTARIO =====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Consultar productos");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    consultarProductos();
                    break;
                case 3:
                    actualizarProducto();
                    break;
                case 4:
                    eliminarProducto();
                    break;
                case 5:
                    System.out.println("Gracias por utilizar Blumsoft.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 5);
    }

    private static void registrarProducto() {

    System.out.println("\n--- REGISTRAR PRODUCTO ---");

    System.out.print("Nombre: ");
    String nombre = teclado.nextLine();

    System.out.print("Descripcion: ");
    String descripcion = teclado.nextLine();

    System.out.print("Precio: ");
    double precio = teclado.nextDouble();

    System.out.print("Stock: ");
    int stock = teclado.nextInt();

    Producto producto = new Producto(
            0, nombre, descripcion, precio, stock);

    boolean registrado = productoDAO.insertarProducto(producto);

    if (registrado) {
        System.out.println("Producto registrado correctamente.");
    } else {
        System.out.println("No fue posible registrar el producto.");
    }
}

    private static void consultarProductos() {

    System.out.println("\n--- LISTA DE PRODUCTOS ---");

    List<Producto> productos = productoDAO.consultarProductos();

    if (productos.isEmpty()) {
        System.out.println("No hay productos registrados.");
        return;
    }

    for (Producto producto : productos) {

        System.out.println("----------------------------");
        System.out.println("ID: " + producto.getIdProducto());
        System.out.println("Nombre: " + producto.getNombre());
        System.out.println("Descripcion: " + producto.getDescripcion());
        System.out.println("Precio: $" + producto.getPrecio());
        System.out.println("Stock: " + producto.getStock());
    }
}

    private static void actualizarProducto() {

    System.out.println("\n--- ACTUALIZAR PRODUCTO ---");

    System.out.print("Ingrese el ID del producto: ");
    int id = teclado.nextInt();
    teclado.nextLine();

    System.out.print("Nuevo nombre: ");
    String nombre = teclado.nextLine();

    System.out.print("Nueva descripcion: ");
    String descripcion = teclado.nextLine();

    System.out.print("Nuevo precio: ");
    double precio = teclado.nextDouble();

    System.out.print("Nuevo stock: ");
    int stock = teclado.nextInt();

    Producto producto = new Producto(
            id, nombre, descripcion, precio, stock);

    boolean actualizado = productoDAO.actualizarProducto(producto);

    if (actualizado) {
        System.out.println("Producto actualizado correctamente.");
    } else {
        System.out.println("No fue posible actualizar el producto.");
    }
}

    private static void eliminarProducto() {

    System.out.println("\n--- ELIMINAR PRODUCTO ---");

    System.out.print("Ingrese el ID del producto que desea eliminar: ");
    int id = teclado.nextInt();

    System.out.print("¿Esta seguro de eliminarlo? (1 = Si, 2 = No): ");
    int confirmacion = teclado.nextInt();

    if (confirmacion == 1) {

        boolean eliminado = productoDAO.eliminarProducto(id);

        if (eliminado) {
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("No se encontro el producto.");
        }

    } else {
        System.out.println("Operacion cancelada.");
    }
}
}