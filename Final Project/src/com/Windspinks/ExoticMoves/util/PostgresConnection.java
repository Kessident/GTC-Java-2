package com.Windspinks.ExoticMoves.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresConnection {

    //DB credentials, modify as needed
    private static final String HOST = "localhost";
    private static final String DATABASE = "exotic_moves_db";
    private static final String USERNAME = "exoticuser";
    private static final String PASSWORD = "exotic_moves";

    //Default postgresql port, don't change unless you know what you're doing.
    private static final String PORT = "5432";
    private static final String URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE;
    private static final String DRIVER_NAME = "org.postgresql.Driver";

    private static Connection conn;

    //Disables C3P0-pool logging
    static {
        Properties p = new Properties(System.getProperties());
        System.setProperties(p);
    }

    //private static ComboPooledDataSource cpds = new ComboPooledDataSource();

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}