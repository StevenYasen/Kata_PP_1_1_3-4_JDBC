package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    public static final String USR = "rooot";
    public static final String PSW = "rooot";
    public static Connection getConnection() {
        Connection connection = null;
        try{
        connection = DriverManager.getConnection(URL,USR,PSW);
        System.out.println("Connection is opened");

        }
        catch (SQLException e){
            System.out.println("Connection is NOT opened");
        }
        return connection;
    }
}
