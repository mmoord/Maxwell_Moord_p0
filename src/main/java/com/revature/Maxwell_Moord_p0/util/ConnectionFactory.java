package com.revature.Maxwell_Moord_p0.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final ConnectionFactory connectionFactory = new ConnectionFactory();

    private ConnectionFactory(){

    }

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ConnectionFactory getInstance(){
        return connectionFactory;
    }

    public Connection getConnection() {

        Connection conn = null;

        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=mod_making";
        String user = "postgres";
        String password = "";

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

}
