package com.blumsoft.dao;

import com.blumsoft.conexion.ConexionBD;
import com.blumsoft.modelo.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    // INSERTAR PRODUCTO
    public boolean insertarProducto(Producto producto) {

        String sql = "INSERT INTO producto "
                + "(nombre, descripcion, precio, stock) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, producto.getNombre());
            sentencia.setString(2, producto.getDescripcion());
            sentencia.setDouble(3, producto.getPrecio());
            sentencia.setInt(4, producto.getStock());

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar producto: "
                    + e.getMessage());
            return false;
        }
    }

    // CONSULTAR TODOS LOS PRODUCTOS
    public List<Producto> consultarProductos() {

        List<Producto> productos = new ArrayList<>();

        String sql = "SELECT * FROM producto";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {

                Producto producto = new Producto(
                        resultado.getInt("id_producto"),
                        resultado.getString("nombre"),
                        resultado.getString("descripcion"),
                        resultado.getDouble("precio"),
                        resultado.getInt("stock")
                );

                productos.add(producto);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar productos: "
                    + e.getMessage());
        }

        return productos;
    }

    // ACTUALIZAR PRODUCTO
    public boolean actualizarProducto(Producto producto) {

        String sql = "UPDATE producto SET nombre = ?, "
                + "descripcion = ?, precio = ?, stock = ? "
                + "WHERE id_producto = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, producto.getNombre());
            sentencia.setString(2, producto.getDescripcion());
            sentencia.setDouble(3, producto.getPrecio());
            sentencia.setInt(4, producto.getStock());
            sentencia.setInt(5, producto.getIdProducto());

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: "
                    + e.getMessage());
            return false;
        }
    }

    // ELIMINAR PRODUCTO
    public boolean eliminarProducto(int idProducto) {

        String sql = "DELETE FROM producto WHERE id_producto = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idProducto);

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: "
                    + e.getMessage());
            return false;
        }
    }
}