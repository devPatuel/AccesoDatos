package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String DB_DRIVER = "postgresql";
    private static final String DB_HOST = "localhost";
    private static final int DB_PORT = 5433;
    private static final String DB_NAME = "ciclismo";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "test";

    public static void main(String[] args) {
        String url = "jdbc:" + DB_DRIVER + "://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
        try(Connection connection = DriverManager.getConnection(url, DB_USERNAME, DB_PASSWORD)){
            System.out.println("Conexion existosa a la base de datos");

        } catch (SQLException e ) {
            System.out.println("Error al conectar con la base de datos");
            System.out.println(e.getMessage());
        }
    }
}
