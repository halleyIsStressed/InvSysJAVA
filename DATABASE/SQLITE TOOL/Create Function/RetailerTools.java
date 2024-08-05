package SQLTools;

import Database.SQLConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RetailerTools {
    public static void createTableRetailer() {
        SQLConnection sqlConnection = new SQLConnection();
        try {
            Connection connection = sqlConnection.getConnection();
            Statement stmt = connection.createStatement();
            String createTableRetailer = """
                   CREATE TABLE IF NOT EXISTS RETAILER (
                       RETAILER_ID INTEGER PRIMARY KEY ,
                       LOCATION VARCHAR(100) NOT NULL ,
                       CONTACT_NO VARCHAR(50) NOT NULL 
                   );
                  """;
            stmt.executeUpdate(createTableRetailer);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
