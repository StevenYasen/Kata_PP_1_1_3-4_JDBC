package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USR = "rooot";
    private static final String PSW = "rooot";
    private static Connection connection = null;

    public static Connection getConnection() {

        try {
            connection = DriverManager.getConnection(URL, USR, PSW);
            System.out.println("Connection is opened");

        } catch (SQLException e) {
            System.out.println("Connection is NOT opened");
        }
        return connection;
    }
}
