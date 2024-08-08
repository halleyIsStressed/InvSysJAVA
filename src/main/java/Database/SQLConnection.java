package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
    public static SQLConnection instance = new SQLConnection();
    private static final String URL = "jdbc:sqlite:Assigment.db";
    Connection conn;

    public Connection getConnection() {
        if (conn == null)
            try {
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection(URL);
                System.out.println("Opened database successfully");
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println("Connection error: " + e.getMessage());
            }
        return conn;
    }

}
