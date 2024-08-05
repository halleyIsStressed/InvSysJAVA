package SQLTools;

import Database.SQLConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SupplierTools {

    public static void createTableSupplier() {
        SQLConnection sqlConnection = new SQLConnection();
        try {
            Connection connection = sqlConnection.getConnection();
            Statement stmt = connection.createStatement();
            String createTableRetailer = """
                   CREATE TABLE IF NOT EXISTS RETAILER (
                     SUPPLIER_ID INT PRIMARY KEY ,
                     RETAILER_LOCATION VARCHAR(200) NOT NULL, 
                     CONTACT_NO VARCHAR(200) NOT NULL
                   );
                  """;
            stmt.executeUpdate(createTableRetailer);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
