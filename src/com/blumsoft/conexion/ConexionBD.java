package com.blumsoft.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/blumsoft_inventario";

    private static final String USUARIO =
        System.getenv().getOrDefault("BLUMSOFT_DB_USER", "root");

    private static final String CONTRASENA =
        System.getenv("BLUMSOFT_DB_PASSWORD");

    public static Connection obtenerConexion() {

        try {
            Connection conexion = DriverManager.getConnection(
                    URL, USUARIO, CONTRASENA);

            System.out.println("Conexion exitosa con MySQL.");

            return conexion;

        } catch (SQLException e) {

            System.out.println("Error al conectar con MySQL: "
                    + e.getMessage());

            return null;
        }
    }

    public static void main(String[] args) {

        try (Connection conexion = obtenerConexion()) {

            if (conexion != null) {
                System.out.println("Blumsoft esta conectado.");
            }

        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion: "
                    + e.getMessage());
        }
    }
}