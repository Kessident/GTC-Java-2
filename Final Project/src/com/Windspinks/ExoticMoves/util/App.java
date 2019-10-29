package com.Windspinks.ExoticMoves.util;

import java.sql.*;
import java.util.Properties;

public class App{

    private static final String url = "jdbc:postgresql://localhost/exotic_moves_db";
    private static final String user = "exoticuser";
    private static final String password = "exotic moves password";



    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public static Connection connect() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        Class.forName("org.postgresql.Driver");

//        Properties props = new Properties();
//        props.setProperty("user","postgres");
//        props.setProperty("password","secret");

        Connection conn = App.connect();

        Statement st = conn.createStatement();
    }
}